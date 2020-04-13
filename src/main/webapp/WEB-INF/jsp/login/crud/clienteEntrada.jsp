<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.bean.enums.TipoPessoa" %>
<%@ page import="com.projeto.bean.enums.SituacaoCliente" %>

<style>
	input[type=number]::-webkit-inner-spin-button { 
	    -webkit-appearance: none;
	}
	input[type=number] { 
	   -moz-appearance: textfield;
	   appearance: textfield;
	}
</style>

<h1>Cadastro de clientes</h1>		

<form action="/login/crud/Cliente/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${cliente.id}">
		<div class="row">
			<div class="col-lg-6">
				<label for="nome">Nome completo:</label>
				<input type="text" name="nome" class="form-control" placeholder="Nome completo" value="${cliente.nome}" autocomplete="off" required>
			</div>
			<div class="col-lg-6">
				<label for="login">Email:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">@</div>
			        </div>
					<input type="email" name="email" class="form-control" placeholder="Email" value="${cliente.email}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-3">
				<label for="telefone">Telefone:</label>
				<input type="text" name="telefone" class="form-control phone" placeholder="(XX) XXXXX-XXXX" value="${cliente.telefone}" autocomplete="off" required>
			</div>
			<div class="col-lg-4 offset-lg-1">
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
				<input type="text" name="cpf" class="form-control cpf" placeholder="XXX.XXX.XXX-XX" value="${cliente.cpf}" autocomplete="off" >
			</div>
			<div class="col-lg-4" id="divCNPJ"  style="display:none;">
				<label for="cnpj">CNPJ:</label>
				<input type="text" name="cnpj" class="form-control cnpj" placeholder="XX.XXX.XXX/XXXX-XX" value="${cliente.cnpj}" autocomplete="off">
			</div>
			<div class="col-lg-3">
				<label for="rg">RG:</label>
				<input type="text" name="rg" class="form-control rg" placeholder="XX.XXX.XXX-XX" value="${cliente.rg}" autocomplete="off" required>
			</div>
			<div class='col-lg-3'>
				<label for="limiteCredito">Limite de crédito:</label>
				<div class="input-group">
			        <div class="input-group-prepend">
			        	<div class="input-group-text">R$</div>
			        </div>
					<input type="text" name="limiteCredito" class="form-control money" placeholder="00.00" value="${cliente.limiteCredito}" autocomplete="off" required>
		     	</div>
			</div>
			<div class="col-lg-5">
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
				  	<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoBom" value="BOM" ${cliente.situacaoCliente == SituacaoCliente.BOM ? 'checked' : cliente == null? 'checked' : ''}>
				  	<label class="form-check-label" for="situacaoBom" style="font-weight: normal;">Bom</label>
				</div>
				<div class="form-check form-check-inline"> 
				  	<input class="form-check-input" type="radio" name="situacaoCliente" id="situacaoOtimo" value="OTIMO" ${cliente.situacaoCliente == SituacaoCliente.OTIMO ? 'checked' : ''}>
				  	<label class="form-check-label" for="situacaoOtimo" style="font-weight: normal;">Ótimo</label>
				</div>
			</div>
			<div class="col-lg-2">
				<label for="cep">CEP:</label>
				<input type="text" name="cep" class="form-control cep" placeholder="XX.XXX-XXX" value="${cliente.cep}" autocomplete="off" required>
			</div>
			<div class="col-lg-5">
				<label for="cidade">Cidade:</label>
				<input type="text" name="cidade" id="cidade" class="form-control" placeholder="Cidade" value="${cliente.cidade}" autocomplete="off" required>
			</div>	
			<div class="col-lg-1">
				<label for="estado">UF:</label>
				<input type="text" name="estado" id="estado" class="form-control" placeholder="UF" maxlength="2" value="${cliente.estado}" autocomplete="off" required>
			</div>	
			<div class="col-lg-4">
				<label for="bairro">Bairro:</label>
				<input type="text" name="bairro" id="bairro" class="form-control" placeholder="Bairro" value="${cliente.bairro}" autocomplete="off" required>
			</div>	
			<div class="col-lg-4">
				<label for="rua">Rua:</label>
				<input type="text" name="rua" id="rua" class="form-control" placeholder="Rua" value="${cliente.rua}" autocomplete="off" required>
			</div>	
			<div class="col-lg-1">
				<label for="numero">Nº:</label>
				<input type="number" name="numero" class="form-control only-number" placeholder="Nº" value="${cliente.numero}" autocomplete="off" required>
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
