package com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.bean.Usuario;
import com.projeto.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ModelAndView logar(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		
		if(autenticar(usuario)) {
			HttpSession session = request.getSession();
			usuario = usuarioService.findByLogin(usuario.getLogin());
			session.setAttribute("usuarioLogado", usuario);
			session.setMaxInactiveInterval(1800);
			response.sendRedirect((String)session.getAttribute("urlParaAutenticar"));
			return null;
		}else {
			request.setAttribute("erro", "Login e/ou senha incorretos!");
			return new ModelAndView("login");
		}
	}
	
	private boolean autenticar(Usuario usuarioForm) {
		
		if(usuarioForm != null && usuarioForm.getLogin() != null && usuarioForm.getSenha() != null ) {
			Usuario usuarioBanco = usuarioService.findByLogin(usuarioForm.getLogin());
			
			if(usuarioBanco != null && usuarioBanco.getSenha().equals(usuarioForm.getSenha())) {
				return true;
			}
		}
	
		return false;
	}
	
	@GetMapping("/login")
	public ModelAndView formLogin() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/login");
	}
	
}
