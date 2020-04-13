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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.ApiRestApplication;
import com.projeto.bean.Usuario;
import com.projeto.util.SistemaUtil;

@Configuration
public class AutenticacaoFiltro implements Filter {
	
	static Logger log = LoggerFactory.getLogger(ApiRestApplication.class);
	
    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario usuarioLogado = SistemaUtil.getUsuarioLogado(req);
		
		String urlParaAutenticar = req.getServletPath();
		
		if(usuarioLogado == null) {
			
			if(urlParaAutenticar.equalsIgnoreCase("/login")) {
				session.setAttribute("urlParaAutenticar", "/login/index");
			}else {
				session.setAttribute("urlParaAutenticar", urlParaAutenticar);
			}
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		
		log.info(SistemaUtil.getUsuarioLogado(req).getNome() + ": " + urlParaAutenticar);
		
		chain.doFilter(request, response);
        
    }
 
    @Bean
    public FilterRegistrationBean<AutenticacaoFiltro> authenticationFilter(){
        FilterRegistrationBean<AutenticacaoFiltro> registrationBean = new FilterRegistrationBean<>();
             
        registrationBean.setFilter(new AutenticacaoFiltro());
        registrationBean.addUrlPatterns("/login/*");
             
        return registrationBean;    
    }
    
}
