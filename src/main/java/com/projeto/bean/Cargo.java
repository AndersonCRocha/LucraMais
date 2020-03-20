package com.projeto.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SequenceGenerator(name="sq_cargo", sequenceName = "sq_cargo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	
	private List<Funcionario> listaFuncionario;
	
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
	@Transient
	@OneToMany(mappedBy = "cargo")
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
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
	
	
}
