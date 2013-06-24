/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.DAO.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.DAO.FilmeDAO;
import br.com.bluesoft.genericDAO.model.impl.HibernateDAOServiceImpl;

/**
 * @author Thiago Daher
 * 
 *         Comentarios na interface.
 * 
 */
@Service("filmeDAO")
public class FilmeDAOImpl extends HibernateDAOServiceImpl<FilmeBean, Integer>
		implements FilmeDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.DAO.FilmeDAO#verificarFilmeCadastrado(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public Integer verificarFilmeCadastrado(String filmeNome) {

		logger.info("[DAO]-Uso do CRITERIA");

		// Auxilia no retorno
		Integer existe;

		Criteria cf = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(FilmeBean.class);

		cf.add(Restrictions.eq("filmeNome", filmeNome));

		if (cf.uniqueResult() == null) {
			existe = 0;
		} else {
			existe = 1;
		}

		return existe;
	}

}
