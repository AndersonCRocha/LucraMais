package com.projeto.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.bean.Usuario;
import com.projeto.util.SistemaUtil;

@Configuration
public class AutorizacaoFiltro implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		Usuario usuarioLogado = SistemaUtil.getUsuarioLogado(req);
		String url = req.getServletPath();
		
		if(usuarioLogado.getAdmin() != null || url.equals("/login/index") || SistemaUtil.temPermissao(req, url)) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/erro403");
			dispatcher.forward(request, response);
			return;
		}
	}
	
	@Bean
    public FilterRegistrationBean<AutorizacaoFiltro> authorizationFilter(){
        FilterRegistrationBean<AutorizacaoFiltro> registrationBean = new FilterRegistrationBean<>();
             
        registrationBean.setFilter(new AutorizacaoFiltro());
        registrationBean.addUrlPatterns("/login/*");
             
        return registrationBean;    
    }
	
}
