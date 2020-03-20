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

import com.projeto.bean.ContaReceber;
import com.projeto.repository.ContaReceberRepository;

@RestController
@RequestMapping(value="/api")
public class ContaReceberController {
	
	@Autowired
	ContaReceberRepository contaReceberRepository;
	
	@GetMapping("/contaReceber")
	public List<ContaReceber> listarContaReceber(){
		return contaReceberRepository.findAll();
	}
	
	@GetMapping("/contaReceber/{id}")
	public ContaReceber encontrarContaReceber(@PathVariable(value="id") Integer id) {
		return contaReceberRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/contaReceber")
	public ContaReceber cadastrarContaReceber(@RequestBody ContaReceber contaReceber) {
		return contaReceberRepository.save(contaReceber);
	}
	
	@DeleteMapping("/contaReceber")
	public void deletarContaReceber(@RequestBody ContaReceber contaReceber) {
		contaReceberRepository.delete(contaReceber);
	}

	@PutMapping("/contaReceber")
	public ContaReceber atualizarContaReceber(@RequestBody ContaReceber contaReceber) {
		return contaReceberRepository.save(contaReceber);
	}
}


