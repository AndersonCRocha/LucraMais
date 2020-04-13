package com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoContextController {
	
	@GetMapping("")
	public void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login/index");
		return;
	}
	
	@GetMapping("/erro403")
	public ModelAndView erro403() {
		return new ModelAndView("erro403");
	}
}
