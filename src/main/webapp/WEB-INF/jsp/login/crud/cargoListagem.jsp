<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirCargo(id){
		if(confirm("Tem certeza que deseja excluir esse cargo?")){
			window.location.href = "/login/crud/Cargo/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de cargos</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/Cargo/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-10">Descrição</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaCargo}" var="cargo" >
			<tr class="row">
				<td class="col-10">${cargo.descricao}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary btn-sm" href="/login/crud/Cargo/criar?id=${cargo.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger btn-sm" onclick="excluirCargo(${cargo.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
