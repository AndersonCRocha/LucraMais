package com.projeto.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.bean.Usuario;

public class SistemaUtil {
	
	@Autowired
	static ObjectFactory<HttpSession> httpSessionFactory;

	static HttpSession session = httpSessionFactory.getObject();
	
	public static Usuario getUsuarioLogado() {
		session.getAttribute("usuarioLogado");
		return null;
	}
}
