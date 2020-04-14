<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.util.SistemaUtil" %>

<%    		
	boolean cadProduto = SistemaUtil.temPermissao(request, "/login/crud/Produto/criar");
	boolean removeProduto = SistemaUtil.temPermissao(request, "/login/crud/Produto/excluir");
%>

<script type="text/javascript">
	function excluirProduto(id){
		if(confirm("Tem certeza que deseja excluir esse produto?")){
			window.location.href = "/login/crud/Produto/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de produtos</h1>
	<div>
		<c:if test="<%=cadProduto%>"><a class="btn btn-success" href="/login/crud/Produto/criar"><i class="fa fa-plus "></i> Novo</a></c:if>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-2">Nome</th>
			<th class="col-1">Un.</th>
			<th class="col-4">Descrição Nutricional</th>
			<th class="col-2">Fornecedor</th>
			<th class="col-1">Preço</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaProduto}" var="produto" >
			<tr class="row">
				<td class="col-2">${produto.nome}</td>
				<td class="col-1">${produto.unidadeMedida}</td>
				<td class="col-4">${produto.descricaoNutricional}</td>
				<td class="col-2">${produto.fornecedor.nome}</td>
				<td class="col-1">R$ ${produto.precoVenda}</td>
				<td class="col-2 colunaAcao">
					<c:if test="<%=cadProduto%>"><a class="btn btn-secondary btn-sm" href="/login/crud/Produto/criar?id=${produto.id}" title="Editar"><i class="fa fa-pencil"></i></a></c:if>
					<c:if test="<%=removeProduto%>"><button class="btn btn-danger btn-sm" onclick="excluirProduto(${produto.id});" title="Excluir"><i class="fa fa-trash"></i></button></c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
