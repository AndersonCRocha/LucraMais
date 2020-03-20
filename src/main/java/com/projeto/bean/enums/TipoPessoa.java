package com.projeto.bean.enums;

public enum TipoPessoa {
	
	PESSOA_FISICA("Física"),
	PESSOA_JURIDICA("Jurídica");
	
	private String tipo;

	private TipoPessoa (String tipo){
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
