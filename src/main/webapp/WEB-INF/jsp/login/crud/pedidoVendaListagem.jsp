<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			<th class="col-1">Nº</th>
			<th class="col-5">Cliente</th>
			<th class="col-2">Valor</th>
			<th class="col-2">Data</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaPedidoVenda}" var="pedidoVenda" >
			<tr class="row">
				<td class="col-1">${pedidoVenda.id}</td>
				<td class="col-5">${pedidoVenda.cliente.nome}</td>
				<td class="col-2"><fmt:formatNumber pattern=" R$ ####.##" value="${pedidoVenda.valorTotal}"/> </td>
				<td class="col-2"><fmt:formatDate value="${pedidoVenda.dataVenda}" pattern="dd/MM/yyyy"/></td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary btn-sm" href="/login/crud/PedidoVenda/criar?id=${pedidoVenda.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger btn-sm" onclick="excluirPedidoVenda(${pedidoVenda.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
