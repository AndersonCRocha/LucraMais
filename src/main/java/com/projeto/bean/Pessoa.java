package com.projeto.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(name="sq_pessoa", sequenceName = "sq_pessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String nome;
	protected String email;
	protected String telefone;
	protected String cpf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_pessoa")
	public Integer getId() {
		return id;
	}
	@NotNull(message = "O nome não pode ser nulo")
	@Length(max = 200, message = "O nome não pode ter mais de {max} caracteres")
	@NotBlank(message = "O nome não pode ser em branco")
	@Column(nullable = false, length = 200)
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
