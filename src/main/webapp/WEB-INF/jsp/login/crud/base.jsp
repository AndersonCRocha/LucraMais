<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.bean.Usuario" %>
<%@ page import="com.projeto.util.SistemaUtil" %>
<%@ page import="org.springframework.web.servlet.support.ServletUriComponentsBuilder" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
		<meta charset="UTF-8">	
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta property="og:title" content="Lucra+"> 
        <meta property="og:description" content="Projeto desenvolvido para disciplina de Processo de Desenvolvimento de software."> 
        <meta property="og:image" content="<%= ServletUriComponentsBuilder.fromCurrentContextPath().build() %>/img/logo.png">
        
        <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
        
        <link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-grid.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="/css/select2/select2.min.css">
        <link rel="stylesheet" href="/css/default.css">
        
        <link rel="stylesheet" href="/css/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/v4-shims.min.css">
        
        <script type="text/javascript" src="/js/jquery.js"></script>
        <script type="text/javascript" src="/js/default.js"></script>
        <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="/js/select2/select2.min.js"></script>

        <title>Lucra+</title>
    </head>
    <body>	
    	<%
    		Usuario usuario = SistemaUtil.getUsuarioLogado(request);
    		boolean listCliente = SistemaUtil.temPermissao(request, "/login/crud/Cliente");
    		boolean listFornecedor = SistemaUtil.temPermissao(request, "/login/crud/Fornecedor");
    		boolean listFuncionario = SistemaUtil.temPermissao(request, "/login/crud/Funcionario");
    		boolean listMateriaPrima = SistemaUtil.temPermissao(request, "/login/crud/MateriaPrima");
    		boolean listProduto = SistemaUtil.temPermissao(request, "/login/crud/Produto");
    		boolean listUsuario = SistemaUtil.temPermissao(request, "/login/crud/Usuario");
    		boolean listTela = SistemaUtil.temPermissao(request, "/login/crud/Tela");
    		boolean listCargo = SistemaUtil.temPermissao(request, "/login/crud/Cargo");
    		boolean listPedidoVenda = SistemaUtil.temPermissao(request, "/login/crud/PedidoVenda");
    		
    		boolean relCliente = SistemaUtil.temPermissao(request, "/login/report/Cliente");
    		boolean relFornecedor = SistemaUtil.temPermissao(request, "/login/report/Fornecedor");
    		boolean relFuncionario = SistemaUtil.temPermissao(request, "/login/report/Funcionario");
    		boolean relProduto = SistemaUtil.temPermissao(request, "/login/report/Produto");
    		
    		boolean cadPedidoVenda = SistemaUtil.temPermissao(request, "/login/crud/PedidoVenda/criar");
    	%>
    	<c:set var="usuarioLogado" value="<%= usuario %>"/>
    	
	    <div class="page">
