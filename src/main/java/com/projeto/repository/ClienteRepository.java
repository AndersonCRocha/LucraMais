package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findById(Integer id);

}
