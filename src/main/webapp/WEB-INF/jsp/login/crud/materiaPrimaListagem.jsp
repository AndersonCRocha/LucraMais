<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function excluirMateriaPrima(id){
		if(confirm("Tem certeza que deseja excluir essa matéria prima?")){
			window.location.href = "/login/crud/MateriaPrima/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de matérias-primas</h1>
	<div>
		<a class="btn btn-success" href="/login/crud/MateriaPrima/criar"><i class="fa fa-plus "></i> Novo</a>
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
		<c:forEach items="${listaMateriaPrima}" var="materiaPrima" >
			<tr class="row">
				<td class="col-2">${materiaPrima.nome}</td>
				<td class="col-1">${materiaPrima.unidadeMedida}</td>
				<td class="col-4">${materiaPrima.descricaoNutricional}</td>
				<td class="col-2">${materiaPrima.fornecedor.nome}</td>
				<td class="col-1">R$ ${materiaPrima.precoCompra}</td>
				<td class="col-2 colunaAcao">
					<a class="btn btn-secondary btn-sm" href="/login/crud/MateriaPrima/criar?id=${materiaPrima.id}" title="Editar"><i class="fa fa-pencil"></i></a>
					<button class="btn btn-danger btn-sm" onclick="excluirMateriaPrima(${materiaPrima.id});" title="Excluir"><i class="fa fa-trash"></i></button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
