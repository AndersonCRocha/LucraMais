<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
	<spam>Exemplo de URI's:</spam><br>
	<spam><b>Listagem: </b>/login/crud/Usuario</spam>
	<spam><b>Cria��o e edi��o: </b>/login/crud/Usuario/criar</spam>
	<spam><b>Exclus�o: </b>/login/crud/Usuario/excluir</spam>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
	</button>
</div>
<h1>Cadastro de telas</h1>		

<form action="/login/crud/Tela/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${tela.id}">
		<label for="modulo">M�dulo:</label>
		<input type="text" name="modulo" class="form-control" placeholder="Usu�rio" value="${tela.modulo}" autocomplete="off" required>
		<label for="uri">Uri:</label>
		<input type="text" name="uri" class="form-control" placeholder="/login/crud/Usuario" value="${tela.uri}" autocomplete="off" required>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Tela"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
