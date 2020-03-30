package com.projeto.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.Tela;
import com.projeto.service.TelaService;

@Controller
@RequestMapping(value = "/login/crud/Tela")
public class TelaController {
	
	@Autowired
	private TelaService telaService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Tela> tela = telaService.findById(id);
			if(tela.isPresent()) {
				Tela form = tela.get();
				request.setAttribute("tela", form);
			}
		}
		request.setAttribute("page", "telaEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaTela", telaService.findAll());
		request.setAttribute("page", "telaListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Tela tela, RedirectAttributes redirectAttributes)  {
		try {
			telaService.save(tela);
			redirectAttributes.addFlashAttribute("sucesso", "Tela salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Tela");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("tela", tela);
		return new ModelAndView("redirect:/login/crud/Tela/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				telaService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Tela deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse tela.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Tela");
	}
}
