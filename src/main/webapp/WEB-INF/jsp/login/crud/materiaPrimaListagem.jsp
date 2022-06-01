<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.projeto.util.SistemaUtil" %>
<%@ page import="org.springframework.web.servlet.support.ServletUriComponentsBuilder" %>

<%    		
	boolean cadMateriaPrima = SistemaUtil.temPermissao(request, "/login/crud/MateriaPrima/criar");
	boolean removeMateriaPrima = SistemaUtil.temPermissao(request, "/login/crud/MateriaPrima/excluir");
%>

<script type="text/javascript">
	function excluirMateriaPrima(id){
		if(confirm("Tem certeza que deseja excluir essa matéria prima?")){
			window.location.href = "/login/crud/MateriaPrima/excluir?id="+id;
		}
	}
</script>
<div class="tituloPaginas">
	<h1>Listagem de matérias-primas</h1>
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
		<c:if test="<%=cadMateriaPrima%>"><a class="btn btn-success" href="/login/crud/MateriaPrima/criar"><i class="fa fa-plus "></i> Novo</a></c:if>
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
					<c:if test="<%=cadMateriaPrima%>"><a class="btn btn-secondary btn-sm" href="/login/crud/MateriaPrima/criar?id=${materiaPrima.id}" title="Editar"><i class="fa fa-pencil"></i></a></c:if>
					<c:if test="<%=removeMateriaPrima%>"><button class="btn btn-danger btn-sm" onclick="excluirMateriaPrima(${materiaPrima.id});" title="Excluir"><i class="fa fa-trash"></i></button></c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
