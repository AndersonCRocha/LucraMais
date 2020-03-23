<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico">
    
    <link href="/css/login.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="/js/jquery.js"></script>	
    <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
    
    <title>Lucra+</title>
</head>
<body>
	<div class="telaLogin">
		<form action="/logar" method="post" class="formLogin">
			<c:if test="${not empty erro}">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
					${erro}
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	 					<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<div class="logo"><img src="/img/logo.png"></div>
			<div class="infoLogin">Entre com os dados para acessar:</div>
			<div class="form-group">
				<input type="text" name="login" placeholder="Login" required autofocus="autofocus">
				<input type="password" name="senha" placeholder="Senha" required>
				<button type="submit" class="btn btn-block btn-primary btn-logar">Entrar</button>
			</div>
		</form>
		<div class="rodapeLogin"><span>&copy; Todos os direitos reservados 2020</span><span>Criado por: <Strong>Anderson Rocha - João Pedro</Strong></span></div>
	</div>
	<ul class="squares"></ul>
	
	<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>