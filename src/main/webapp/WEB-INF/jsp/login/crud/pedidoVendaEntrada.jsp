<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.projeto.bean.enums.TipoPessoa"%>

<h1>Cadastro de pedido de venda</h1>

<c:if test="${empty pedidoVenda}">
	<div class="row" id="divSelectCliente">
		<div class="col-xs-10 col-sm-6 col-md-6 col-lg-4">
			<label for="clienteSelect">Selecione um cliente: </label> <select
				name="clienteSelect" id="clienteSelect" class="form-control"
				onchange="openIframe();" required>
				<option></option>
				<c:forEach items="${listaCliente}" var="cliente">
					<option value="${cliente.id}">${cliente.nome}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-xs-2 col-sm-2 col-md-1 col-lg-1 align-self-end">
			<button type="button" class="btn btn-success">OK</button>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	function openIframe() {
		var indexCliente = $('#clienteSelect').val();
		if (indexCliente != "") {
			console.log("Index: " + indexCliente)
		}
	}
</script>