if(document.querySelector("input[type='checkbox']") != null){
	document.querySelector("input[type='checkbox']").addEventListener("change", function(){
		if($(this).is(':checked')){
			$(this).val(true);
		}else{
			$(this).val(false);
		}
	});
}

$('.date').mask('00/00/0000');
$('.time').mask('00:00:00');
$('.date_time').mask('00/00/0000 00:00:00');
$('.cep').mask('00000-000');
$('.phone').mask('(00) 00000-0000');
$('.ip_address').mask('099.099.099.099');
$('.percent').mask('##0,00%', {reverse: true});
$('.pis').mask('000.00000.00-0');
$('.cpf').mask('000.000.000-00');
$('.cnpj').mask('00.000.000/0000-00');
$('.rg').mask('00.000.000-09');
$('.money').mask('###0.00', {reverse: true});