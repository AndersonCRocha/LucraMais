<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de matérias-primas</h1>		

<form action="/login/crud/MateriaPrima/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${materiaPrima.id}">
		<div class="row">
			<div class="col-lg-9">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" class="form-control" placeholder="Nome" value="${materiaPrima.nome}" autocomplete="off" required>
			</div>
			<div class="col-lg-3">
				<label for="login">Unidade de medida:</label>
				<input type="text" name="unidadeMedida" class="form-control" placeholder="Unidade de medida" value="${materiaPrima.unidadeMedida}" autocomplete="off" required>
			</div>
			<div class="col-lg-12">
				<label for="descricaoNutricional">Descrição nutricional:</label>
				<textarea name="descricaoNutricional" class="form-control" rows="3" required>${materiaPrima.descricaoNutricional}</textarea>
			</div>
			<div class="col-lg-4">
				<label for="fornecedor">Fornecedor:</label>
				<select name="fornecedor" class="form-control" value="${materiaPrima.fornecedor.id}" required>
					<c:forEach items="${listaFornecedor}" var="fornecedor">
						<option value="${fornecedor.id}">${fornecedor.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-4">
				<label for="precoCompra">Preço de compra:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">R$</div>
			        </div>
					<input type="text" name="precoCompra" class="form-control money" placeholder="00.00" value="${materiaPrima.precoCompra}" required>
		     	</div>	
		     </div>
		</div>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/MateriaPrima"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
