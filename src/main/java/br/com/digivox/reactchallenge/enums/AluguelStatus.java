package br.com.digivox.reactchallenge.enums;

public enum AluguelStatus {
	
	EM_ANDAMENTO("Em andamento"),
	RESERVADO("Reservado"),
	FINALIZADA("Finalizado"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private AluguelStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
