package br.com.digivox.reactchallenge.enums;

public enum ClienteStatus {
	
	ATIVO(1, "Ativo"),
	DESATIVADO(2, "Desativado");
	
	private int codigo;
	private String descricao;
	
	private ClienteStatus(int cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public static ClienteStatus toEnum(Integer codigo) {
		if(codigo == null)
			return null;
		
		for(ClienteStatus status : ClienteStatus.values()) {
			if(codigo.equals(status.getCodigo())) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	

}
