package com.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Optional<Produto> findById(Integer id);
	List<Produto> findByNomeLikeIgnoreCaseOrderByNome(String nome);
}
