package com.projeto.bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.projeto.bean.enums.FormaPagamento;

@Entity
@SequenceGenerator(name="sq_pedidoVenda", sequenceName = "sq_pedidoVenda")
public class PedidoVenda {
	
	private Integer id;
	private Cliente cliente;
	private Funcionario funcionario;
	private BigDecimal valorTotal;
	private Date dataVenda;
	private FormaPagamento formaPagamento;
	private ContaReceber contaReceber;
	
	private List<ItemPedidoVenda> listaProdutoItem = new ArrayList<ItemPedidoVenda>();

	public PedidoVenda() {
	}
	public PedidoVenda(Integer id) {
		this.id = id;
	}
	
	public PedidoVenda(Cliente cliente, Funcionario funcionario, Date dataVenda) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.dataVenda = dataVenda;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_pedidoVenda")
	public Integer getId() {
		return id;
	}
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	public Cliente getCliente() {
		return cliente;
	}
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	@OneToOne
	public ContaReceber getContaReceber() {
		return contaReceber;
	}
	@OneToMany(mappedBy = "pedidoVenda", orphanRemoval = true, fetch = FetchType.EAGER)
	public List<ItemPedidoVenda> getListaProdutoItem() {
		return listaProdutoItem;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}
	public void setListaProdutoItem(List<ItemPedidoVenda> listaProdutoItem) {
		this.listaProdutoItem = listaProdutoItem;
	}
	
}
