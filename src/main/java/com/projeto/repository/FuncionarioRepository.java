package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	Optional<Funcionario> findById(Integer id);

}
