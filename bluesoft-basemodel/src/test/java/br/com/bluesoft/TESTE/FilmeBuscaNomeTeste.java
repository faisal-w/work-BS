/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.TESTE;

import org.junit.Assert;
import org.junit.Test;

import br.com.bluesoft.AbstractBaseJUnitTest;
import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.DAO.FilmeDAO;

/**
 * @author Thiago Daher
 * 
 * Comentarios nos metodos.
 *
 */
public class FilmeBuscaNomeTeste extends AbstractBaseJUnitTest {

	/**
	 * Spring.
	 */
	private FilmeDAO filmeDAO;

	/**
	 * Sequencia na execucao do metodo.
	 */
	@Test
	public void testeBuscaFilme() {
		filmeDAO = (FilmeDAO) context.getBean("filmeDAO");

		// Criar
		FilmeBean f = new FilmeBean();
		f = new FilmeBean();
		f.setFilmeNome("E o Vento Levou...");
		f.setGostar(0);
		f.setNaoGostar(0);

		// Buscar por nome do filme
		Integer existe = filmeDAO.verificarFilmeCadastrado(f.getFilmeNome());
		if (existe == null){
			filmeDAO.armazenar(f);
		}
		
		existe = filmeDAO.verificarFilmeCadastrado(f.getFilmeNome());
		Assert.assertTrue(existe != null);
	}
}
