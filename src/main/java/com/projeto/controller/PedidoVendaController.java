package com.projeto.controller;

import java.sql.Date;
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

import com.projeto.bean.Cliente;
import com.projeto.bean.Funcionario;
import com.projeto.bean.ItemPedidoVenda;
import com.projeto.bean.PedidoVenda;
import com.projeto.bean.Usuario;
import com.projeto.service.ClienteService;
import com.projeto.service.FuncionarioService;
import com.projeto.service.ItemPedidoVendaService;
import com.projeto.service.PedidoVendaService;

@Controller
@RequestMapping(value="/login/crud/PedidoVenda")
public class PedidoVendaController {
	
	@Autowired
	private PedidoVendaService pedidoVendaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private ItemPedidoVendaService itemPedidoVendaService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<PedidoVenda> pedidoVenda = pedidoVendaService.findById(id);
			if(pedidoVenda.isPresent()) {
				PedidoVenda form = pedidoVenda.get();
				request.setAttribute("pedidoVenda", form);
				request.setAttribute("page", "iframe/pedidoVendaIframe.jsp");
				return new ModelAndView("/login/crud/base");
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
			Funcionario funcionario = funcionarioService.findById(pedidoVenda.getFuncionario().getId()).get();
			Cliente cliente = clienteService.findById(pedidoVenda.getCliente().getId()).get();
			pedidoVenda.setCliente(cliente);
			pedidoVenda.setFuncionario(funcionario);
			pedidoVendaService.save(pedidoVenda);
			
			itemPedidoVendaService.deleteByPedidoVenda(pedidoVenda);
			
			if(pedidoVenda.getListaProdutoItem() != null && !pedidoVenda.getListaProdutoItem().isEmpty()) {
				for(ItemPedidoVenda item : pedidoVenda.getListaProdutoItem()) {
					item.setPedidoVenda(pedidoVenda);
				}
			}
			itemPedidoVendaService.saveAll(pedidoVenda.getListaProdutoItem());
			redirectAttributes.addFlashAttribute("sucesso", "Pedido de venda salvo com sucesso");
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
				itemPedidoVendaService.deleteByPedidoVenda(new PedidoVenda(id));
				pedidoVendaService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Pedido de venda deletado com sucesso");
			}catch(Exception e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse pedido de venda.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/PedidoVenda");
	}
	
	@PostMapping("iframeCriacao")
	public @ResponseBody ModelAndView abrirIframeCriacao(HttpServletRequest request, @RequestParam(name = "id", required = true)Integer id) {
		Cliente cliente = clienteService.findById(id).get();
		Usuario usuarioLogado = (Usuario)request.getSession().getAttribute("usuarioLogado");
		Funcionario funcionario = usuarioLogado.getFuncionario();
		
		PedidoVenda pedidoVenda = new PedidoVenda(cliente, funcionario, new Date(System.currentTimeMillis()));
		
		return new ModelAndView("/login/crud/iframe/pedidoVendaIframe", "pedidoVenda", pedidoVenda);
	}
	
	
}


