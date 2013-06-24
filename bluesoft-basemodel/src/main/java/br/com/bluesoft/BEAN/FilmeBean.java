/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.BEAN;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thiago Daher
 * 
 *         No package BEAN, foi usado o conceito de POJO(Plain Old Java Object),
 *         aqui tem as anotacoes do hibernate que basicamente é um reflexo das
 *         tabelas banco. Eu fiz uso de dois objetos para mostrar um pouco mais
 *         sobre as anotacoes do hibernate bem como o funcionamento de
 *         relacionamento entre os mesmos neste caso fiz uso @ManyToOne.
 * 
 */
@Entity
@Table(name = "filme")
public class FilmeBean implements Serializable {

	/**
	  * Serial ID.
	  */
	private static final long serialVersionUID = -4916687772267655504L;

	/**
	  * Atributo/Campo.
	  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "filme_id")
	private Integer id;

	/**
	  * Atributo/Campo.
	  */
	@Column(name = "filme_nome", length = 100)
	private String filmeNome;

	/**
	  * Atributo/Campo.
	  */
	@Column(name = "gostar")
	private Integer gostar;

	/**
	  * Atributo/Campo.
	  */
	@Column(name = "nao_gostar")
	private Integer naoGostar;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the gostar
	 */
	public Integer getGostar() {
		return gostar;
	}

	/**
	 * @param gostar
	 *            the gostar to set
	 */
	public void setGostar(Integer gostar) {
		this.gostar = gostar;
	}

	/**
	 * @return the naoGostar
	 */
	public Integer getNaoGostar() {
		return naoGostar;
	}

	/**
	 * @param naoGostar
	 *            the naoGostar to set
	 */
	public void setNaoGostar(Integer naoGostar) {
		this.naoGostar = naoGostar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filmeNome == null) ? 0 : filmeNome.hashCode());
		result = prime * result + ((gostar == null) ? 0 : gostar.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((naoGostar == null) ? 0 : naoGostar.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeBean other = (FilmeBean) obj;
		if (filmeNome == null) {
			if (other.filmeNome != null)
				return false;
		} else if (!filmeNome.equals(other.filmeNome))
			return false;
		if (gostar == null) {
			if (other.gostar != null)
				return false;
		} else if (!gostar.equals(other.gostar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naoGostar == null) {
			if (other.naoGostar != null)
				return false;
		} else if (!naoGostar.equals(other.naoGostar))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FilmeBean [id=" + id + ", filmeNome=" + filmeNome + ", gostar="
				+ gostar + ", naoGostar=" + naoGostar + "]";
	}

}
