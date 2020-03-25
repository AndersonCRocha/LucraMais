package com.projeto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.Usuario;
import com.projeto.service.UsuarioService;

@Controller
@RequestMapping("/login/crud/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request) {
		request.setAttribute("page", "usuarioEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaUsuario", usuarioService.findAll());
		request.setAttribute("page", "usuarioListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Usuario usuario, RedirectAttributes redirectAttributes)  {
		try {
			usuarioService.save(usuario);
			redirectAttributes.addFlashAttribute("sucesso", "Usuário salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Usuario");
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : O login informado já existe.");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("usuario", usuario);
		return new ModelAndView("redirect:/login/crud/Usuario/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				usuarioService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Usuário deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse usuário.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Usuario");
	}
	
}
