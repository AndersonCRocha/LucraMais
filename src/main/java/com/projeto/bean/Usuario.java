package com.projeto.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@SequenceGenerator(name="sq_usuario", sequenceName = "sq_usuario")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
public class Usuario {
	
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	private Boolean admin;
	private Funcionario funcionario;
	
	public Usuario() {}
	
	public Usuario(String nome, String login, String senha, Boolean admin) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
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
	public Boolean getAdmin() {
		return admin;
	}
	@OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)
	public Funcionario getFuncionario() {
		return funcionario;
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
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Transient
	public String getPrimeiroNome() {
		String[] primeiroNome =  this.nome.split(" ");
		return primeiroNome[0];
	}
	
}
