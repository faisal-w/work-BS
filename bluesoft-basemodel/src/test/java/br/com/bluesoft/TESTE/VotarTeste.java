/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.TESTE;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.bluesoft.AbstractBaseJUnitTest;
import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.BEAN.VotarBean;
import br.com.bluesoft.BUSINESS.VotarService;
import br.com.bluesoft.DAO.FilmeDAO;
import br.com.bluesoft.DAO.VotarDAO;

/**
 * @author Thiago Daher
 * 
 * Comentarios nos metodos.
 *
 */
public class VotarTeste extends AbstractBaseJUnitTest {

	/**
	 * Spring.
	 */
	private VotarService votarService;

	/**
	 * Spring.
	 */
	private FilmeDAO filmeDAO;

	/**
	 * Spring.
	 */
	private VotarDAO votarDAO;

	/**
	 * Sequencia na execucao do metodo.
	 */
	@Test
	public void testeVoto() {

		votarService = (VotarService) context.getBean("votarService");
		filmeDAO = (FilmeDAO) context.getBean("filmeDAO");
		votarDAO = (VotarDAO) context.getBean("votarDAO");

		// Cria o filme
		FilmeBean f = new FilmeBean();
		f = new FilmeBean();
		f.setFilmeNome("Duro de Matar");
		f.setGostar(0);
		f.setNaoGostar(0);
		filmeDAO.armazenar(f);

		// Confirma
		votarService.computarVoto(f.getId(), 50);

		// Verifica
		VotarBean votar = votarDAO.votoByFilme(f.getId());

		// Verifica se o novo filme foi cadastrado
		assertEquals(f.getFilmeNome(), votar.getFilme().getFilmeNome());

		// Verifica se os 50 votos foram atualizados
		assertEquals(Integer.valueOf(50), votar.getQuantidade());

	}
}
