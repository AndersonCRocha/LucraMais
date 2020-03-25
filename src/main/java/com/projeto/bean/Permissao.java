package com.projeto.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="sq_permissao", sequenceName = "sq_permissao")
public class Permissao {

	private Integer id;
	private String uri;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_permissao")
	public Integer getId() {
		return id;
	}
	public String getUri() {
		return uri;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
