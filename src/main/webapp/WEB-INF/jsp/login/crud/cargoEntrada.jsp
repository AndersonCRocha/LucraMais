<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<h1>Cadastro de cargos</h1>	

<div id="erroAdicao"></div>
<form action="/login/crud/Cargo/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${cargo.id}">
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao" class="form-control" placeholder="Descrição" value="${cargo.descricao}" autocomplete="off" required>
		
		<div class="row" style="padding-left:15px;padding-right:15px;">
			<div class="detalhe permissoesCargo col-xs-12 col-lg-6">
				<div class="row justify-content-between">
					<h4>Permissões adicionadas</h4>
					<button type="button" id="btnRemoveAll" onclick="removerTodas(this)" class="btn btn-sm btn-danger" ${fn:length(cargo.listaPermissao) == 0 ? 'disabled' : '' }> Remover todas</button>
				</div>
				<table class="table table-striped table-bordered table-sm">
					<thead class="thead-dark">
						<tr class="row">
							<th class="col-12">Uri</th>
						</tr>
					</thead>
					<tbody id="permissoes">
						<c:forEach items="${cargo.listaPermissao}" var="permissao" varStatus="loop">
							<tr class="row">
								<td class="col-12">
									<button onclick="removePermission(this, ${permissao.tela.id});" class="btn btn-danger btn-sm btnRemove" title="Excluir permissão">
										<i class="fa fa-remove"></i>
									</button> <b>${permissao.tela.modulo}</b> - ${ permissao.tela.uri}
									<input type="hidden" id="tela${permissao.tela.id}" class="permissao" name="listaPermissao[${loop.index}].tela.id" value="${permissao.tela.id}">
									<input type="hidden" id="tela${permissao.id}" class="permissaoid" name="listaPermissao[${loop.index}].id" value="${permissao.id}">
								</td>
						   </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="detalhe permissoesCargo col-xs-12 col-lg-6">
				<div class="row justify-content-between">
					<h4>Telas</h4>
					<button type="button" id="btnAddAll" onclick="adicionarTodas(this)" class="btn btn-sm btn-success" ${fn:length(cargo.listaPermissao) == fn:length(listaTela) ? 'disabled' : ''}>Selecionar tudo</button>
				</div>
				
				<table class="table table-striped table-bordered table-sm">
					<thead class="thead-dark">
						<tr class="row">
							<th class="col-12">Uri</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaTela}" var="tela" varStatus="loop">
							<tr class="row telas" id="linhaTela${tela.id}">
								<td class="col-12">
									<button type="button" id="btnAdd${tela.id}" onclick="addPermission(this, ${tela.id}, '${tela.uri}', '${tela.modulo}');" class="btn btn-success btn-sm btnAdd" title="Adicionar permissão">
										<i class="fa fa-plus"></i>
									</button> <b>${tela.modulo}</b> - ${tela.uri}
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="barraBotoes">
		<a class="btn btn-secondary" href="/login/crud/Cargo"><i class="fa fa-reply"></i> Voltar para listagem</a>
		<button type="submit" class="btn btn-primary" ><i class="fa fa-save"></i> Salvar</button>
	</div>
</form>	

<script>
	$(document).ready(function(){
		$('.permissao').each(function(){
			var idTela = $(this).val();
			var tela = $('#linhaTela'+idTela);
			if(tela.length != 0){
				tela.css("display","none");
			}
		});
	});
	
	function addPermission(el, id, uri, modulo){
		$(el).parent().parent().css("display","none");
		$('#btnRemoveAll').prop("disabled",false);

		if(!foiAdicionado(id)){
			var qtdPermissoes = $('.permissao').length;
			var tbody = $('#permissoes');
			var html = '<tr class="row">'+
							'<td class="col-12">'+
								'<button onclick="removePermission(this, '+id+');" class="btn btn-danger btn-sm btnRemove" title="Excluir permissão">'+
									'<i class="fa fa-remove"></i>'+
								'</button> <b>'+modulo+'</b> - '+uri+
								'<input type="hidden" id="tela'+id+'" class="permissao" name="listaPermissao['+qtdPermissoes+'].tela.id" value="'+id+'">'+
							'</td>'+
					   '</tr>';
			
			tbody.append(html);

			if($('.telas').length === $('.permissao').length){
				$('#btnAddAll').prop("disabled",true);
			}
		}
	}
	
	function removePermission(el, id){
		$(el).parent().parent().remove();
		$('#linhaTela'+id).css("display","block");
		if($('.permissao').length === 0){
			$('#btnRemoveAll').prop("disabled",true);
		}
		if($('.telas').length !== $('.permissao').length){
			$('#btnAddAll').prop("disabled",false);
		}
		reindexPermission();
	}
	
	function reindexPermission(){
		$('.permissao').each(function(index){
			var novoNome = 'listaPermissao['+index+'].tela.id';
			$(this).attr("name", novoNome);
		});
		$('.permissaoid').each(function(index){
			var novoNome = 'listaPermissao['+index+'].id';
			$(this).attr("name", novoNome);
		});
	}
	
	function foiAdicionado(id){
		if($('#tela'+id).length != 0){
			return true;
		}else{
			return false;
		}
	}

	function adicionarTodas(el){
		$(el).prop("disabled",true);
		$('#btnRemoveAll').prop("disabled",false);
		$('.btnAdd').each(function(){
			$(this).click();
		});
	}
	
	function removerTodas(el){
		$(el).prop("disabled",true);
		$('#btnAddAll').prop("disabled",false);
		$('.btnRemove').each(function(){
			$(this).click();
		});
	}
</script>
