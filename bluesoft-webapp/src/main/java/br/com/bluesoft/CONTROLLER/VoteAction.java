/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.CONTROLLER;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;

import br.com.bluesoft.BEAN.FilmeBean;
import br.com.bluesoft.BEAN.VotarBean;
import br.com.bluesoft.BUSINESS.VotarService;
import br.com.bluesoft.DAO.FilmeDAO;
import br.com.bluesoft.DAO.VotarDAO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Thiago Daher
 * 
 *         No package CONTROLLER, encontra-se todas as actions. Para visualizar
 *         o mapeamento das mesmas acessar o arquivos struts*.xml.
 * 
 *         Abaixo de cada metodo sua funcao.
 * 
 */
public class VoteAction extends ActionSupport implements SessionAware {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -3179021559138070902L;

	/**
	 * Log4j.
	 */
	private static Log logger = LogFactory.getLog(VoteAction.class);

	/**
	 * Map.
	 */
	@SuppressWarnings("rawtypes")
	private Map session;

	/**
	 * Spring.
	 */
	@Resource
	private FilmeDAO filmeDAO;

	/**
	 * Spring.
	 */
	@Resource
	private VotarDAO votarDAO;

	/**
	 * Spring.
	 */
	@Resource
	private VotarService votarService;

	/**
	 * Atributo/Campo.
	 */
	private String filmeNome;

	/**
	 * Atributo/Campo.
	 */
	private Integer filmeId;

	/**
	 * Atributo/Campo.
	 */
	private String tipo;

	/**
	 * Atributo/Campo.
	 */
	private Integer quantidade;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	/**
	 * Carregando os filmes e colocando na session.
	 */
	@SuppressWarnings("unchecked")
	private void carregandoFilmes() {

		logger.info("[Action]-Carregando a lista de filmes.");

		List<FilmeBean> filmes = filmeDAO.findAll();
		session.put("filmes", filmes);
	}

	/**
	 * Action que carrega os filme.
	 */
	public String iniciandoVotacao() {

		logger.info("[Action]-Iniciando Votacao.");

		carregandoFilmes();

		return SUCCESS;
	}

	/**
	 * Action que executa a votacao.
	 */
	public String gostarNaoGostarFilme() {

		logger.info("[Action]-Iniciando Votacao.");
		session.remove("filmes");

		// Recupera o objeto filme
		FilmeBean fgng = filmeDAO.findById(filmeId);

		if ("gostar".equals(tipo)) {
			Integer dadosAtuais = fgng.getGostar();
			fgng.setGostar(dadosAtuais + 1);
		} else {
			Integer dadosAtuais = fgng.getNaoGostar();
			fgng.setNaoGostar(dadosAtuais + 1);
		}

		// Atualiza o objeto.
		filmeDAO.atualizar(fgng);

		// Atualiza a sessao
		carregandoFilmes();

		return SUCCESS;
	}

	/**
	 * Action que carregada os filmes para criacao, leitura, edicao, remocao.
	 */
	public String iniciandoFilme() {

		logger.info("[Action]-Adicionando novo filme.");
		session.remove("filmes");

		carregandoFilmes();

		return SUCCESS;
	}

	/**
	 * Action que criar um filme. Fiz este caso para ilustrar a diferenca do que
	 * e ter a camada de servico e ter que fazer uso de DAOs.
	 */
	public String novoFilme() {

		logger.info("[Action]-Adicionando novo filme.");
		session.remove("filmes");

		FilmeBean filme = new FilmeBean();
		filme.setFilmeNome(filmeNome.toUpperCase());
		filme.setGostar(0);
		filme.setNaoGostar(0);

		if (filmeId == null) {
			Integer existe = filmeDAO.verificarFilmeCadastrado(filme
					.getFilmeNome());
			if (existe == 0)
				// Cria o filme
				filmeDAO.armazenar(filme);
		} else {
			// Atualiza o nome do filme
			filme.setId(filmeId);
			filmeDAO.atualizar(filme);
		}

		carregandoFilmes();
		return SUCCESS;
	}

	/**
	 * Excluindo um filme usando a camada de servico(business).
	 */
	public String excluirFilme() {

		logger.info("[Action]-Excluindo filme.");
		session.remove("filmes");

		// Remover
		votarService.excluirVotoFilme(filmeId);

		carregandoFilmes();
		return SUCCESS;
	}

	/**
	 * Carregando os votos.
	 */
	@SuppressWarnings("unchecked")
	private void carregandoVotos() {

		logger.info("[Action]-Carregando votos.");

		List<VotarBean> votoscomputados = votarDAO.findAll();
		session.put("votoscomputados", votoscomputados);

	}

	/**
	 * Action que salva os votos.
	 */
	public String computarVoto() {

		logger.info("[Action]-Computar Voto.");
		session.remove("votoscomputados");

		votarService.computarVoto(filmeId, quantidade);

		return NONE;
	}

	/**
	 * Action que exibi o resultado parcial e suporta na montagem do grafico.
	 */
	public String resultadoParcial() {

		logger.info("[Action]-Resultado Parcial.");
		session.remove("votoscomputados");

		carregandoVotos();
		return SUCCESS;
	}

	/**
	 * @return the filmeNome
	 */
	public String getFilmeNome() {
		return filmeNome;
	}

	/**
	 * @param filmeNome
	 *            the filmeNome to set
	 */
	public void setFilmeNome(String filmeNome) {
		this.filmeNome = filmeNome;
	}

	/**
	 * @return the filmeId
	 */
	public Integer getFilmeId() {
		return filmeId;
	}

	/**
	 * @param filmeId
	 *            the filmeId to set
	 */
	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
