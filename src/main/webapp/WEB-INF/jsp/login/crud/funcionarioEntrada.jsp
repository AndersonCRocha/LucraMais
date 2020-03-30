<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de funcionários</h1>		

<form action="/login/crud/Funcionario/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${funcionario.id}">
		<label for="nome">Nome completo:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome completo" value="${funcionario.nome}" autocomplete="off" required>
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<label for="login">Email:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">@</div>
			        </div>
					<input type="email" name="email" class="form-control" placeholder="Email" value="${funcionario.email}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-6">
				<label for="telefone">Telefone:</label>
				<input type="tel" name="telefone" class="form-control" placeholder="Apenas números: 77999998888" value="${funcionario.telefone}" pattern="[0-9]{11}" maxlength="11" autocomplete="off" required>
			</div>
		</div>
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<label for="cpf">CPF:</label>
				<input type="text" name="cpf" class="form-control" placeholder="CPF" value="${funcionario.cpf}" autocomplete="off" required>
			</div>
			<div class="col-lg-6">
				<label for="rg">RG:</label>
				<input type="text" name="rg" class="form-control" placeholder="RG" value="${funcionario.rg}" autocomplete="off" required>
			</div>
		</div>
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<label for="pis">PIS:</label>
				<input type="text" name="pis" class="form-control" placeholder="PIS" value="${funcionario.pis}" autocomplete="off" required>
			</div>
			<div class="col-lg-6">
				<label for="cargo">Cargo:</label>
				<select name="cargo" class="form-control" value="${funcionario.cargo.id}" required>
					<c:forEach items="${listaCargo}" var="cargo">
						<option value="${cargo.id}">${cargo.descricao}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<label for="salario">Salário:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">R$</div>
			        </div>
					<input type="number" name="salario" class="form-control" placeholder="00.00" value="${funcionario.salario}" step="0.05" required >
		    	</div>
			</div>
		</div>
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<label for="usuario.login">Login:</label>
				<input type="text" name="usuario.login" class="form-control" placeholder="Login" value="${funcionario.usuario.login}" autocomplete="off" required>
			</div>
			<div class="col-lg-6">
				<label for="usuario.senha">Senha:</label>
				<input type="password" name="usuario.senha" class="form-control" placeholder="Senha" value="${funcionario.usuario.senha}" autocomplete="off" required>
			</div>
		</div>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Funcionario"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
