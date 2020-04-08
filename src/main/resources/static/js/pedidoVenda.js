$(document).ready(function(){
	atualizaDadosGerais();
});

window.onbeforeunload = function (e) {
	// Cancel the event
	e.preventDefault(); // If you prevent default behavior in Mozilla Firefox prompt will always be shown
	// Chrome requires returnValue to be set
	e.returnValue = '';
	return null;
};

var pressedAlt = false;
var pressedCtrl = false;
$(document).keyup(function (e) {
	if(e.which == 18){
		pressedAlt=false;
	}
	else if(e.which == 17){
		pressedCtrl=false;
	}
})
$(document).keydown(function (e) {
	if(e.which == 18){
		pressedAlt = true;
	}else if(e.which == 17){
		pressedCtrl = true;
	}
	if(e.which == 78 && pressedAlt) {
		//Código executado ao pressionar alt + n
		$('#modalProdutos').modal("toggle");
	}else if(e.which == 83 && pressedCtrl){
		e.preventDefault();
		salvarPedido();
	}
	
});
			
function clickLinhaResultado(){
    $('.active').removeClass("active");
	$(this).addClass("active");
}
$('.linhaResultado').on("click", clickLinhaResultado);

$("#produto").keyup(function( event ){	
	var key = event.which;
	if(key != 37 && key != 38 && key != 39 && key != 40){
		
		var search = $(this).val();
		
		if(search.length >= 3 || search.length == 0){
			$('.resultadoPesquisa').html('');
			$.ajax({
				url: '/login/crud/Produto/listarParaPV',
				type: 'POST',
				dataType: 'json',
				data: {nome : search},
				success: function(retorno){
					for(var i =0; i<retorno.length; i++){
						var linhaTabela =   '<tr class="row linhaResultado">'+
												'<td class="col-1">'+
													'<input type="hidden" class="unidadeMedida" value="'+retorno[i].unidadeMedida+'">'+
													retorno[i].unidadeMedida+
												'</td>'+
												'<td class="col-5">'+
													'<input type="hidden" class="id" value="'+retorno[i].id+'">'+
													'<input type="hidden" class="nome" value="'+retorno[i].nome+'">'+
													retorno[i].nome+
												'</td>'+
												'<td class="col-4">'+
													'<input type="hidden" class="descricao" value="'+retorno[i].descricaoNutricional+'">'+
													retorno[i].fornecedor.nome+
												'</td>'+
												'<td class="col-2 textoDireita"> R$ '+
													'<input type="hidden" class="precoVenda" value="'+retorno[i].precoVenda+'">'+
													retorno[i].precoVenda.toFixed(2)+
												'</td>'+
											'</tr>';
						$('.resultadoPesquisa').append(linhaTabela);
						$('.linhaResultado').on("click", clickLinhaResultado);
						if(i==0){
							$('#descricao').html(retorno[i].descricaoNutricional);
							$('.resultadoPesquisa tr:first-child').addClass("active");
						}
					}
				},
				error: function(){
					console.log('erro');
				}
			});
		}
	}
});

$('#modalProdutos').keydown(function(event){
	key = event.which;
	
	if(key == 37 || key == 38 || key == 39 || key == 40){
		if($('.resultadoPesquisa .linhaResultado').length > 0){
			if( $('.resultadoPesquisa .active').length == 0 ){
				$('.resultadoPesquisa tr:first-child').addClass("active").focus();
				$('.tabelaResultados').scrollTop(0);
			}else{
				var height = $('.resultadoPesquisa tr:first-child').height();
				if(key == 40 || key == 39){
					var anterior = $('.active');
					if($(anterior).next().length != 0){
						anterior.next().addClass("active");
						anterior.removeClass("active");
						$('#descricao').html($('.active .descricao').val());
						$('.tabelaResultados').scrollTop($('.tabelaResultados').scrollTop()+height);
					}
				}else{
					var proxima = $('.active');
					if($(proxima).prev().length != 0){
						proxima.prev().addClass("active");
						proxima.removeClass("active");
						$('#descricao').html($('.active .descricao').val());
						$('.tabelaResultados').scrollTop($('.tabelaResultados').scrollTop()-height);
					}
				}
			}
		}
	}else if(key == 13){
		adicionarProdutoNoPedido();
	}else if(key == 27){
		$(this).modal("toggle");
	}
});

