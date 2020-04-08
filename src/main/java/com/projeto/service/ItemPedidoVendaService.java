package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.bean.ItemPedidoVenda;
import com.projeto.bean.PedidoVenda;
import com.projeto.repository.ItemPedidoVendaRepository;

@Service
@Transactional
public class ItemPedidoVendaService {
	
	@Autowired
	private ItemPedidoVendaRepository itemPedidoVendaRepository;
	
	public List<ItemPedidoVenda> findAll(){
		return itemPedidoVendaRepository.findAll();
	}
	
	public Optional<ItemPedidoVenda> findById(Integer id) {
		return itemPedidoVendaRepository.findById(id);
	}
	
	public ItemPedidoVenda save(ItemPedidoVenda itemPedidoVenda) {
		return itemPedidoVendaRepository.saveAndFlush(itemPedidoVenda);
	}
	
	public void delete(ItemPedidoVenda itemPedidoVenda) {
		itemPedidoVendaRepository.delete(itemPedidoVenda);
	}
	
	public void deleteById(Integer id) {
		itemPedidoVendaRepository.deleteById(id);
	}
	
	public List<ItemPedidoVenda> saveAll(List<ItemPedidoVenda> permissoes) {
		return itemPedidoVendaRepository.saveAll(permissoes);
	}
	
	public void deleteByPedidoVenda(PedidoVenda pedidoVenda) {
		itemPedidoVendaRepository.deleteByPedidoVenda(pedidoVenda);
	}
}
