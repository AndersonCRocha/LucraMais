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

import com.projeto.bean.Cargo;
import com.projeto.repository.CargoRepository;

@RestController
@RequestMapping(value="/api")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@GetMapping("/cargos")
	public List<Cargo> listarCargos(){
		return cargoRepository.findAll();
	}
	
	@GetMapping("/cargo/{id}")
	public Cargo encontrarCargo(@PathVariable(value="id") Integer id) {
		return cargoRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/cargo")
	public Cargo cadastrarCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	@DeleteMapping("/cargo")
	public void deletarCargo(@RequestBody Cargo cargo) {
		cargoRepository.delete(cargo);
	}

	@PutMapping("/cargo")
	public Cargo atualizarCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}
}

