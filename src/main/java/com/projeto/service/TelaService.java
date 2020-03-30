package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Tela;
import com.projeto.repository.TelaRepository;

@Service
public class TelaService {

		@Autowired
		private TelaRepository telaRepository;
		
		public List<Tela> findAll(){
			return telaRepository.findAll();
		}
		
		public Optional<Tela> findById(Integer id) {
			return telaRepository.findById(id);
		}
		
		public Tela save(Tela tela) {
			return telaRepository.saveAndFlush(tela);
		}
		
		public void delete(Tela tela) {
			telaRepository.delete(tela);
		}
		
		public void deleteById(Integer id) {
			telaRepository.deleteById(id);
		}
}
