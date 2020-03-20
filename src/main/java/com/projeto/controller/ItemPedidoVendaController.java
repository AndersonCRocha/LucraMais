package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bean.ItemPedidoVenda;
import com.projeto.repository.ItemPedidoVendaRepository;

@RestController
@RequestMapping(value="/api")
public class ItemPedidoVendaController {

	@Autowired
	ItemPedidoVendaRepository itemPedidoVendaRepository;
	
	@GetMapping("/produtoItens")
	public List<ItemPedidoVenda> listarProdutoItems(){
		return itemPedidoVendaRepository.findAll();
	}
	
	@GetMapping("/produtoItens/{id}")
	public ItemPedidoVenda encontrarProdutoItem(@PathVariable(value="id") Integer id) {
		return itemPedidoVendaRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/produtoItem")
	public ItemPedidoVenda cadastrarProdutoItem(@RequestBody ItemPedidoVenda itemPedidoVenda) {
		return itemPedidoVendaRepository.save(itemPedidoVenda);
	}
	
	@DeleteMapping("/produtoItem")
	public void deletarProdutoItem(@RequestBody ItemPedidoVenda itemPedidoVenda) {
		itemPedidoVendaRepository.delete(itemPedidoVenda);
	}

	@PutMapping("/produtoItem")
	public ItemPedidoVenda atualizarProdutoItem(@RequestBody ItemPedidoVenda itemPedidoVenda) {
		return itemPedidoVendaRepository.save(itemPedidoVenda);
	}

}

