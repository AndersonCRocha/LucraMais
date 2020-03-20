package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.bean.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByLogin(String login);
}
