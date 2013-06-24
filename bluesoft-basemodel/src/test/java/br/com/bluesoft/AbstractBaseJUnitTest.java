/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Thiago Daher
 * 
 *         Carregando o contexto com integracao com Spring para validacao dos
 *         testes.
 * 
 */
public class AbstractBaseJUnitTest {

	/**
	  * Atributo/Campo.
	  */
	protected ApplicationContext context = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath*:br/com/**/applicationContext-bm.xml");
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		((ClassPathXmlApplicationContext) context).close();
	}

}
