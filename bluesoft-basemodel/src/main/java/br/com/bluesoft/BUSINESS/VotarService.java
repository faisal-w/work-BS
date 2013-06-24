/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.BUSINESS;

/**
 * @author Thiago Daher
 * 
 *         No package BUSINESS: fiz questão de mencionar/criar pois, essa seria
 *         a camada de servico, onde consideramos a implementacao de um
 *         requisito (diagrama de sequencia) com uma unica transacao aberta e
 *         varios DAOs suportando a mesma. Isso tambem garante em caso de rollback
 *         que nenhuma acao fique executada com sucesso pela metada.
 * 
 *         Em ambos os metodos os comentarios de cada.
 * 
 */
public interface VotarService {

	/**
	 * @param filmeId filmeId.
	 * @param quantidade quantidade.
	 * 
	 * Responsavel por inserir os votos de um dado filme.
	 * Caso o mesmo exista, fara o update.
	 * Caso nao cria o registro referente ao mesmo e faz atualizacao do dado.
	 * 
	 */
	void computarVoto(final Integer filmeId, final Integer quantidade);

	/**
	 * @param filmeId filmeId.
	 * 
	 * Responsavel por verificar se o filme ja teve votacoa.
	 * Se sim, executa a remocao da votacao e em seguida filme.
	 * Se nao, executa somente a remocao do filme. 
	 */
	void excluirVotoFilme(final Integer filmeId);
}
