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

import com.projeto.bean.Endereco;
import com.projeto.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/api")
public class EnderecoController {
	
	@Autowired
	EnderecoRepository EnderecoRepository;
	
	@GetMapping("/enderecos")
	public List<Endereco> listarEndereco(){
		return EnderecoRepository.findAll();
	}
	
	@GetMapping("/enderecos/{id}")
	public Endereco encontrarEndereco(@PathVariable(value="id") Integer id) {
		return EnderecoRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/endereco")
	public Endereco cadastrarEndereco(@RequestBody Endereco endereco) {
		return EnderecoRepository.save(endereco);
	}
	
	@DeleteMapping("/endereco")
	public void deletarEndereco(@RequestBody Endereco endereco) {
		EnderecoRepository.delete(endereco);
	}

	@PutMapping("/endereco")
	public Endereco atualizarEndereco(@RequestBody Endereco endereco) {
		return EnderecoRepository.save(endereco);
	}
}

