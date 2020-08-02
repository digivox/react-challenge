package br.com.digivox.reactchallenge.enums;

public enum LivroStatus {
	
	DISPONIVEL("Disponível"),
	RESERVADO("Reservado"),
	EM_UTILIZACAO("Em utilização"),
	INDISPONIVEL("Indisponível");

	private String descricao;
	
	private LivroStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
