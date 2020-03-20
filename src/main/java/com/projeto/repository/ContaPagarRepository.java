package com.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bean.ContaPagar;

@RestController 
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Integer>{
	
	Optional<ContaPagar> findById(Integer id);
	
}
