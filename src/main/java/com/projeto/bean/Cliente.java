package com.projeto.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projeto.bean.enums.SituacaoCliente;
import com.projeto.bean.enums.TipoPessoa;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private TipoPessoa tipoPessoa;
	private String rg;
	private String cnpj;
	private BigDecimal limiteCredito;
	private SituacaoCliente situacaoCliente;
	private Endereco endereco;
	
	private List<PedidoVenda> listaPedidoVenda;
	
	public Cliente() {
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	@NotNull(message = "O RG não pode ser nulo")
	@Length(max = 10, min = 10, message = "O RG deve conter 10 números")
	@NotBlank(message = "O RG não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getRg() {
		return rg;
	}
	@Length(max = 14, min = 14, message = "O CNPJ deve conter 11 números")
	@Column(unique = true)
	public String getCnpj() {
		return cnpj;
	}
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}
	public SituacaoCliente getSituacaoCliente() {
		return situacaoCliente;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Endereco getEndereco() {
		return endereco;
	}
	@Transient
	@OneToMany(mappedBy = "cliente")
	public List<PedidoVenda> getListaPedidoVenda() {
		return listaPedidoVenda;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setListaPedidoVenda(List<PedidoVenda> listaPedidoVenda) {
		this.listaPedidoVenda = listaPedidoVenda;
	}
	
}
