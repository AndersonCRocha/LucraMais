package com.projeto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/login/index")
	public ModelAndView index(HttpServletRequest request) {
		request.setAttribute("page", "index.jsp");
	    return new ModelAndView("/login/crud/base");
	}
	
}
