package com.projeto.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.bean.Usuario;
import com.projeto.service.UsuarioService;

@Configuration
public class UserInit {

	@Autowired
	private UsuarioService usuarioService;
	
	@Bean
	public void criaUsuario(){
		if(usuarioService.findByLogin("admin") == null) {
			usuarioService.save(new Usuario("Administrador","admin","admin"));
		}
	}
}
