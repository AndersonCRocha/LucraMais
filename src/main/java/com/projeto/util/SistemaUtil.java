package com.projeto.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.projeto.bean.Usuario;

public class SistemaUtil {
	
	public static Usuario getUsuarioLogado(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario;
	}
}
