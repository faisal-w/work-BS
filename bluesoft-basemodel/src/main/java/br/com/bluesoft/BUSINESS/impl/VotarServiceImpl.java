/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.BUSINESS.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.BEAN.VotarBean;
import br.com.bluesoft.BUSINESS.VotarService;
import br.com.bluesoft.DAO.FilmeDAO;
import br.com.bluesoft.DAO.VotarDAO;

/**
 * @author Thiago Daher
 * 
 *         Comentarios na interface.
 * 
 */
@Component("votarService")
public class VotarServiceImpl implements VotarService {

	/**
	 * Log4j.
	 */
	private static Log logger = LogFactory.getLog(VotarServiceImpl.class);

	/**
	 * Spring.
	 */
	@Resource
	private FilmeDAO filmeDAO;

	/**
	 * Spring.
	 */
	@Resource
	private VotarDAO votarDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.BUSINESS.VotarService#computarVoto(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void computarVoto(Integer filmeId, Integer quantidade) {

		logger.info("[Service]-Computar voto.");

		// Objetos
		VotarBean votar = new VotarBean();
		FilmeBean f = new FilmeBean();

		// Verifica se o filme corrente ja teve voto
		Integer fv = votarDAO.filmeVotado(filmeId);

		// Caso nao, insere o registro
		if (fv == null) {
			f.setId(filmeId);
			votar.setFilme(f);
			votar.setQuantidade(quantidade);
			votarDAO.armazenar(votar);
		} else {
			// Recupera o objeto votar do corrente filme
			VotarBean fc = votarDAO.votoByFilme(filmeId);

			// Somando o voto a um ja existente
			Integer voto = fc.getQuantidade() + quantidade;
			fc.setQuantidade(voto);

			votarDAO.atualizar(fc);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.bluesoft.BUSINESS.VotarService#excluirVotoFilme(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void excluirVotoFilme(Integer filmeId) {

		logger.info("[Service]-Excluir votacao e filme.");

		// Remover votacao
		VotarBean removerVotacao = votarDAO.votoByFilme(filmeId);
		if (removerVotacao != null)
			votarDAO.remover(removerVotacao);

		// Remover filme
		FilmeBean filme = filmeDAO.findById(filmeId);
		filmeDAO.remover(filme);

	}

}
