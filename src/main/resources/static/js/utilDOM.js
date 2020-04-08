if(document.querySelector("input[type='checkbox']") != null){
	document.querySelector("input[type='checkbox']").addEventListener("change", function(){
		if($(this).is(':checked')){
			$(this).val(true);
		}else{
			$(this).val(false);
		}
	});
}

$('.selectTwo').select2({
    placeholder: "Selecione um cliente",
    width: 'resolve'
});

$(window).keydown(function(event){
    if(event.keyCode == 13) {
	    event.preventDefault();
	    return false;
    }
});

$('.date').mask('00/00/0000');
$('.time').mask('00:00:00');
$('.date_time').mask('00/00/0000 00:00:00');
$('.cep').mask('00.000-000');
$('.phone').mask('(00) 00000-0000');
$('.ip_address').mask('099.099.099.099');
$('.percent').mask('##0,00%', {reverse: true});
$('.pis').mask('000.00000.00-0');
$('.cpf').mask('000.000.000-00');
$('.cnpj').mask('00.000.000/0000-00');
$('.rg').mask('00.000.000-09');
$('.money').mask('###0.00', {reverse: true});

$(document).on('keypress', 'input.only-number', function(e) {
	var $this = $(this);
	var key = (window.event)?event.keyCode:e.which;
	
	if(key > 47 && key < 58){
		return true;
	} else {
		return (key == 8 || key == 0) ? true : false;
	}
});

$('.cep').on("blur", function(){
	
	var cep = $(this).val();
	cep = cep.replace(/\.|\-/g, '');

	if(cep.length == 8){
		
		$('body').css("overflow","hidden");
		$('.divCarregamento').css("display","flex");

		$.ajax({
			url: 'https://viacep.com.br/ws/'+cep+'/json/',
			async:false,
			success: function (json){
				
				if(!json.erro){
				
					$('#cidade').val(json.localidade);
					$('#estado').val(json.uf);
					$('#bairro').val(json.bairro);
					$('#rua').val(json.logradouro);
					
					$('#cidade').val(json.localidade);
					$('#estado').val(json.uf);
					$('#bairro').val(json.bairro);
					$('#rua').val(json.logradouro);
				
				}else{
					alert("CEP não encontrado");
				}
			},
			error: function(){
				alert("CEP não encontrado.");
			}
		});
	}
	
	$('body').css("overflow","");
	$('.divCarregamento').css("display","none");
});

