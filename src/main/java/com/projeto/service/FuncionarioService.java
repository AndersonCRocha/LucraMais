package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Funcionario;
import com.projeto.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> findById(Integer id) {
		return funcionarioRepository.findById(id);
	}
	
	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.saveAndFlush(funcionario);
	}
	
	public void delete(Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
	}
	
	public void deleteById(Integer id) {
		funcionarioRepository.deleteById(id);
	}
}
