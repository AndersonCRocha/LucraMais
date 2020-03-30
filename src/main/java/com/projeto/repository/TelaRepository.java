package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Tela;

public interface TelaRepository extends JpaRepository<Tela, Integer>{

	Optional<Tela> findById(Integer id);
}
