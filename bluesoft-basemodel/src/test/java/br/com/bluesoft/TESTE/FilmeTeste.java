/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.TESTE;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
public class FilmeTeste extends AbstractBaseJUnitTest {

	/**
	 * Spring.
	 */
	private FilmeDAO filmeDAO;

	/**
	  * Atributo/Campo.
	  */
	private FilmeBean filme;

	/**
	 * Sequencia na execucao do metodo.
	 */
	@Test
	public void testeNovoFilme() {
		filmeDAO = (FilmeDAO) context.getBean("filmeDAO");

		// Criar
		filme = new FilmeBean();
		filme.setFilmeNome("E o Vento Levou...");
		filme.setGostar(10);
		filme.setNaoGostar(3);
		filmeDAO.armazenar(filme);

		// Buscar um
		FilmeBean filme1 = filmeDAO.findById(filme.getId());
		assertEquals(filme.getFilmeNome(), filme1.getFilmeNome());

		// Buscar todos
		List<FilmeBean> allFilmes = filmeDAO.findAll();
		Assert.assertTrue(allFilmes.size() > 0);

		// Atualizar
		filme.setGostar(11);
		filmeDAO.atualizar(filme);

		// Buscar para exibir a atualzar.
		FilmeBean filme2 = filmeDAO.findById(filme.getId());
		assertEquals(filme.getGostar(), filme2.getGostar());

		// Remover
		filmeDAO.remover(filme);
	}

}
