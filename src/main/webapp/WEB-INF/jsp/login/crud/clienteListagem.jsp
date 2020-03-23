<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirCliente(id){
		if(confirm("Tem certeza que deseja excluir esse cliente?")){
			window.location.href = "/login/crud/Cliente/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de clientes</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/Cliente/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-3">Nome</th>
			<th class="col-2">Email</th>
			<th class="col-2">Telefone</th>
			<th class="col-2">Limite/Crédito</th>
			<th class="col-1">Situação</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaCliente}" var="cliente" >
			<tr class="row">
				<td class="col-3">${cliente.nome}</td>
				<td class="col-2">${cliente.email}</td>
				<td class="col-2">${cliente.telefone}</td>
				<td class="col-2">R$ ${cliente.limiteCredito}</td>
				<td class="col-1">${cliente.situacaoCliente.tipo}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary" href="/login/crud/Cliente/criar?id=${cliente.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger" onclick="excluirCliente(${cliente.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
