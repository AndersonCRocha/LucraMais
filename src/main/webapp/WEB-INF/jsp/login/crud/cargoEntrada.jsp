<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de cargos</h1>		

<form action="/login/crud/Cargo/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${cargo.id}">
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao" class="form-control" placeholder="Descrição" value="${cargo.descricao}" autocomplete="off" required>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Cargo"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
