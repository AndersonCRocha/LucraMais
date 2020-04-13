<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.projeto.bean.enums.TipoPessoa"%>

<c:if test="${empty pedidoVenda}">
	<div id="novoPedidoVenda">
		<h1>Pedido de venda</h1>
	
		<div class="row" id="divSelectCliente">
			<div class="col-xs-10 col-sm-6 col-md-6 col-lg-5">
				<form id="formCliente" method="post">
					<div class="input-group">
						<select name="clienteSelect" id="clienteSelect" class="form-control selectTwo" style="width: 80%;" autofocus required>
							<option></option>
							<c:forEach items="${listaCliente}" var="cliente">
								<option value="${cliente.id}">${cliente.nome}</option>
							</c:forEach>
						</select>
				        <div class="input-group-append">
				        	<div class="input-group">
								<button type="button" class="btn btn-success" id="btnOk" onclick="openIframeCriacao();">OK</button>
				        	</div>
				        </div>
			     	</div>
				</form>
			</div>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	function openIframeCriacao() {
		var indexCliente = $('#clienteSelect').val();
		
		if (indexCliente != "") {
			$('#novoPedidoVenda').css("display","none");

			$.ajax({
				url: "/login/crud/PedidoVenda/iframeCriacao?id="+indexCliente,
				type: 'post',
				dataType: 'html',
				async: false,
				success: function(retorno){
					$('.content').append(retorno);
				}
			});

		}else{
			alert("Selecione um cliente!");
		}
	}

	$('#clienteSelect').on("keydown", (e) => {
		if(e.which == 13) {
			e.preventDefault();
			$('#btnOk').click();
		}
	});

</script>
