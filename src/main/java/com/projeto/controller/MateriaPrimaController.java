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

import com.projeto.bean.MateriaPrima;
import com.projeto.repository.MateriaPrimaRepository;

@RestController
@RequestMapping(value="/api")
public class MateriaPrimaController {
	
	@Autowired
	MateriaPrimaRepository materiaPrimaRepository;
	
	@GetMapping("/materiaPrimas")
	public List<MateriaPrima> listarMateriaPrimas(){
		return materiaPrimaRepository.findAll();
	}
	
	@GetMapping("/materiaPrima/{id}")
	public MateriaPrima encontrarMateriaPrima(@PathVariable(value="id") Integer id) {
		return materiaPrimaRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/materiaPrima")
	public MateriaPrima cadastrarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
		return materiaPrimaRepository.save(materiaPrima);
	}
	
	@DeleteMapping("/materiaPrima")
	public void deletarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
		materiaPrimaRepository.delete(materiaPrima);
	}

	@PutMapping("/materiaPrima")
	public MateriaPrima atualizarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
		return materiaPrimaRepository.save(materiaPrima);
	}
}


