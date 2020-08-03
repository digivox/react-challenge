package br.com.digivox.reactchallenge.enums;

public enum ReservaStatus {
	
	CRIADA("Criada"),
	EM_ANDAMENTO("Em andamento"),
	FINALIZADA("Finalizada"),
	CANCELADA("Cancelada");
	
	private String descricao;
	
	private ReservaStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
