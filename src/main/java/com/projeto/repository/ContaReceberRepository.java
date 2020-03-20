package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bean.ContaReceber;

@RestController 
public interface ContaReceberRepository extends JpaRepository<ContaReceber, Integer>{
	
	Optional<ContaReceber> findById(Integer id);
	
}