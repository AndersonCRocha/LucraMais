<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.projeto.bean.enums.TipoPessoa" %>

<style>
	::-webkit-scrollbar {
	    width: 8px;
	    height: 10px;
	}
	::-webkit-scrollbar-thumb {
	    -webkit-border-radius: 10px;
	    border-radius: 10px;
	    background: #619bd9; 
	    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
	}
</style>
<form action="/login/crud/PedidoVenda/salvar" method="post" accept-charset="utf-8" id="formPedidoVenda">
	<input type="hidden" name="formaPagamento" value="${pedidoVenda.formaPagamento}">
	<input type="hidden" name="id" value="${pedidoVenda.id}">
	<div class="form-group">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<fieldset>
					<legend>Dados do cliente</legend>
				    <div class="row">
				    	<input type="hidden" name="cliente.id" value="${pedidoVenda.cliente.id}">
				    	<div class="col-8">
				    		<label for="nomeCliente">Nome:</label>
				    		<input type="text" id="nomeCliente" name="cliente.nome" class="form-control" value="${pedidoVenda.cliente.nome}" readonly>
				    	</div>
				    	<div class="col-4">
				    		<label for="limiteCliente">Limite</label>
				    		<div class="input-group">
						        <div class="input-group-prepend">
						        	<div class="input-group-text">R$</div>
						        </div>
					    		<input type="text" id="limiteCliente" name="cliente.limiteCredito" class="form-control" value="${pedidoVenda.cliente.limiteCredito}" readonly>
					     	</div>
				    	</div>
				    	<div class="col-4">
				    		<label for="situacaoCliente">Reputação:</label>
				    		<input type="text" id="situacaoCliente" name="cliente.situacaoCliente" class="form-control" value="${pedidoVenda.cliente.situacaoCliente}" readonly>
				    	</div>
				    	<div class="col-4">
				    		<label for="tipoPessoa">Tipo:</label>
				    		<input type="text" id="tipoPessoa" name="cliente.tipoPessoa" class="form-control" value="${pedidoVenda.cliente.tipoPessoa}" readonly>
				    	</div>
				    	<c:choose>
					    	<c:when test="${pedidoVenda.cliente.tipoPessoa == TipoPessoa.PESSOA_FISICA }">
						    	<div class="col-4">
						    		<label for="cpfCliente">CPF</label>
						    		<input type="text" id="cpfCliente" name="cliente.cpf" class="form-control" value="${pedidoVenda.cliente.cpf}" readonly>
						    	</div>
					    	</c:when>
					    	<c:otherwise>
						    	<div class="col-4">
						    		<label for="cnpjCliente">CNPJ</label>
						    		<input type="text" id="cnpjCliente" name="cliente.cnpj" class="form-control" value="${pedidoVenda.cliente.cnpj}" readonly>
						    	</div>
					    	</c:otherwise>
				    	</c:choose>
				    </div>
				</fieldset>
			</div>
			<div class="col-lg-6 col-md-6">
				<fieldset>
					<legend>Dados gerais do pedido</legend>
					<div class="row">
				    	<div class="col-8">
				    		<label for="nomeFuncionario">Vendedor:</label>
				    		<input type="text" id="nomeFuncionario" name="funcionario.nome" class="form-control" value="${pedidoVenda.funcionario.nome}" readonly>
				    		<input type="hidden" name="funcionario.id" value="${pedidoVenda.funcionario.id}">
				    	</div>
				    	<div class="col-4">
				    		<label for="dataVenda">Data:</label>
				    		<input type="text" name="dataVendaTela" class="form-control" value="<fmt:formatDate value="${pedidoVenda.dataVenda}" pattern="dd/MM/yyyy"/>" disabled>
				    		<input type="hidden" id="dataVenda" name="dataVenda"  value="${pedidoVenda.dataVenda}">
				    	</div>
				    	<div class="col-4">
			    			<label for="itens">Qtd itens:</label>
				    		<input type="text" id="itens" name="itens" class="form-control" value="" disabled>
				    	</div>
				    	<div class="col-4">
			    			<label for="unidades">Unidades:</label>
				    		<input type="text" id="unidades" name="unidades" class="form-control" value="" disabled>
				    	</div>
				    	<div class="col-4">
			    			<label for="valorTotal">Valor total:</label>
				    		<div class="input-group">
						        <div class="input-group-prepend">
						        	<div class="input-group-text">R$</div>
						        </div>
					    		<input type="text" id="valorTotal" name="valorTotal" class="form-control" value="${pedidoVenda.valorTotal}" readonly>
					     	</div>
				    	</div>
				    </div>
				</fieldset>
			</div>
			<div class="col-12">
				<fieldset class="fieldsetProdutos">
					<div class="row">
						<div class="col-12">
							<table class="table table-striped table-sm tabelaProdutos">
								<thead class="thead-dark">
									<tr class="row">
										<th class="col-6">Nome</th>
										<th class="col-1">Un</th>
										<th class="col-1">Qtd</th>
										<th class="col-2 textoDireita">Preço un.</th>
										<th class="col-2 textoDireita">Valor total</th>
									</tr>
								</thead>
								<tbody id="produtos">
									<c:forEach items="${pedidoVenda.listaProdutoItem}" var="item" varStatus="loop">
										<tr class="row itemPedido" id="produto${item.produto.id}">
									  		<td class="col-6">${item.produto.nome}
										  		<input type="hidden" name="listaProdutoItem[${loop.index}].produto.id" value="${item.produto.id}">
										  		<input type="hidden" class="valorTotal" value="${item.quantidade * item.produto.precoVenda}">
									  		</td>
									  		<td class="col-1">${item.produto.unidadeMedida}</td>
									  		<td class="col-1">${item.quantidade}
									  			<input type="hidden" name="listaProdutoItem[${loop.index}].quantidade" value="${item.quantidade}">
								  			</td>
									  		<td class="col-2 textoDireita"><fmt:formatNumber pattern="###0.00" value="${item.produto.precoVenda }"/></td>
									  		<td class="col-2 textoDireita"><fmt:formatNumber pattern="###0.00" value="${item.quantidade * item.produto.precoVenda}"/></td>
								  		</tr>
									</c:forEach>
								</tbody>
							</table>	
						</div>
					</div>
				</fieldset>
			</div>
		</div>
		<div class="controlesPV">
			<div>
				<button type="button" title="Remover item (del)" class="btn btn-danger" onclick="removerItem();"><i class="fa fa-trash"></i> Remover</button>
				<button type="button" title="Adicionar item (alt + N)" class="btn btn-success" data-toggle="modal" data-target="#modalProdutos"><i class="fa fa-plus"></i> Adicionar</button>
			</div>
			<div class="barraBotoes">
				<a class="btn btn-secondary" href="/login/crud/PedidoVenda"><i class="fa fa-reply"></i> Voltar para listagem</a>
				<button type="button" title="Salvar (ctrl + S)" class="btn btn-primary" onclick="salvarPedido();"><i class="fa fa-save"></i> Salvar</button>
			</div>
		</div>
	</div>
