package com.projeto.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends Pessoa{
	
	private String rg;
	private String pis;
	private Cargo cargo;
	private BigDecimal salario;
	private Usuario usuario;
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private int numero;
	private String cep;
	
	private List<PedidoVenda> listaPedidoVenda = new ArrayList<PedidoVenda>();
	
	public Funcionario() {
	}
	
	@NotNull(message = "O RG não pode ser nulo")
	@NotBlank(message = "O RG não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getRg() {
		return rg;
	}
	@NotNull(message = "O PIS não pode ser nulo")
	@NotBlank(message = "O PIS não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getPis() {
		return pis;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Cargo getCargo() {
		return cargo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public Usuario getUsuario() {
		return usuario;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getBairro() {
		return bairro;
	}
	public String getRua() {
		return rua;
	}
	public int getNumero() {
		return numero;
	}
	public String getCep() {
		return cep;
	}
	@OneToMany(mappedBy = "funcionario")
	public List<PedidoVenda> getListaPedidoVenda() {
		return listaPedidoVenda;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setListaPedidoVenda(List<PedidoVenda> listaPedidoVenda) {
		this.listaPedidoVenda = listaPedidoVenda;
	}
}
