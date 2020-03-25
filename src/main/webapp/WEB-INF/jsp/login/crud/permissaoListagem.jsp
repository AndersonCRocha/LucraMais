<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirPermissao(id){
		if(confirm("Tem certeza que deseja excluir essa permissao?")){
			window.location.href = "/login/crud/Permissao/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de permiss�es</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/Permissao/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-10">Uri</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaPermissao}" var="permissao" >
			<tr class="row">
				<td class="col-10">${permissao.uri}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary" href="/login/crud/Permissao/criar?id=${permissao.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger" onclick="excluirPermissao(${permissao.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
