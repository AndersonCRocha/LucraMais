package com.projeto.bean.enums;

public enum SituacaoCliente {
	RUIM("Ruim"),
	REGULAR("Regular"),
	BOM("Bom"),
	OTIMO("Ótimo");
	
	private String tipo;

	private SituacaoCliente (String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return this.tipo;
	}
}
