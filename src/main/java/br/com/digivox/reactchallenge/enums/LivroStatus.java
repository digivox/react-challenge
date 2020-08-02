package br.com.digivox.reactchallenge.enums;

public enum LivroStatus {
	
	DISPONIVEL(1, "Disponível"),
	RESERVADO(2, "Reservado"),
	EM_UTILIZACAO(3, "Em utilização"),
	INDISPONIVEL(4, "Indisponível");
	
	private int codigo;
	private String descricao;
	
	private LivroStatus(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static LivroStatus toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(LivroStatus status : LivroStatus.values()) {
			if(codigo.equals(status)) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ codigo);
		
	}	

}
