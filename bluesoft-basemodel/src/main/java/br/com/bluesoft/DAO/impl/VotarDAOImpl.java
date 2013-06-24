/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.DAO.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluesoft.BEAN.VotarBean;
import br.com.bluesoft.DAO.VotarDAO;
import br.com.bluesoft.genericDAO.model.impl.HibernateDAOServiceImpl;

/**
 * @author Thiago Daher
 * 
 *         Comentarios na interface.
 * 
 */
@Service("votarDAO")
public class VotarDAOImpl extends HibernateDAOServiceImpl<VotarBean, Integer>
		implements VotarDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bluesoft.DAO.VotarDAO#filmeVotado(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Integer filmeVotado(Integer filmeId) {

		logger.info("[DAO]-Filme ja votado.");

		String sql = "SELECT voto_id " + "FROM voto " + "WHERE filme_id = ? ";

		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(sql);

		query.setParameter(0, filmeId);

		return (Integer) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bluesoft.DAO.VotarDAO#votoByFilme(java.lang.Integer)
	 */
	@Override
	@Transactional
	public VotarBean votoByFilme(Integer filmeId) {

		logger.info("[DAO]-Filme objeto com voto.");

		Criteria fv = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(VotarBean.class);

		fv.createCriteria("filme", "f", CriteriaSpecification.LEFT_JOIN);

		fv.add(Restrictions.eq("f.id", filmeId));

		return (VotarBean) fv.uniqueResult();
	}

}
