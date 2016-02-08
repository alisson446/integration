package br.com.integration.model.contato;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.integration.model.ClienteEntity;

@Entity
public class Contato extends ClienteEntity {
	
	@Column(name = "telefone", nullable = false) 
	private String telefone;
	
	@Column(name = "operadora", nullable = false) 
	private OperadoraEnum operadora;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public OperadoraEnum getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraEnum operadora) {
		this.operadora = operadora;
	}

}	
