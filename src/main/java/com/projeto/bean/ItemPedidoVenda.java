package com.projeto.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@SequenceGenerator(name="sq_produtoItem", sequenceName = "sq_produtoItem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemPedidoVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int quantidade;
	private Produto produto;
	private PedidoVenda pedidoVenda;
	private ContaReceber contaReceber;
	
	public ItemPedidoVenda() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_produtoItem")
	public Integer getId() {
		return id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Produto getProduto() {
		return produto;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public ContaReceber getContaReceber() {
		return contaReceber;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}
	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}
	
}
