package com.projeto.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.projeto.bean.enums.SituacaoCliente;
import com.projeto.bean.enums.TipoPessoa;

@Entity
public class Cliente extends Pessoa {
	
	private TipoPessoa tipoPessoa;
	private String rg;
	private String cnpj;
	private BigDecimal limiteCredito;
	private SituacaoCliente situacaoCliente;
	private Endereco endereco;
	
	private List<PedidoVenda> listaPedidoVenda = new ArrayList<PedidoVenda>();
	
	public Cliente() {
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	@NotNull(message = "O RG não pode ser nulo")
	@NotBlank(message = "O RG não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getRg() {
		return rg;
	}
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