var contador = 0;
function criarLinhaDoPedido(id, nome, unidadeMedida, qtd, precoUnit){
	var valorTotal = (qtd * precoUnit).toFixed(2);
	var linhaPedido =   '<tr class="row itemPedido" id="produto'+id+'">'+
					  		'<td class="col-6">'+nome+
						  		'<input type="hidden" name="listaProdutoItem['+contador+'].produto.id" value="'+id+'">'+
						  		'<input type="hidden" class="valorTotal" value="'+valorTotal+'">'+
					  		'</td>'+
					  		'<td class="col-1">'+unidadeMedida+'</td>'+
					  		'<td class="col-1">'+qtd+
					  			'<input type="hidden" name="listaProdutoItem['+contador+'].quantidade" value="'+qtd+'">'+
				  			'</td>'+
					  		'<td class="col-2 textoDireita">'+precoUnit+'</td>'+
					  		'<td class="col-2 textoDireita">'+valorTotal+'</td>'+
				  		'</tr>';
	
	$('#produtos').append(linhaPedido);
	$('.itemPedido').click(clickLinhaResultado);
	contador++;
	atualizaDadosGerais();
}

function adicionarProdutoNoPedido(){
	var selecionado = $('.resultadoPesquisa .active');
		
	if(selecionado.length == 1){
		if(!produtoJaAdicionado()){
			var qtdString = prompt("Quantas unidades quer adicionar desse produto?");
			if(qtdString != "" && qtdString != null){
				var qtd = parseInt(qtdString);
				
				if(isNaN(qtd)){
					alert("Digite apenas números!")
				}else if(qtd >= 1){
					var id = $('.active .id').val();
					var nome = $('.active .nome').val();
					var unidadeMedida = $('.active .unidadeMedida').val();
					var precoUnit = $('.active .precoVenda').val();
					
					criarLinhaDoPedido(id, nome, unidadeMedida, qtd, precoUnit);
				}else{
					alert("A quantidade deve ser maior ou igual a 1.");
				}
			}
		}else{
			alert("Este produto já foi adicionado ao pedido");
		}
	}else {
		alert("Selecione um produto para adicionar ao pedido.");
	}
}

function atualizaDadosGerais(){
	var itens = 0;
	var unidades = 0;
	var valorTotal = 0.00;
	
	itens = $('.itemPedido').length;
	$('input[name$=".quantidade"]').each(function(){
		unidades += parseInt($(this).val());
	});
	$('.valorTotal').each(function(){
		valorTotal += parseFloat($(this).val());
	});
	
	
	$('#itens').val(itens);
	$('#unidades').val(unidades);
	$('#valorTotal').val(valorTotal.toFixed(2));
}

function produtoJaAdicionado(){
	var id = $('.active .id').val();
	return $('#produto'+id).length != 0;
}

function salvarPedido(){
	window.onbeforeunload = null;
	reindexarProdutosPedido();
	confirmarFormaDePagamento();
}

function confirmarFormaDePagamento(){
	$("#modalFormaPagamento").modal("toggle");
	$('.divFormaPagamento').click(function(){
		var forma = $(this).attr("forma"); 
		var input = '<input type="hidden" name="formaPagamento" value="'+forma+'">';
		$('#formPedidoVenda').prepend(input);
		$("#modalFormaPagamento").modal("toggle");
		$('#formPedidoVenda').submit();
	});
}

function removerItem(selecionado){
	var selecionado = $('#produtos .active'); 
	if($(selecionado).length != 0){
		if(confirm("Deseja excluir esse item do pedido? ")){
			$(selecionado).remove();
		}
	}
}
$('.itemPedido').click(clickLinhaResultado);

$(window).keydown(function(event){
	key = event.which;
	
	if( $('.modal-open').length == 0){
		if(key == 37 || key == 38 || key == 39 || key == 40){
			if($('#produtos .itemPedido').length > 0){
				if( $('#produtos .active').length == 0 ){
					$('#produtos tr:first-child').addClass("active").focus();
					$('#produtos').scrollTop(0);
				}else{
					var height = $('#produtos tr:first-child').height();
					if(key == 40 || key == 39){
						var anterior = $('#produtos .active');
						if($(anterior).next().length != 0){
							anterior.next().addClass("active");
							anterior.removeClass("active");
							$('.fieldsetProdutos').scrollTop($('.fieldsetProdutos').scrollTop()+height);

						}
					}else{
						var proxima = $('#produtos .active');
						if($(proxima).prev().length != 0){
							proxima.prev().addClass("active");
							proxima.removeClass("active");
							$('.fieldsetProdutos').scrollTop($('.fieldsetProdutos').scrollTop()-height);
						}
					}
				}
			}
		}
		if(key == 46){
			removerItem();
		}
	}
});

function reindexarProdutosPedido(){
	$('.itemPedido').each(function(index){
		$(this).find('input[name^="listaProdutoItem"]').each(function(){
			var nome = $(this).attr('name');
			nome = nome.substring(0,17) + index + nome.substring(18, nome.length);
			$(this).attr('name', nome);
		});
	});
}