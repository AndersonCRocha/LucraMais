<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.util.SistemaUtil" %>
<%@ page import="org.springframework.web.servlet.support.ServletUriComponentsBuilder" %>

<%    		
	boolean cadFornecedor = SistemaUtil.temPermissao(request, "/login/crud/Fornecedor/criar");
	boolean removeFornecedor = SistemaUtil.temPermissao(request, "/login/crud/Fornecedor/excluir");
%>
<script type="text/javascript">
	function excluirFornecedor(id){
		if(confirm("Tem certeza que deseja excluir esse fornecedor?")){
			window.location.href = "/login/crud/Fornecedor/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de fornecedores</h1>
	<div class="caixa-pesquisa">
		<a href="<%= ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString() %>" class="btn btn-danger">
			<i class="fa fa-ban"></i>
		</a>
		<c:set var="search" value="<%= request.getParameter(\"q\") %>"/>
		<input type="text" name="pesquisa" id="pesquisa" placeholder="Pesquisar por nome" value="${not empty search ? search : ''}">
		<button class="btn btn-info" onclick="pesquisar();">
			<i class="fa fa-search"></i> Buscar
		</button>
	</div>
	<div>
		<c:if test="<%=cadFornecedor%>"><a class="btn btn-success" href="/login/crud/Fornecedor/criar"><i class="fa fa-plus "></i> Novo</a></c:if>
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
					<c:if test="<%=cadFornecedor%>"><a class="btn btn-secondary btn-sm" href="/login/crud/Fornecedor/criar?id=${fornecedor.id}" title="Editar"><i class="fa fa-pencil"></i></a></c:if>
					<c:if test="<%=removeFornecedor%>"><button class="btn btn-danger btn-sm" onclick="excluirFornecedor(${fornecedor.id});" title="Excluir"><i class="fa fa-trash"></i></button></c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
