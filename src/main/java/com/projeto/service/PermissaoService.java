package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Permissao;
import com.projeto.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public List<Permissao> findAll(){
		return permissaoRepository.findAll();
	}
	
	public Optional<Permissao> findById(Integer id) {
		return permissaoRepository.findById(id);
	}
	
	public Permissao save(Permissao permissao) {
		return permissaoRepository.saveAndFlush(permissao);
	}
	
	public void delete(Permissao permissao) {
		permissaoRepository.delete(permissao);
	}
	
	public void deleteById(Integer id) {
		permissaoRepository.deleteById(id);
	}
}
