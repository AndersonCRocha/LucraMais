package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Cargo;
import com.projeto.repository.CargoRepository;

@Service
public class CargoService  {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public List<Cargo> findAll(){
		return cargoRepository.findAll();
	}
	
	public Optional<Cargo> findById(Integer id) {
		return cargoRepository.findById(id);
	}
	
	public Cargo save(Cargo cargo) {
		return cargoRepository.saveAndFlush(cargo);
	}
	
	public void delete(Cargo cargo) {
		cargoRepository.delete(cargo);
	}
	
	public void deleteById(Integer id) {
		cargoRepository.deleteById(id);
	}
}
