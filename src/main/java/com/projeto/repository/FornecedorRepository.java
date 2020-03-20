package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

	Optional<Fornecedor> findById(Integer id);

}
