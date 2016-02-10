package br.com.integration.model.contato;

public enum OperadoraEnum {
	OI(0,"OI"), VIVO(1,"Vivo"), TIM(2,"TIM"), EMBRATEL(3,"Emb"), GVT(4,"GVT");
	
	private int id;
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private OperadoraEnum(int id, String descri){
		this.id = id;
		descricao = descri;
	}
}
