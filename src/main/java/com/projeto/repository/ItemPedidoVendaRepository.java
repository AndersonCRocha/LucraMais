package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.ItemPedidoVenda;
import com.projeto.bean.PedidoVenda;

public interface ItemPedidoVendaRepository extends JpaRepository<ItemPedidoVenda, Integer>{
	
	Optional<ItemPedidoVenda> findById(Integer id);
	void deleteByPedidoVenda(PedidoVenda pedidoVenda);
}
