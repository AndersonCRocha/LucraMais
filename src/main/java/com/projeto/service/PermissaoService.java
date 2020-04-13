package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.bean.Cargo;
import com.projeto.bean.Permissao;
import com.projeto.repository.PermissaoRepository;

@Service
@Transactional
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
	
	public List<Permissao> saveAll(List<Permissao> permissoes) {
		return permissaoRepository.saveAll(permissoes);
	}
	
	public void deleteByCargo(Cargo cargo) {
		permissaoRepository.deleteByCargo(cargo);
	}
	
	public List<Permissao> findByCargo(Cargo cargo) {
		return permissaoRepository.findByCargo(cargo);
	}
}
