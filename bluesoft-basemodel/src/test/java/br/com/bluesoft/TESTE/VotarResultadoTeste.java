/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.TESTE;

import org.junit.Test;

import br.com.bluesoft.AbstractBaseJUnitTest;
import br.com.bluesoft.BEAN.VotarBean;
import br.com.bluesoft.DAO.VotarDAO;

/**
 * @author Thiago Daher
 * 
 * Comentarios nos metodos.
 *
 */
public class VotarResultadoTeste extends AbstractBaseJUnitTest {
	/**
	 * Spring.
	 */
	private VotarDAO votarDAO;

	/**
	 * Sequencia na execucao do metodo.
	 */
	@Test
	public void testeVoto() {

		votarDAO = (VotarDAO) context.getBean("votarDAO");

		//For com sysout para visualizar os dados.
		for (VotarBean v : votarDAO.findAll()) {
			System.out.println(v.getFilme().getId() + " Nome: "
					+ v.getFilme().getFilmeNome() + " Total:"
					+ v.getQuantidade());
		}

	}
}
