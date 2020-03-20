<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        
        <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
        
        <link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-grid.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="/css/default.css">
        
        <link rel="stylesheet" href="/css/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/v4-shims.min.css">
        
        <script type="text/javascript" src="/js/jquery.js"></script>
        <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="/js/default.js"></script>

        <title>Lucra+</title>
    </head>
    <body>	
	    <div class="page">
<!-- 	    	Inicio do cabeçalho -->
	    	<header class="header">
	    		<nav class="menuHeader">
		    		<a class="logo" href="/login/index"><img src="/img/logo.png"></a>
	    			<div class="btn-group cadastro" role="group">
						<button id="dropdownCadastro" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
						    <span><i class="fa fa-plus"></i> Cadastros</span>
						</button>
						<div class="dropdown-menu cadastros" aria-labelledby="dropdownCadastro">
							<a class="dropdown-item" href="/login/crud/Usuario"><i class="fa fa-user"></i> Usuários</a>
	    					<a class="dropdown-item" href="/login/crud/Produto"><i class="fa fa-coffee"></i> Produtos</a>
	    					<a class="dropdown-item" href="#"><i class="fa fa-group"></i> Clientes</a>
	    					<a class="dropdown-item" href="#"><i class="fa fa-tags"></i> Matérias-primas</a>
	    					<a class="dropdown-item" href="/login/crud/Fornecedor"><i class="fa fa-truck"></i> Fornecedores</a>
	    					<a class="dropdown-item" href="#"><i class="fa fa-group"></i> Funcionários</a>
						</div>
					</div>
					
	    			<div class="btn-group relatorios" role="group">
						<button id="dropdownRelatorio" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
						    <span><i class="fa fa-file-pdf"></i> Relatórios</span>
						</button>
						<div class="dropdown-menu relatorios" aria-labelledby="dropdownRelatorio">
							<a class="dropdown-item" href="#"><i class="fa fa-user"></i> Usuários</a>
						</div>
					</div>
					
	    			<div class="btn-group configs" role="group">
						<button id="dropdownConfigs" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
						    <span><i class="fa fa-cogs"></i> Configurações</span>
						</button>
						<div class="dropdown-menu configs" aria-labelledby="dropdownConfigs">
							<a class="dropdown-item" href="#"><i class="fa fa-user"></i> Usuários</a>
						</div>
					</div>
					
	    			<div class="btn-group pedidoVenda" role="group">
						<button id="dropdownPedidoVenda" type="button" class="btn botoesMenuHeader" data-toggle="dropdown" aria-haspopup="true" aria-expanded=false>
						    <span><i class="fa fa-shopping-cart"></i> Pedido de venda</span>
						</button>
						<div class="dropdown-menu pedidoVenda" aria-labelledby="dropdownPedidoVenda">
							<a class="dropdown-item" href="#"><i class="fa fa-play"></i> Novo</a>
							<a class="dropdown-item" href="#"><i class="fa fa-list"></i> Listagem</a>
						</div>
					</div>
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
						    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXnxEAFRs6OEBhBB9IrDAW1P_fJMGzANmk29ofnCS14pJ8Pcye" class="imgUser">
						    <span> Administrador</span>
						</button>
						<div class="dropdown-menu menuUser" aria-labelledby="dropdownInfoUser">
							<a class="dropdown-item" href="#"> <i class="fa fa-user"></i> Admin</a>
							<a class="dropdown-item" href="/logout" title="Sair"><i class="fa fa-sign-out"></i> Sair</a>
						</div>
					</div>
	    		</div>
	    	</aside>
<!-- 	    	Fim do menu lateral -->
	    </div>
    </body>
</html>