package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bean.Produto;
import com.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(Integer id) {
		return produtoRepository.findById(id);
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}
	
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	public void deleteById(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public List<Produto> listarParaPV(String nome){
		return produtoRepository.findByNomeLikeIgnoreCaseOrderByNome(nome+"%");
	}

	public List<Produto> findByNome(String nome) {
		return produtoRepository.findByNomeLikeIgnoreCaseOrderByNome("%"+nome+"%");
	}
}
