package com.projeto.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.bean.Tela;
import com.projeto.service.TelaService;

@Configuration
public class TelaInit {
	@Autowired
	private TelaService telaService;
	
	@Bean
	public void criaTelas() {
		
		List<Tela> telasBanco = telaService.findAll();
		if( telasBanco == null || telasBanco.isEmpty()) {
			
			List<Tela> listaTela = new ArrayList<>();
			
			//-----------------------Telas de listagem -----------------------------
			
			listaTela.add(new Tela("Listagem de Cargos","/login/crud/Cargo"));
			listaTela.add(new Tela("Listagem de Clientes","/login/crud/Cliente"));
			listaTela.add(new Tela("Listagem de Contas a pagar","/login/crud/ContaPagar"));
			listaTela.add(new Tela("Listagem de Contas a receber","/login/crud/ContaReceber"));
			listaTela.add(new Tela("Listagem de Fornecedores","/login/crud/Fornecedor"));
			listaTela.add(new Tela("Listagem de Funcionários","/login/crud/Funcionario"));
			listaTela.add(new Tela("Listagem de Matérias primas","/login/crud/MateriaPrima"));
			listaTela.add(new Tela("Listagem de Pedidos de vendas","/login/crud/PedidoVenda"));
			listaTela.add(new Tela("Listagem de Produtos","/login/crud/Produto"));
			listaTela.add(new Tela("Listagem de Telas","/login/crud/Tela"));
			listaTela.add(new Tela("Listagem de Usuários","/login/crud/Usuario"));
			
			//-----------------------Telas de cadastro e edição----------------------
			
			listaTela.add(new Tela("Cadastro/edição de Cargos","/login/crud/Cargo/criar"));
			listaTela.add(new Tela("Cadastro/edição de Clientes","/login/crud/Cliente/criar"));
			listaTela.add(new Tela("Cadastro/edição de Contas a pagar","/login/crud/ContaPagar/criar"));
			listaTela.add(new Tela("Cadastro/edição de Contas a receber","/login/crud/ContaReceber/criar"));
			listaTela.add(new Tela("Cadastro/edição de Fornecedores","/login/crud/Fornecedor/criar"));
			listaTela.add(new Tela("Cadastro/edição de Funcionários","/login/crud/Funcionario/criar"));
			listaTela.add(new Tela("Cadastro/edição de Matérias primas","/login/crud/MateriaPrima/criar"));
			listaTela.add(new Tela("Cadastro/edição de Pedidos de vendas","/login/crud/PedidoVenda/criar"));
			listaTela.add(new Tela("Cadastro/edição de Produtos","/login/crud/Produto/criar"));
			listaTela.add(new Tela("Cadastro/edição de Telas","/login/crud/Tela/criar"));
			listaTela.add(new Tela("Cadastro/edição de Usuários","/login/crud/Usuario/criar"));
			
			//-----------------------Telas de Exclusão--------------------------------
	
			listaTela.add(new Tela("Exclusão de Cargos","/login/crud/Cargo/excluir"));
			listaTela.add(new Tela("Exclusão de Clientes","/login/crud/Cliente/excluir"));
			listaTela.add(new Tela("Exclusão de Contas a pagar","/login/crud/ContaPagar/excluir"));
			listaTela.add(new Tela("Exclusão de Contas a receber","/login/crud/ContaReceber/excluir"));
			listaTela.add(new Tela("Exclusão de Fornecedores","/login/crud/Fornecedor/excluir"));
			listaTela.add(new Tela("Exclusão de Funcionários","/login/crud/Funcionario/excluir"));
			listaTela.add(new Tela("Exclusão de Matérias primas","/login/crud/MateriaPrima/excluir"));
			listaTela.add(new Tela("Exclusão de Pedidos de vendas","/login/crud/PedidoVenda/excluir"));
			listaTela.add(new Tela("Exclusão de Produtos","/login/crud/Produto/excluir"));
			listaTela.add(new Tela("Exclusão de Telas","/login/crud/Tela/excluir"));
			listaTela.add(new Tela("Exclusão de Usuários","/login/crud/Usuario/excluir"));
			
			//------------------------URI's dos process----------------------------------
			
			listaTela.add(new Tela("Iframe de criação do PV","/login/crud/PedidoVenda/iframeCriacao"));
			listaTela.add(new Tela("Lista de Produtos - Criação do PV","/login/crud/Produto/listarParaPV"));
			
			
			//------------------------URI's dos relatórios--------------------------------
			
			listaTela.add(new Tela("Relatório de Clientes","/login/report/Cliente"));
			listaTela.add(new Tela("Relatório de Fornecedores","/login/report/Fornecedor"));
			listaTela.add(new Tela("Relatório de Funcionários","/login/report/Funcionario"));
			listaTela.add(new Tela("Relatório de Produtos","/login/report/Produto"));
			
			telaService.saveAll(listaTela);
		}
	}
}
