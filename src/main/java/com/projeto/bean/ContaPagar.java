package com.projeto.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class ContaPagar extends Conta{
	
	private Fornecedor fornecedor;
	private String numeroBoleto;

	public ContaPagar() {
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public String getNumeroBoleto() {
		return numeroBoleto;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}
	
	
}
