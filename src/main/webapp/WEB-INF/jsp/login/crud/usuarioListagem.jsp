<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirUsuario(id){
		if(confirm("Tem certeza que deseja excluir esse usuário?")){
			window.location.href = "/login/crud/Usuario/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de usuários</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/Usuario/criar"><i class="fa fa-plus "></i> Novo</a>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-5">Nome</th>
			<th class="col-4">Login</th>
			<th class="col-1">Admin</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaUsuario}" var="usuario" >
			<tr class="row">
				<td class="col-5">${usuario.nome}</td>
				<td class="col-4">${usuario.login}</td>
				<td class="col-1">${usuario.admin == true ? "SIM" : "NÃO"}</td>
				<td class="col-2 colunaAcao">
					<button class="btn btn-danger" onclick="excluirUsuario(${usuario.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
