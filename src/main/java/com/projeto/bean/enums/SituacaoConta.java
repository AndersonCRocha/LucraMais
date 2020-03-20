package com.projeto.bean.enums;

public enum SituacaoConta {
	
	EM_ABERTO("Em aberto"),
	PAGO("Pago"),
	ATRASADO("Atrasado");
	
	private String tipo;

	private SituacaoConta (String tipo){
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
