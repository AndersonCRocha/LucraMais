package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.PedidoVenda;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Integer>{

	Optional<PedidoVenda> findById(Integer id);

}
