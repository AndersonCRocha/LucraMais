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

import com.projeto.bean.Funcionario;
import com.projeto.service.CargoService;
import com.projeto.service.FuncionarioService;
import com.projeto.service.UsuarioService;

@Controller
@RequestMapping(value="/login/crud/Funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private CargoService cargoService;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Funcionario> funcionario = funcionarioService.findById(id);
			if(funcionario.isPresent()) {
				Funcionario form = funcionario.get();
				request.setAttribute("funcionario", form);
			}
		}
		request.setAttribute("listaCargo", cargoService.findAll());
		request.setAttribute("page", "funcionarioEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaFuncionario", funcionarioService.findAll());
		request.setAttribute("page", "funcionarioListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Funcionario funcionario, RedirectAttributes redirectAttributes)  {
		try {
			if(funcionario.getId() == null) {
				funcionario.getUsuario().setNome(funcionario.getNome());
			}else {
				funcionario.setUsuario(usuarioService.findById(funcionario.getUsuario().getId()).get());
			}
			funcionarioService.save(funcionario);
			redirectAttributes.addFlashAttribute("sucesso", "Funcionario salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Funcionario");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("funcionario", funcionario);
		return new ModelAndView("redirect:/login/crud/Funcionario/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				funcionarioService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Funcionario deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse funcionario.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Funcionario");
	}
	
}

