<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirFornecedor(id){
		if(confirm("Tem certeza que deseja excluir esse fornecedor?")){
			window.location.href = "/login/crud/Fornecedor/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de fornecedores</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/Fornecedor/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-3">Nome</th>
			<th class="col-3">Email</th>
			<th class="col-2">Telefone</th>
			<th class="col-2">CNPJ</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaFornecedor}" var="fornecedor" >
			<tr class="row">
				<td class="col-3">${fornecedor.nome}</td>
				<td class="col-3">${fornecedor.email}</td>
				<td class="col-2">${fornecedor.telefone}</td>
				<td class="col-2">${fornecedor.cnpj}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary" href="/login/crud/Fornecedor/criar?id=${fornecedor.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger" onclick="excluirFornecedor(${fornecedor.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
