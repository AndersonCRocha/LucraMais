<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de fornecedores</h1>		

<form action="/login/crud/Fornecedor/salvar" method="POST" accept-charset="iso-8859-1">
	<div class="form-group">
		<input type="hidden" name="id" value="${fornecedor.id}">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome" value="${fornecedor.nome}" autocomplete="off" required>
		<label for="login">Email:</label>
		<div class="input-group">
	        <div class="input-group-prepend">
	        	<div class="input-group-text">@</div>
	        </div>
			<input type="email" name="email" class="form-control" placeholder="Email" value="${fornecedor.email}" autocomplete="off" required>
     	</div>
		<label for="telefone">Telefone:</label>
		<input type="tel" name="telefone" class="form-control" placeholder="Apenas números: 77999998888" value="${fornecedor.telefone}" pattern="[0-9]{11}" maxlength="11" autocomplete="off" required>
		<label for="cnpj">CNPJ:</label>
		<input type="text" name="cnpj" class="form-control" placeholder="Cnpj" value="${fornecedor.cnpj}" autocomplete="off" required>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Fornecedor"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
