package com.projeto.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.projeto.bean.Permissao;
import com.projeto.bean.Usuario;

public class SistemaUtil {
	
	public static Usuario getUsuarioLogado(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		return usuario;
	}
	
	@SuppressWarnings({ "unchecked" })
	public static boolean temPermissao(HttpServletRequest request, String url) {
		HttpSession session = request.getSession();
		List<Permissao> listaPermissao = (List<Permissao>)session.getAttribute("listaPermissao");
		boolean retorno = false;
		Usuario usuarioLogado = (Usuario)getUsuarioLogado(request); 
		if(usuarioLogado.getAdmin() != null && usuarioLogado.getAdmin()){
			return true;
		}
		if(listaPermissao != null && !listaPermissao.isEmpty()) {
			retorno = verificaPermissao(listaPermissao, url);
		}
		return retorno;
	}
	
	private static boolean verificaPermissao(List<Permissao> listaPermissao, String url){
		for(Permissao permissao : listaPermissao) {
			String uriPermissao = permissao.getTela().getUri();
			url = url.replaceAll("salvar", "criar");
			if(uriPermissao.equals(url)) {
				return true;
			}
		}
		return false;
	}
}
