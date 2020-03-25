<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Cadastro de usuários</h1>		

<form action="/login/crud/Usuario/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${usuario.id}">
		<label for="nome">Nome completo:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome" value="${usuario.nome}" autocomplete="off" required>
		<div class="row justify-content-between">
			<div class="col-9" style="padding: 0;">
				<label for="login">Login:</label>
				<input type="text" name="login" class="form-control" placeholder="Login" value="${usuario.login}" autocomplete="off" required>
			</div>
			<div class="col-2 " style="padding: 0; display:${empty usuario.id ? "block":"none"};">
				<label for="admin">Administrador:</label>
				<input type="checkbox" name="admin" class="form-check" value="${usuario.admin}" ${usuario.admin == true ? 'checked' : ''}>
			</div>		
		</div>
		<label for="senha">Senha:</label>
		<input type="password" name="senha" class="form-control" placeholder="Senha" required>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Usuario"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	