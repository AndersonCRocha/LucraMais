<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	input[type=number]::-webkit-inner-spin-button { 
	    -webkit-appearance: none;
	}
	input[type=number] { 
	   -moz-appearance: textfield;
	   appearance: textfield;
	}
</style>

<h1>Cadastro de funcionários</h1>		

<form action="/login/crud/Funcionario/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${funcionario.id}">
		<div class="row">
			<div class="col-lg-6">
				<label for="nome">Nome completo:</label>
				<input type="text" name="nome" class="form-control" placeholder="Nome completo" value="${funcionario.nome}" autocomplete="off" required>
			</div>
			<div class="col-lg-6">
				<label for="login">Email:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">@</div>
			        </div>
					<input type="email" name="email" class="form-control" placeholder="Email" value="${funcionario.email}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-3">
				<label for="telefone">Telefone:</label>
				<input type="text" name="telefone" class="form-control phone" placeholder="(XX) XXXXX-XXXX" value="${funcionario.telefone}" autocomplete="off" required>
			</div>
			<div class="col-lg-3">
				<label for="cpf">CPF:</label>
				<input type="text" name="cpf" class="form-control cpf" placeholder="XXX.XXX.XXX-XX" value="${funcionario.cpf}" autocomplete="off" required>
			</div>
			<div class="col-lg-3">
				<label for="rg">RG:</label>
				<input type="text" name="rg" class="form-control rg" placeholder="XX.XXX.XXX-XX" value="${funcionario.rg}" autocomplete="off" required>
			</div>
			<div class="col-lg-3">
				<label for="pis">PIS:</label>
				<input type="text" name="pis" class="form-control pis" placeholder="XXX.XXXXX.XX-X" value="${funcionario.pis}" autocomplete="off" required>
			</div>
			<div class="col-lg-3">
				<label for="cargo">Cargo:</label>
				<select name="cargo" class="form-control" value="${funcionario.cargo.id}" required>
					<c:forEach items="${listaCargo}" var="cargo">
						<option value="${cargo.id}">${cargo.descricao}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-lg-3">
				<label for="salario">Salário:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">R$</div>
			        </div>
					<input type="text" name="salario" class="form-control money" placeholder="000.00" value="${funcionario.salario}" required >
		    	</div>
			</div>
			<div class="col-lg-2">
				<label for="cep">CEP:</label>
				<input type="text" name="cep" class="form-control cep" placeholder="XX.XXX-XXX" value="${funcionario.cep}" autocomplete="off" required>
			</div>
			<div class="col-lg-4">
				<label for="cidade">Cidade:</label>
				<input type="text" name="cidade" id="cidade" class="form-control" placeholder="Cidade" value="${funcionario.cidade}" autocomplete="off" required>
			</div>
			<div class="col-lg-1">
				<label for="estado">UF:</label>
				<input type="text" name="estado" id="estado" class="form-control" placeholder="UF" maxlength="2" value="${funcionario.estado}" autocomplete="off" required>
			</div>		
			<div class="col-lg-4">
				<label for="bairro">Bairro:</label>
				<input type="text" name="bairro" id="bairro" class="form-control" placeholder="Bairro" value="${funcionario.bairro}" autocomplete="off" required>
			</div>	
			<div class="col-lg-6">
				<label for="rua">Rua:</label>
				<input type="text" name="rua" id="rua" class="form-control" placeholder="Rua" value="${funcionario.rua}" autocomplete="off" required>
			</div>	
			<div class="col-lg-1">
				<label for="numero">Nº:</label>
				<input type="number" name="numero" class="form-control only-number" placeholder="Nº" value="${funcionario.numero}" autocomplete="off" required>
			</div>	
		</div>
		<c:choose>
			<c:when test="${empty funcionario.id}">
				<br><h3>Dados de usuário:</h3>
				<div class="row">
<!-- 				<div class="row justify-content-between"> -->
					<div class="col-lg-6">
						<label for="usuario.login">Login:</label>
						<input type="text" name="usuario.login" class="form-control" placeholder="Login" value="${funcionario.usuario.login}" autocomplete="off" required>
					</div>
					<div class="col-lg-3">
						<label for="usuario.senha">Senha:</label>
						<input type="password" name="usuario.senha" class="form-control" placeholder="Senha" value="${funcionario.usuario.senha}" autocomplete="off" required>
					</div>
<!-- 					<div class="col-lg-2 "> -->
<!-- 						<label for="admin">Administrador:</label> -->
<%-- 						<input type="checkbox" name="usuario.admin" class="form-check" value="${funcionario.usuario.admin}" ${funcionario.usuario.admin == true ? 'checked' : ''}> --%>
<!-- 					</div>		 -->
				</div>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="usuario.id" value="${funcionario.usuario.id}">
			</c:otherwise>
		</c:choose>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Funcionario"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
