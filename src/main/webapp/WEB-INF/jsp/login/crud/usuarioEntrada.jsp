
<h1>Cadastro de usuários</h1>		

<form action="/login/crud/Usuario/salvar" method="POST" accept-charset="iso-8859-1">
	<div class="form-group">
		<input type="hidden" name="id" value="${usuario.id}">
		<label for="nome">Nome completo:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome" value="${usuario.nome}" autocomplete="off">
		<label for="login">Login:</label>
		<input type="text" name="login" class="form-control" placeholder="Login" value="${usuario.login}" autocomplete="off">
		<label for="senha">Senha:</label>
		<input type="password" name="senha" class="form-control" placeholder="Senha">
		<label for="senha">Repita a senha:</label>
		<input type="password" name="senha" class="form-control" placeholder="Repita sua senha">
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Usuario"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
