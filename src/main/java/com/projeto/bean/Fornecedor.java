package com.projeto.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Fornecedor extends Pessoa {
	
	private String cnpj;
	
	private List<MateriaPrima> listaMateriaPrima = new ArrayList<MateriaPrima>();
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private List<ContaPagar> listaContaPagar = new ArrayList<ContaPagar>();
	
	public Fornecedor() {
	}
	
	@OneToMany(mappedBy = "fornecedor")
	public List<MateriaPrima> getListaMateriaPrima() {
		return listaMateriaPrima;
	}
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	@OneToMany(mappedBy = "fornecedor")
	public List<ContaPagar> getListaContaPagar() {
		return listaContaPagar;
	}
	@NotNull(message = "O CNPJ não pode ser nulo")
	@NotBlank(message = "O CNPJ não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getCnpj() {
		return cnpj;
	}
	public void setListaMateriaPrima(List<MateriaPrima> listaMateriaPrima) {
		this.listaMateriaPrima = listaMateriaPrima;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	public void setListaContaPagar(List<ContaPagar> listaContaPagar) {
		this.listaContaPagar = listaContaPagar;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
