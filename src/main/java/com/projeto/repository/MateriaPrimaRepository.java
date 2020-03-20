package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.MateriaPrima;

public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer>{
	
	Optional<MateriaPrima> findById(Integer id);

}
