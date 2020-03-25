package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.PedidoVenda;
import com.projeto.repository.PedidoVendaRepository;

@Service
public class PedidoVendaService {

	@Autowired
	private PedidoVendaRepository pedidoVendaRepository;
	
	public List<PedidoVenda> findAll(){
		return pedidoVendaRepository.findAll();
	}
	
	public Optional<PedidoVenda> findById(Integer id) {
		return pedidoVendaRepository.findById(id);
	}
	
	public PedidoVenda save(PedidoVenda pedidoVenda) {
		return pedidoVendaRepository.saveAndFlush(pedidoVenda);
	}
	
	public void delete(PedidoVenda pedidoVenda) {
		pedidoVendaRepository.delete(pedidoVenda);
	}
	
	public void deleteById(Integer id) {
		pedidoVendaRepository.deleteById(id);
	}
}
