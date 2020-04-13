package com.projeto.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sq_permissao", sequenceName = "sq_permissao")
public class Permissao {

	private Integer id;
	private Cargo cargo;
	private Tela tela;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_permissao")
	public Integer getId() {
		return id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Cargo getCargo() {
		return cargo;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Tela getTela() {
		return tela;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public void setTela(Tela tela) {
		this.tela = tela;
	}
	
	
	
	
}
