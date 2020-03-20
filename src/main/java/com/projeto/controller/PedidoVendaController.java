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

import com.projeto.bean.PedidoVenda;
import com.projeto.repository.PedidoVendaRepository;

@RestController
@RequestMapping(value="/api")
public class PedidoVendaController {
	
	@Autowired
	PedidoVendaRepository pedidoVendaRepository;
	
	@GetMapping("/pedidoVendas")
	public List<PedidoVenda> listarPedidoVendas(){
		return pedidoVendaRepository.findAll();
	}
	
	@GetMapping("/pedidoVenda/{id}")
	public PedidoVenda encontrarPedidoVenda(@PathVariable(value="id") Integer id) {
		return pedidoVendaRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/pedidoVenda")
	public PedidoVenda cadastrarPedidoVenda(@RequestBody PedidoVenda pedidoVenda) {
		return pedidoVendaRepository.save(pedidoVenda);
	}
	
	@DeleteMapping("/pedidoVenda")
	public void deletarPedidoVenda(@RequestBody PedidoVenda pedidoVenda) {
		pedidoVendaRepository.delete(pedidoVenda);
	}

	@PutMapping("/pedidoVenda")
	public PedidoVenda atualizarPedidoVenda(@RequestBody PedidoVenda pedidoVenda) {
		return pedidoVendaRepository.save(pedidoVenda);
	}
}


