package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.Fornecedor;
import com.projeto.service.FornecedorService;

@Controller
@RequestMapping(value="/login/crud/Fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Fornecedor> fornecedor = fornecedorService.findById(id);
			if(fornecedor.isPresent()) {
				Fornecedor form = fornecedor.get();
				request.setAttribute("fornecedor", form);
			}
		}
		request.setAttribute("page", "fornecedorEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping
	public ModelAndView listar(HttpServletRequest request) {
		String nome = request.getParameter("q");
		List<Fornecedor> listaFornecedores = StringUtils.isNotBlank(nome) 
				? fornecedorService.findByNome(nome) : fornecedorService.findAll();
		request.setAttribute("listaFornecedor", listaFornecedores);
		request.setAttribute("page", "fornecedorListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Fornecedor fornecedor, RedirectAttributes redirectAttributes)  {
		try {
			fornecedorService.save(fornecedor);
			redirectAttributes.addFlashAttribute("sucesso", "Fornecedor salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Fornecedor");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("fornecedor", fornecedor);
		return new ModelAndView("redirect:/login/crud/Fornecedor/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				fornecedorService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Fornecedor deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse fornecedor.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Fornecedor");
	}
}


