package com.projeto.bean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import com.projeto.bean.enums.SituacaoConta;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "sq_conta", sequenceName = "sq_conta")
public class Conta {
	
	protected Integer id;
	protected BigDecimal valor;
	protected Date dataEmissao;
	protected Date dataVencimento;
	protected SituacaoConta situacaoConta;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_conta")
	public Integer getId() {
		return id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public void setSituacaoConta(SituacaoConta situacaoConta) {
		this.situacaoConta = situacaoConta;
	}
	
	
	
}
