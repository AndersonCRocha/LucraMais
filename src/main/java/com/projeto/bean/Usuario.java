package com.projeto.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(name="sq_usuario", sequenceName = "sq_usuario")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
public class Usuario {
	
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	
	public Usuario() {}
	
	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_usuario")
	public Integer getId() {
		return id;
	}
	@Column(unique = true)
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
