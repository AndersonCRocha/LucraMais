package com.projeto.bean.enums;

public enum FormaPagamento {
	A_VISTA("A vista"),
	DEBITO("Cartão de débito"),
	CREDITO("Cartão de crédito"),
	CHEQUE("Cheque"),
	BOLETO("Boleto");
	
	private String tipo;

	private FormaPagamento (String tipo){
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
