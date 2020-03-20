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

import com.projeto.bean.ContaPagar;
import com.projeto.repository.ContaPagarRepository;

@RestController
@RequestMapping(value="/api")
public class ContaPagarController {
	
	@Autowired
	ContaPagarRepository contaPagarRepository;
	
	@GetMapping("/contaPagar")
	public List<ContaPagar> listarContaPagar(){
		return contaPagarRepository.findAll();
	}
	
	@GetMapping("/contaPagar/{id}")
	public ContaPagar encontrarContaPagar(@PathVariable(value="id") Integer id) {
		return contaPagarRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/contaPagar")
	public ContaPagar cadastrarContaPagar(@RequestBody ContaPagar contaPagar) {
		return contaPagarRepository.save(contaPagar);
	}
	
	@DeleteMapping("/contaPagar")
	public void deletarContaPagar(@RequestBody ContaPagar contaPagar) {
		contaPagarRepository.delete(contaPagar);
	}

	@PutMapping("/contaPagar")
	public ContaPagar atualizarContaPagar(@RequestBody ContaPagar contaPagar) {
		return contaPagarRepository.save(contaPagar);
	}
}


