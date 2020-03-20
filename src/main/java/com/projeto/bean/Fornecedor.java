package com.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fornecedor extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	
	private List<MateriaPrima> listaMateriaPrima;
	private List<Produto> listaProduto;
	private List<ContaPagar> listaContaPagar;
	
	public Fornecedor() {
	}
	
	@Transient
	@OneToMany(mappedBy = "fornecedor")
	public List<MateriaPrima> getListaMateriaPrima() {
		return listaMateriaPrima;
	}
	@Transient
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	@Transient
	@OneToMany(mappedBy = "fornecedor")
	public List<ContaPagar> getListaContaPagar() {
		return listaContaPagar;
	}
	@NotNull(message = "O CNPJ não pode ser nulo")
	@Length(max = 14, min = 14, message = "O CNPJ deve conter 14 números")
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
