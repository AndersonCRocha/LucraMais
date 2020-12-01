package com.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	Optional<Funcionario> findById(Integer id);
	
	List<Funcionario> findByNomeContainingIgnoreCase(String nome);

}
