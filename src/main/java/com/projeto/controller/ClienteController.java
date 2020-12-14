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

import com.projeto.bean.Cliente;
import com.projeto.service.ClienteService;

@Controller
@RequestMapping(value="/login/crud/Cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
				Cliente form = cliente.get();
				request.setAttribute("cliente", form);
			}
		}
		request.setAttribute("page", "clienteEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		String nome = request.getParameter("q");
		List<Cliente> listaCliente = StringUtils.isNotBlank(nome) 
				? clienteService.findByNome(nome) : clienteService.findAll();
		request.setAttribute("listaCliente", listaCliente);
		request.setAttribute("page", "clienteListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Cliente cliente, RedirectAttributes redirectAttributes)  {
		try {
			clienteService.save(cliente);
			redirectAttributes.addFlashAttribute("sucesso", "Cliente salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Cliente");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("cliente", cliente);
		return new ModelAndView("redirect:/login/crud/Cliente/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				clienteService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Cliente deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse cliente.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Cliente");
	}
}