<!-- 	    	Inicio do cabeçalho -->
	    	<header class="header">
	    		<nav class="menuHeader">
		    		<a class="logo" href="/login/index"><img src="/img/logo.png"></a>
	    			<c:if test="<%= listCliente || listFornecedor || listFuncionario || listMateriaPrima || listProduto %>">
		    			<div class="btn-group cadastro" role="group">
							<button id="dropdownCadastro" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
							    <span><i class="fa fa-plus"></i> Administração</span>
							</button>
							<div class="dropdown-menu cadastros" aria-labelledby="dropdownCadastro">
		    					<c:if test="<%=listCliente%>"><a class="dropdown-item" href="/login/crud/Cliente"><i class="fa fa-group"></i> Clientes</a></c:if>
		    					<c:if test="<%=listFornecedor%>"><a class="dropdown-item" href="/login/crud/Fornecedor"><i class="fa fa-truck"></i> Fornecedores</a></c:if>
								<c:if test="<%=listFuncionario%>"><a class="dropdown-item" href="/login/crud/Funcionario"><i class="fa fa-briefcase"></i> Funcionários</a></c:if>
		    					<c:if test="<%=listMateriaPrima%>"><a class="dropdown-item" href="/login/crud/MateriaPrima"><i class="fa fa-tags"></i> Matérias-primas</a></c:if>
		    					<c:if test="<%=listProduto%>"><a class="dropdown-item" href="/login/crud/Produto"><i class="fa fa-coffee"></i> Produtos</a></c:if>
							</div>
						</div>
	    			</c:if>
	    			
					<c:if test="<%= relCliente || relFornecedor || relFuncionario || relProduto %>">
		    			<div class="btn-group relatorios" role="group">
							<button id="dropdownRelatorio" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
							    <span><i class="fa fa-file-pdf"></i> Relatórios</span>
							</button>
							<div class="dropdown-menu relatorios" aria-labelledby="dropdownRelatorio">
								<c:if test="<%=relCliente%>"><a class="dropdown-item" href="/login/report/Cliente" target="blank"><i class="fa fa-list"></i> Clientes</a></c:if>
								<c:if test="<%=relFornecedor%>"><a class="dropdown-item" href="/login/report/Fornecedor" target="blank"><i class="fa fa-list"></i> Fornecedores</a></c:if>
								<c:if test="<%=relFuncionario%>"><a class="dropdown-item" href="/login/report/Funcionario" target="blank"><i class="fa fa-list"></i> Funcionários</a></c:if>
								<c:if test="<%=relProduto%>"><a class="dropdown-item" href="/login/report/Produto" target="blank"><i class="fa fa-list"></i> Produtos</a></c:if>
							</div>
						</div>
					</c:if>
					
					<c:if test="<%= listUsuario || listTela || listCargo %>">
		    			<div class="btn-group configs" role="group">
							<button id="dropdownConfigs" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
							    <span><i class="fa fa-cogs"></i> Configurações</span>
							</button>
							<div class="dropdown-menu configs" aria-labelledby="dropdownConfigs">
								<c:if test="<%=listUsuario%>"><a class="dropdown-item" href="/login/crud/Usuario"><i class="fa fa-user"></i> Usuários </a></c:if>
								<c:if test="<%=listTela%>"><a class="dropdown-item" href="/login/crud/Tela"><i class="fa fa-clone"></i> Telas </a></c:if>
								<c:if test="<%=listCargo%>"><a class="dropdown-item" href="/login/crud/Cargo"><i class="fa fa-sitemap"></i> Cargos</a></c:if>
							</div>
						</div>
					</c:if>
					
					<c:if test="<%= cadPedidoVenda || listPedidoVenda %>">
		    			<div class="btn-group pedidoVenda" role="group">
							<button id="dropdownPedidoVenda" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
							    <span><i class="fa fa-shopping-cart"></i> Pedido de venda</span>
							</button>
							<div class="dropdown-menu pedidoVenda" aria-labelledby="dropdownPedidoVenda">
								<c:if test="<%=cadPedidoVenda%>"><a class="dropdown-item" href="/login/crud/PedidoVenda/criar"><i class="fa fa-play"></i> Novo</a></c:if>
								<c:if test="<%=listPedidoVenda%>"><a class="dropdown-item" href="/login/crud/PedidoVenda"><i class="fa fa-list"></i> Listagem</a></c:if>
							</div>
						</div>	
					</c:if>
	    		</nav>
	    	</header>
<!-- 	    	Fim do cabeçalho -->
	
<!-- 			Inicio do conteudo da página -->
	    	<main class="main">
		    	<c:if test="${not empty sucesso}">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
						${sucesso}
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 					<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
		    	<c:if test="${not empty erro}">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
						${erro}
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 					<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				
		    	<div class="content">
				    <jsp:include page="${page}"></jsp:include>
		    	</div>
		    	
			</main>
<!-- 	    	Fim do conteúdo da página -->

<!-- 			Inicio do menu lateral -->
	    	<aside class="aside">
	    		<div class="informacoes">
					<div class="btn-group infoUser" role="group">
						<button id="dropdownInfoUser" type="button" class="btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
						    <span><i class="fa fa-user"></i>&nbsp;&nbsp; ${usuarioLogado.primeiroNome}</span>
						</button>
						<div class="dropdown-menu menuUser" aria-labelledby="dropdownInfoUser">
<!-- 							<a class="dropdown-item" href="#"> <i class="fa fa-pencil-square-o"></i> Alterar nome de usuário</a> -->
<!-- 							<a class="dropdown-item" href="#"> <i class="fa fa-key"></i> Alterar senha</a> -->
							<a class="dropdown-item" href="/logout" title="Sair"><i class="fa fa-sign-out"></i> Sair</a>
						</div>
					</div>
	    		</div>
	    	</aside>
<!-- 	    	Fim do menu lateral -->
<!-- 			Div de carregamento -->
			<div class="divCarregamento"><span class="carregando">Carregando ... </span></div>
<!-- 			Fim da div de carregamento -->
	    </div>
        <script type="text/javascript" src="/js/utilDOM.js"></script>
    </body>
</html>