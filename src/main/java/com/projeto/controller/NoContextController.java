package com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoContextController {
	
	@GetMapping("")
	public void paginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/login/index");
		return;
	}
}
