/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.DAO;

import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.genericDAO.model.GenericDAO;

/**
 * @author Thiago Daher
 * 
 *         No package DAO, neste momento faco uso de uma integracao com o que
 *         esta definido com genericDAO basicamente sao metodos de armazenar,
 *         criar, remover, buscar, buscar por todos que sao genericos e ficam
 *         aguardando o objeto BEAN chegar neles. Aqui neste ponto ocorre tambem
 *         uma integracao entre o hibernate e Spring durante varios pontos do
 *         projeto sera observado comentarios Spring, neste ponto faco a chamada
 *         para o mesmo. Vale a pena ressaltar o conceito IoC(Inversion of
 *         Control) muito difundido do Spring. Mostro o uso do CRITERIA. Nao fiz
 *         uso do package TO/DTO, acho importante citar, pois usa-se muito para
 *         ser uma alternativa ao CRITERIA, onde voce tem o SQL, bem complexos,
 *         construido manualmente e mais puro.
 */
public interface FilmeDAO extends GenericDAO<FilmeBean, Integer> {

	/**
	 * @param filmeNome
	 * @return 1 para filme cadastrado 0 ainda nao cadastrado.
	 */
	Integer verificarFilmeCadastrado(final String filmeNome);

}
