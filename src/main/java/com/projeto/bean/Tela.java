package com.projeto.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sq_tela", sequenceName = "sq_tela")
public class Tela {

	private Integer id;
	private String uri;
	private String modulo;
	
	public Tela() {
	}
	public Tela(String modulo, String uri){
		this.modulo = modulo;
		this.uri = uri;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_tela")
	public Integer getId() {
		return id;
	}
	public String getUri() {
		return uri;
	}
	public String getModulo() {
		return modulo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}
