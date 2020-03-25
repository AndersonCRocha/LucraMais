<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirPedidoVenda(id){
		if(confirm("Tem certeza que deseja excluir esse pedido de venda?")){
			window.location.href = "/login/crud/PedidoVenda/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de pedidos de vendas</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/PedidoVenda/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-2">Número</th>
			<th class="col-8">Cliente</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaPedidoVenda}" var="pedidoVenda" >
			<tr class="row">
				<td class="col-2">${pedidoVenda.id}</td>
				<td class="col-8">${pedidoVenda.cliente.nome}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary" href="/login/crud/PedidoVenda/criar?id=${pedidoVenda.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger" onclick="excluirPedidoVenda(${pedidoVenda.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
