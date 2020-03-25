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

import com.projeto.bean.PedidoVenda;
import com.projeto.service.ClienteService;
import com.projeto.service.PedidoVendaService;

@Controller
@RequestMapping(value="/login/crud/PedidoVenda")
public class PedidoVendaController {
	
	@Autowired
	private PedidoVendaService pedidoVendaService;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<PedidoVenda> pedidoVenda = pedidoVendaService.findById(id);
			if(pedidoVenda.isPresent()) {
				PedidoVenda form = pedidoVenda.get();
				request.setAttribute("pedidoVenda", form);
			}
		}
		request.setAttribute("listaCliente", clienteService.findAll());
		request.setAttribute("page", "pedidoVendaEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaPedidoVenda", pedidoVendaService.findAll());
		request.setAttribute("page", "pedidoVendaListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(PedidoVenda pedidoVenda, RedirectAttributes redirectAttributes)  {
		try {
			pedidoVendaService.save(pedidoVenda);
			redirectAttributes.addFlashAttribute("sucesso", "PedidoVenda salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/PedidoVenda");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("pedidoVenda", pedidoVenda);
		return new ModelAndView("redirect:/login/crud/PedidoVenda/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				pedidoVendaService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "PedidoVenda deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse pedidoVenda.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/PedidoVenda");
	}
	
}


