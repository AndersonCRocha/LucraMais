<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.bean.enums.TipoPessoa" %>
<%@ page import="com.projeto.bean.enums.SituacaoCliente" %>

<h1>Cadastro de clientes</h1>		

<form action="/login/crud/Cliente/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${cliente.id}">
		<label for="nome">Nome completo:</label>
		<input type="text" name="nome" class="form-control" placeholder="Nome completo" value="${cliente.nome}" autocomplete="off" required>
		<div class="row justify-content-between">
			<div class="col-lg-6">
				<label for="login">Email:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">@</div>
			        </div>
					<input type="email" name="email" class="form-control" placeholder="Email" value="${cliente.email}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-6">
				<label for="telefone">Telefone:</label>
				<input type="tel" name="telefone" class="form-control" placeholder="Apenas números: 77999998888" value="${cliente.telefone}" pattern="[0-9]{11}" maxlength="11" autocomplete="off" required>
			</div>
		</div>
		<div class="row justify-content-between">
			<div class="col-lg-4">
				<label>Tipo de pessoa</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="tipoPessoa" id="pessoaFisica" value="PESSOA_FISICA" ${cliente.tipoPessoa == TipoPessoa.PESSOA_FISICA ? 'checked' : empty cliente ? 'checked' : ''}>
					<label class="form-check-label" for="pessoaFisica" style="font-weight: normal;">Pessoa Física</label>
				</div>
				<div class="form-check form-check-inline"> 
				  	<input class="form-check-input" type="radio" name="tipoPessoa" id="pessoaJuridica" value="PESSOA_JURIDICA" ${cliente.tipoPessoa == TipoPessoa.PESSOA_JURIDICA ? 'checked' : ''}>
				  	<label class="form-check-label" for="pessoaJuridica" style="font-weight: normal;">Pessoa Jurídica</label>
				</div>
			</div>
			<div class="col-lg-4" id="divCPF">
				<label for="cpf">CPF:</label>
				<input type="text" name="cpf" class="form-control" placeholder="CPF" value="${cliente.cpf}" autocomplete="off" >
			</div>
			<div class="col-lg-4" id="divCNPJ"  style="display:none;">
				<label for="cnpj">CNPJ:</label>
				<input type="text" name="cnpj" class="form-control" placeholder="CNPJ" value="${cliente.cnpj}" autocomplete="off">
			</div>
			<div class="col-lg-4">
				<label for="rg">RG:</label>
				<input type="text" name="rg" class="form-control" placeholder="RG" value="${cliente.rg}" autocomplete="off" required>
			</div>
		</div>
		<div class="row justify-content-between">
			<div class='col-lg-6'>
				<label for="limiteCredito">Limite de crédito:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">R$</div>
			        </div>
					<input type="number" name="limiteCredito" class="form-control" placeholder="00.00" value="${cliente.limiteCredito}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-4">
				<label>Situação do cliente</label><br>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoRuim" value="RUIM" ${cliente.situacaoCliente == SituacaoCliente.RUIM ? 'checked' : ''}>
					<label class="form-check-label" for="situacaoRuim" style="font-weight: normal;">Ruim</label>
				</div>
				<div class="form-check form-check-inline"> 
				  	<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoRegular" value="REGULAR" ${cliente.situacaoCliente == SituacaoCliente.REGULAR ? 'checked' : ''}>
				  	<label class="form-check-label" for="situacaoRegular" style="font-weight: normal;">Regular</label>
				</div>
				<div class="form-check form-check-inline"> 
				  	<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoBom" value="BOM" ${cliente.situacaoCliente == SituacaoCliente.BOM ? 'checked' : ''}>
				  	<label class="form-check-label" for="situacaoBom" style="font-weight: normal;">Bom</label>
				</div>
				<div class="form-check form-check-inline"> 
				  	<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoOtimo" value="OTIMO" ${cliente.situacaoCliente == SituacaoCliente.OTIMO ? 'checked' : ''}>
				  	<label class="form-check-label" for="situacaoOtimo" style="font-weight: normal;">Ótimo</label>
				</div>
			</div>	
		</div>
		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Cliente"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
<script type="text/javascript">
	$('input[name="tipoPessoa"]').change(function(){
		if($('#pessoaFisica').is(":checked")){
			$("#divCNPJ").css("display","none");
			$("input[name='cnpj']").val("");
			$("#divCPF").css("display","block");
		}else{
			$("#divCNPJ").css("display","block");
			$("input[name='cpf']").val("");
			$("#divCPF").css("display","none");
		}
	});
</script>
