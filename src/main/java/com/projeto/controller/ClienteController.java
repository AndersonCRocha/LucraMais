package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bean.Cliente;
import com.projeto.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api")
public class ClienteController {
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente encontrarCliente(@PathVariable(value="id") Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/cliente")
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/cliente")
	public void deletarCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@PutMapping("/cliente")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
