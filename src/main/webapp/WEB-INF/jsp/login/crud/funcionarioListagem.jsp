<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.util.SistemaUtil" %>

<%    		
	boolean cadFuncionario = SistemaUtil.temPermissao(request, "/login/crud/Funcionario/criar");
	boolean removeFuncionario = SistemaUtil.temPermissao(request, "/login/crud/Funcionario/excluir");
%>

<script type="text/javascript">
	function excluirFuncionario(id){
		if(confirm("Tem certeza que deseja excluir esse funcionario?")){
			window.location.href = "/login/crud/Funcionario/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de funcionários</h1>
	<div>
		<c:if test="<%=cadFuncionario%>"><a class="btn btn-success" href="/login/crud/Funcionario/criar"><i class="fa fa-plus "></i> Novo</a></c:if>
	</div>
</div>
<div>
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-3">Nome</th>
			<th class="col-3">Email</th>
			<th class="col-2">Telefone</th>
			<th class="col-2">Cargo</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaFuncionario}" var="funcionario" >
			<tr class="row">
				<td class="col-3">${funcionario.nome}</td>
				<td class="col-3">${funcionario.email}</td>
				<td class="col-2">${funcionario.telefone}</td>
				<td class="col-2">${funcionario.cargo.descricao}</td>
				<td class="col-2 colunaAcao">
					<c:if test="<%=cadFuncionario%>"><a class="btn btn-secondary btn-sm" href="/login/crud/Funcionario/criar?id=${funcionario.id}" title="Editar"><i class="fa fa-pencil"></i></a></c:if>
					<c:if test="<%=removeFuncionario%>"><button class="btn btn-danger btn-sm" onclick="excluirFuncionario(${funcionario.id});" title="Excluir"><i class="fa fa-trash"></i></button></c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
