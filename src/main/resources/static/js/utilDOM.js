if(document.querySelector("input[type='checkbox']") != null){
	document.querySelector("input[type='checkbox']").addEventListener("change", function(){
		if($(this).is(':checked')){
			$(this).val(true);
		}else{
			$(this).val(false);
		}
	});
}