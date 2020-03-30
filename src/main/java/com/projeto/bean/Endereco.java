package com.projeto.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "sq_endereco", sequenceName = "sq_endereco")
public class Endereco {
	
	private Integer id;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String complemento;
	private String cep;
	
	private List<Cliente> ListaCliente;
	private List<Funcionario> ListaFuncionarioO;
	
	public Endereco() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_endereco")
	public Integer getId() {
		return id;
	}
	public String getCidade() {
		return cidade;
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
	public String getComplemento() {
		return complemento;
	}
	public String getCep() {
		return cep;
	}
	@Transient
	@OneToMany(mappedBy = "endereco")
	public List<Cliente> getListaCliente() {
		return ListaCliente;
	}
	@Transient
	@OneToMany(mappedBy = "endereco")
	public List<Funcionario> getListaFuncionarioO() {
		return ListaFuncionarioO;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
