package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Usuario;
import com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}
	
	public Usuario save(Usuario usuario) {
		if(usuario.getId() != null) {
			Usuario usuarioBanco = usuarioRepository.findByLogin(usuario.getLogin());
			usuario.setSenha(usuarioBanco.getSenha());
		}
		
		return usuarioRepository.saveAndFlush(usuario);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public void deleteById(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
