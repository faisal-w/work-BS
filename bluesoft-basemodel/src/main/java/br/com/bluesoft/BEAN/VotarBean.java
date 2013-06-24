/*
 *  
 *  Vote no filme
 * 
 */

package br.com.bluesoft.BEAN;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "voto")
public class VotarBean implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -5085046471002269013L;

	/**
	  * Atributo/Campo.
	  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voto_id")
	private Integer id;

	/**
	  * Atributo/Campo.
	  */
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private FilmeBean filme;

	/**
	  * Atributo/Campo.
	  */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_voto")
	private Date dataVoto = new Date();

	/**
	  * Atributo/Campo.
	  */
	@Column(name = "quantidade")
	private Integer quantidade;

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
	 * @return the filme
	 */
	public FilmeBean getFilme() {
		return filme;
	}

	/**
	 * @param filme
	 *            the filme to set
	 */
	public void setFilme(FilmeBean filme) {
		this.filme = filme;
	}

	/**
	 * @return the dataVoto
	 */
	public Date getDataVoto() {
		return dataVoto;
	}

	/**
	 * @param dataVoto
	 *            the dataVoto to set
	 */
	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
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
				+ ((dataVoto == null) ? 0 : dataVoto.hashCode());
		result = prime * result + ((filme == null) ? 0 : filme.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((quantidade == null) ? 0 : quantidade.hashCode());
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
		VotarBean other = (VotarBean) obj;
		if (dataVoto == null) {
			if (other.dataVoto != null)
				return false;
		} else if (!dataVoto.equals(other.dataVoto))
			return false;
		if (filme == null) {
			if (other.filme != null)
				return false;
		} else if (!filme.equals(other.filme))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
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
		return "VotarBean [id=" + id + ", filme=" + filme + ", dataVoto="
				+ dataVoto + ", quantidade=" + quantidade + "]";
	}

}
