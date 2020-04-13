package com.projeto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Cargo;
import com.projeto.bean.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Integer>{
	
	Optional<Permissao> findById(Integer id);
	void deleteByCargo(Cargo cargo);
	List<Permissao> findByCargo(Cargo cargo);
}
