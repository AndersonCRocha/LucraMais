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
@SequenceGenerator(name="sq_materiaPrima", sequenceName = "sq_materiaPrima")
public class MateriaPrima {
	
	private Integer id;
	private String nome;
	private String unidadeMedida;
	private String descricaoNutricional;
	private Fornecedor fornecedor;
	private BigDecimal precoCompra;
	
	public MateriaPrima() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_materiaPrima")
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
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	
}
