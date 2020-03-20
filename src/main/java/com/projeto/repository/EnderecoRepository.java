package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	Optional<Endereco> findById(Integer id);

}
