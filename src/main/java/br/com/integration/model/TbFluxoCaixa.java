package br.com.integration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fluxoCaixa")
public class TbFluxoCaixa implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@Id
	@Column(name = "codigofluxo", nullable = false)
	private String codigoFluxo;

	@Column(name = "descrifluxo", nullable = false)	
	private String descricao;

	@Column(name = "tipofluxo", nullable = false)
	private String tipo;

	@Column(name = "classefluxo", nullable = false)
	private String classe;

	@Column(name = "statusfluxo")
	private String status;

	@Column(name = "ctbconta")
	private String contaContabil;

	@Column(name = "ctbapendi")
	private Integer apendiceContabil;

	public String getCodigoFluxo() {
		return codigoFluxo;
	}

	public void setCodigoFluxo(String codigoFluxo) {
		this.codigoFluxo = codigoFluxo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public Integer getApendiceContabil() {
		return apendiceContabil;
	}

	public void setApendiceContabil(Integer apendiceContabil) {
		this.apendiceContabil = apendiceContabil;
	}
	
}
