package com.projeto.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sq_produto", sequenceName = "sq_produto")
public class Produto {
	
	private Integer id;
	private String nome;
	private String unidadeMedida;
	private String descricaoNutricional;
	private BigDecimal precoVenda;
	private Fornecedor fornecedor;
	private BigDecimal precoCompra;
	
	public Produto() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_produto")
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public String getDescricaoNutricional() {
		return descricaoNutricional;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public void setDescricaoNutricional(String descricaoNutricional) {
		this.descricaoNutricional = descricaoNutricional;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}
	
}
