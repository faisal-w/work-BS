/*
 *  
 *  Vote no filme
 * 
 */
package br.com.bluesoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Thiago Daher
 * 
 */
public class GenerateDatabase {

	/**
	 * @param args
	 * 
	 * Responsavel por criar o banco de dados.
	 */
	public static void main(String[] args) {

		System.out.println("Starting...");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:br/com/**/applicationContext-bm.xml");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) context).close();
		
		System.out.println("Executed with success.");

	}

}
