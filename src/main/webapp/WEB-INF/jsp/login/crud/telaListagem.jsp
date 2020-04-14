<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.util.SistemaUtil" %>

<%    		
	boolean cadTela = SistemaUtil.temPermissao(request, "/login/crud/Tela/criar");
	boolean removeTela = SistemaUtil.temPermissao(request, "/login/crud/Tela/excluir");
%>

<script type="text/javascript">
	function excluirTela(id){
		if(confirm("Tem certeza que deseja excluir essa tela?")){
			window.location.href = "/login/crud/Tela/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de telas</h1>
	<div>
		<c:if test="<%=cadTela%>"><a class="btn btn-success" href="/login/crud/Tela/criar"><i class="fa fa-plus "></i> Novo</a></c:if>
	</div>
</div>
<div>

<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<tr class="row">
			<th class="col-3">Módulo</th>
			<th class="col-7">Uri</th>
			<th class="col-2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaTela}" var="tela" >
			<tr class="row">
				<td class="col-3">${tela.modulo}</td>
				<td class="col-7">${tela.uri}</td>
				<td class="col-2 colunaAcao">
					<c:if test="<%=cadTela%>"><a class="btn btn-secondary btn-sm" href="/login/crud/Tela/criar?id=${tela.id}" title="Editar"><i class="fa fa-pencil"></i></a></c:if>
					<c:if test="<%=removeTela%>"><button class="btn btn-danger btn-sm" onclick="excluirTela(${tela.id});" title="Excluir"><i class="fa fa-trash"></i></button></c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
