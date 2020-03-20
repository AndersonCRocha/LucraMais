package com.projeto.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Funcionario extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String rg;
	private String pis;
	private Cargo cargo;
	private Endereco endereco;
	private BigDecimal salario;
	
	private List<PedidoVenda> listaPedidoVenda;
	
	public Funcionario() {
	}
	
	@NotNull(message = "O RG não pode ser nulo")
	@Length(max = 10, min = 10, message = "O RG deve conter 10 números")
	@NotBlank(message = "O RG não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getRg() {
		return rg;
	}
	@NotNull(message = "O PIS não pode ser nulo")
	@NotBlank(message = "O PIS não pode ser em branco")
	@Column(nullable = false, unique = true)
	public String getPis() {
		return pis;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Cargo getCargo() {
		return cargo;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Endereco getEndereco() {
		return endereco;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	@Transient
	@OneToMany(mappedBy = "funcionario")
	public List<PedidoVenda> getListaPedidoVenda() {
		return listaPedidoVenda;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}
