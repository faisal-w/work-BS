/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.genericDAO.model;

import java.io.Serializable;
import java.util.List;

import br.com.bluesoft.genericDAO.model.impl.GenericDAOServiceException;

/**
 * @author Thiago Daher
 * 
 */
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * @param object
	 *            object.
	 * @throws GenericDAOServiceException
	 *             GenericDAOServiceException.
	 * 
	 *             Responsavel por armazenar o dado. Poderia ser usado tambem
	 *             para atualizar.
	 */
	void armazenar(T object) throws GenericDAOServiceException;

	/**
	 * @param object
	 *            object.
	 * @throws GenericDAOServiceException
	 *             GenericDAOServiceException.
	 * 
	 *             Responsavel por atualizar os dados.
	 */
	void atualizar(T object) throws GenericDAOServiceException;

	/**
	 * @param object
	 *            object.
	 * @throws GenericDAOServiceException
	 *             GenericDAOServiceException.
	 * 
	 *             Responsavel por remover os dados.
	 */
	void remover(T object) throws GenericDAOServiceException;

	/**
	 * @param id
	 *            id.
	 * @return o objeto por ID.
	 */
	T findById(final PK id);

	/**
	 * @return a lista dos objetos.
	 */
	List<T> findAll();

}
