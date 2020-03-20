package com.projeto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.bean.Usuario;

@Configuration
public class AutenticacaoFiltro implements Filter {
	
    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		String urlParaAutenticar = req.getServletPath();
		
		if(usuarioLogado == null) {
			
			if(urlParaAutenticar.equalsIgnoreCase("/login")) {
				session.setAttribute("urlParaAutenticar", "/login/index");
			}else if(urlParaAutenticar.equalsIgnoreCase("/login/fazerLogout")){
				session.removeAttribute("usuarioLogado");;
				session.setAttribute("urlParaAutenticar", "/login/index");
			}else {
				session.setAttribute("urlParaAutenticar", urlParaAutenticar);
			}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
        
    }
 
    @Bean
    public FilterRegistrationBean<AutenticacaoFiltro> loggingFilter(){
        FilterRegistrationBean<AutenticacaoFiltro> registrationBean = new FilterRegistrationBean<>();
             
        registrationBean.setFilter(new AutenticacaoFiltro());
        registrationBean.addUrlPatterns("/login/*");
             
        return registrationBean;    
    }
    
}
