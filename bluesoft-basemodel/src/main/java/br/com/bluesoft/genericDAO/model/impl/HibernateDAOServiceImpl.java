/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.genericDAO.model.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluesoft.genericDAO.model.GenericDAO;

/**
 * @author Thiago Daher
 * 
 *         Responsavel pela implementacao dos metodos. Totalmente integrado com
 *         Spring.
 * 
 */
public abstract class HibernateDAOServiceImpl<T, PK extends Serializable>
		extends HibernateDaoSupport implements GenericDAO<T, PK> {

	/**
	 * Responsavel pelos logs.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Atributo/Campo.
	 */
	protected Class<T> persistentClass;

	/**
	 * Responsavel por suporatar a parte webapp.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HibernateDAOServiceImpl() {
		Class genericDaoClass;
		if (this.getClass().getSuperclass() == HibernateDAOServiceImpl.class) {
			genericDaoClass = this.getClass();
		} else {
			Class cglibConcreteDaoClass = this.getClass();
			genericDaoClass = cglibConcreteDaoClass.getSuperclass();
		}
		ParameterizedType genericDaoType = (ParameterizedType) genericDaoClass
				.getGenericSuperclass();
		Type entityType = (genericDaoType).getActualTypeArguments()[0];
		persistentClass = (Class<T>) entityType;

	}

	/**
	 * @param sessionFactory
	 *            sessionFactory.
	 */
	@Autowired
	public final void setHibernateSessionFactory(
			@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.genericDAO.model.GenericDAO#armazenar(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void armazenar(T entity) throws GenericDAOServiceException {

		logger.info("Saving datas based on BEAN " + persistentClass + ".");

		if (entity == null) {
			throw new GenericDAOServiceException("Entidade nao pode ser nula.");
		}

		try {
			getHibernateTemplate().save(entity);
			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

			logger.info("The datas was saved with success.");
		} catch (Exception e) {
			logger.info("Erro ao persistir entidade.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.genericDAO.model.GenericDAO#atualizar(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void atualizar(T entity) throws GenericDAOServiceException {

		if (entity == null) {
			throw new GenericDAOServiceException("Entidade nao pode ser nula.");
		}

		try {
			getHibernateTemplate().merge(entity);
		} catch (Exception e) {
			throw new GenericDAOServiceException("Erro ao persistir entidade.",
					e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.genericDAO.model.GenericDAO#remover(java.lang.Object)
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(T entity) throws GenericDAOServiceException {

		if (entity == null) {
			throw new GenericDAOServiceException("Entidade nao pode ser nula.");
		}

		try {
			getHibernateTemplate().delete(entity);
		} catch (Exception e) {
			throw new GenericDAOServiceException("Erro ao remover entidade.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.genericDAO.model.GenericDAO#findById(java.io.Serializable
	 * )
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findById(PK id) {
		logger.info("Find " + persistentClass + "by id.");
		return (T) getHibernateTemplate().get(persistentClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bluesoft.genericDAO.model.GenericDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll() {
		logger.info("Find All" + persistentClass);
		return (getHibernateTemplate().find("from " + persistentClass.getName()
				+ " x"));
	}

}
