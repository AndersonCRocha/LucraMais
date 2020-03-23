package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Cliente;
import com.projeto.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.saveAndFlush(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public void deleteById(Integer id) {
		clienteRepository.deleteById(id);
	}
}
