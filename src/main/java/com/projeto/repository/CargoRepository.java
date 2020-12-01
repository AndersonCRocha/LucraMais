package com.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	Optional<Cargo> findById(Integer id);

	List<Cargo> findByDescricaoContainingIgnoreCase(String descricao);

}
