package com.projeto.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sq_cargo", sequenceName = "sq_cargo")
public class Cargo {

	private Integer id;
	private String descricao;
	
	private List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	private List<Permissao> listaPermissao = new ArrayList<Permissao>();
	
	public Cargo() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_cargo")
	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	@OneToMany(mappedBy = "cargo")
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
	@OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER, orphanRemoval = true)
	public List<Permissao> getListaPermissao() {
		return listaPermissao;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	public void setListaPermissao(List<Permissao> listaPermissao) {
		this.listaPermissao = listaPermissao;
	}
	
}