</form>

<!-- Modal -->
<div class="modal fade " id="modalProdutos" tabindex="-1" role="dialog" aria-labelledby="produtosEstoque" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" id="teste">
			<div class="modal-header">
				<h5 class="modal-title" id="produtosEstoque">Produtos</h5>
			</div>
			<div class="modal-body">
				<label for="produto">Digite o nome do produto: </label>
				<input type="text" id="produto" class="form-control pesquisaProduto"> <br>
				<div class="row">
					<div class="col-lg-9">
						<div class="col tabelaResultados">
							<table class="table table-sm table-striped">
								<thead class="thead-dark">
									<tr class="row">
										<th class="col-1">Un.</th>
										<th class="col-5">Nome</th>
										<th class="col-4">Fornecedor</th>
										<th class="col-2 textoDireita">Valor</th>
									</tr>
								</thead>
								<tbody class="resultadoPesquisa">	
<!-- 									Resultados que serão adicionados após a requisição ajax -->
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-lg-3">
						<fieldset class="descricaoProduto">
							<legend>Descrição</legend>
							<span id="descricao"></span>
						</fieldset>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<button type="button" class="btn btn-primary" onclick="adicionarProdutoNoPedido();">Adicionar</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalFormaPagamento" tabindex="-1" role="dialog" aria-labelledby="formaDePagamento" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="formaDePagamento">Escolha a forma de pagamento</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body formasDePagamento">
				<div class="divFormaPagamento" forma="A_VISTA"><i class="fa fa-money"></i> A vista</div>
				<div class="divFormaPagamento" forma="DEBITO"><i class="fa fa-money"></i> Débito</div>
				<div class="divFormaPagamento" forma="CREDITO"><i class="fa fa-credit-card"></i> Crédito</div>
				<div class="divFormaPagamento" forma="CHEQUE"><i class="fa fa-money"></i> Cheque</div>
				<div class="divFormaPagamento" forma="BOLETO"><i class="fa fa-file-text-o"></i> Boleto</div>
			</div>
		</div>
	</div>
</div>

<script src="/js/utilDOM.js"></script>
<script src="/js/pedidoVenda.js"></script>
