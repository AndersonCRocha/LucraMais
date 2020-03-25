<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de permissões</h1>		

<form action="/login/crud/Permissao/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${permissao.id}">
		<label for="descricao">Uri:</label>
		<input type="text" name="uri" class="form-control" placeholder="Ex: /login/crud/PermissaoS" value="${permissao.uri}" autocomplete="off" required>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Permissao"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
