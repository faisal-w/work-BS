/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.genericDAO.model.impl;

/**
 * @author Thiago Daher
 * 
 * Comentarios nos metodos.
 *
 */
public class GenericDAOServiceException extends RuntimeException {

	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -3156454307404251984L;

	/**
	 * Construtor.
	 */
	public GenericDAOServiceException() {
		super();
	}

	/**
	 * Retorna a excecao atraves de mensagem de erro.
	 * 
	 * @param message
	 *            the error message.
	 */
	public GenericDAOServiceException(String message) {
		super(message);
	}

	/**
	 * Retorna a excecao atraves de mensagem de erro.
	 * 
	 * @param message
	 *            the error message.
	 * @param cause
	 *            the root an exception.
	 */
	public GenericDAOServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Retorna a excecao atraves de mensagem de erro.
	 * 
	 * @param message
	 *            the error message.
	 * @param cause
	 *            the root an exception.
	 */
	public GenericDAOServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
