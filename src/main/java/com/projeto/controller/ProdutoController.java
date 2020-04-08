package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.Produto;
import com.projeto.service.FornecedorService;
import com.projeto.service.ProdutoService;

@Controller
@RequestMapping(value="/login/crud/Produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Produto> produto = produtoService.findById(id);
			if(produto.isPresent()) {
				Produto form = produto.get();
				request.setAttribute("produto", form);
			}
		}
		request.setAttribute("listaFornecedor", fornecedorService.findAll());
		request.setAttribute("page", "produtoEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaProduto", produtoService.findAll());
		request.setAttribute("page", "produtoListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Produto produto, RedirectAttributes redirectAttributes)  {
		try {
			produtoService.save(produto);
			redirectAttributes.addFlashAttribute("sucesso", "Produto salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Produto");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("produto", produto);
		return new ModelAndView("redirect:/login/crud/Produto/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				produtoService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Produto deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse produto.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Produto");
	}
	
	@PostMapping("listarParaPV")
	public @ResponseBody List<Produto> listarParaPV(@RequestParam(name = "nome") String nome){
		return produtoService.listarParaPV(nome);
	}
}
