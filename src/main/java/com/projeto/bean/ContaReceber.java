package com.projeto.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ContaReceber extends Conta{
	
	private Cliente cliente;
	private PedidoVenda pedidoVenda;
	
	private List<ItemPedidoVenda> listaProdutoItem;

	public ContaReceber() {
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Cliente getCliente() {
		return cliente;
	}
	@OneToOne(mappedBy = "contaReceber")
	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}
	@Transient
	@OneToMany(mappedBy = "contaReceber")
	public List<ItemPedidoVenda> getListaProdutoItem() {
		return listaProdutoItem;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public void setListaProdutoItem(List<ItemPedidoVenda> listaProdutoItem) {
		this.listaProdutoItem = listaProdutoItem;
	}
	
	
	
}
