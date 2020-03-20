package com.projeto.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projeto.bean.enums.FormaPagamento;

@Entity
@SequenceGenerator(name="sq_pedidoVenda", sequenceName = "sq_pedidoVenda")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Cliente cliente;
	private Funcionario funcionario;
	private BigDecimal valorTotal;
	private Date dataVenda;
	private FormaPagamento formaPagamento;
	private ContaReceber contaReceber;
	
	private List<ItemPedidoVenda> listaProdutoItem;

	public PedidoVenda() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_pedidoVenda")
	public Integer getId() {
		return id;
	}
	@NotNull(message = "O cliente não pode ser nulo")
	@NotBlank(message = "O cliente não pode ser em branco")
	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	public Cliente getCliente() {
		return cliente;
	}
	@NotNull(message = "O vendedor não pode ser nulo")
	@NotBlank(message = "O vendedor não pode ser em branco")
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
	@NotNull(message = "A forma de pagamento não pode ser nula")
	@NotBlank(message = "A forma de pagament não pode ser em branco")
	@Column(nullable = false)
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	@OneToOne
	public ContaReceber getContaReceber() {
		return contaReceber;
	}
	@OneToMany(mappedBy = "pedidoVenda")
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
