package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Fornecedor;
import com.projeto.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> findAll(){
		return fornecedorRepository.findAll();
	}
	
	public Optional<Fornecedor> findById(Integer id) {
		return fornecedorRepository.findById(id);
	}
	
	public Fornecedor save(Fornecedor fornecedor) {
		return fornecedorRepository.saveAndFlush(fornecedor);
	}
	
	public void delete(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}
	
	public void deleteById(Integer id) {
		fornecedorRepository.deleteById(id);
	}

	public List<Fornecedor> findByNome(String nome) {
		return fornecedorRepository.findByNomeContainingIgnoreCase(nome);
	}
}
