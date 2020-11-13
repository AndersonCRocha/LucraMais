const pesquisar = () => {
	const url = window.location.pathname;
	const parametro = $('input#pesquisa').val();
	
	if (parametro) {
		window.location.href = `${url}?q=${parametro}`;
	}
}