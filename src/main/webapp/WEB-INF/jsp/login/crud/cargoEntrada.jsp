<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Cadastro de cargos</h1>		

<form action="/login/crud/Cargo/salvar" method="POST" accept-charset="utf-8">
	<div class="form-group">
		<input type="hidden" name="id" value="${cargo.id}">
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao" class="form-control" placeholder="Descrição" value="${cargo.descricao}" autocomplete="off" required>

		<div class="bs-example bs-example-tabs" data-example-id="togglable-tabs">
			<ul id="myTabs" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Home</a></li>
				<li role="presentation" class=""><a href="#profile" role="tab"id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">Profile</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
					<p>Raw denim you probably haven't heard of them jean shorts
						Austin. Nesciunt tofu stumptown aliqua, retro synth master
						cleanse.</p>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="profile"	aria-labelledby="profile-tab">
					<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla
						single-origin coffee squid. Exercitation +1 labore velit, blog
						sartorial PBR leggings next level wes anderson artisan four loko
						farm-to-table craft beer twee. Qui photo booth letterpress</p>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="dropdown1" aria-labelledby="dropdown1-tab">
					<p>Etsy mixtape wayfarers, ethical wes anderson tofu before
						they sold out mcsweeney's organic lomo retro fanny pack lo-fi
						farm-to-table readymade. Messenger bag gentrify pitchfork tattooed
						craft beer</p>
				</div>
				<div role="tabpanel" class="tab-pane fade" id="dropdown2" aria-labelledby="dropdown2-tab">
					<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
						etsy art party before they sold out master cleanse gluten-free
						squid scenester freegan cosby sweater.</p>
				</div>
			</div>
		</div>

		<br>
		<div class="barraBotoes">
			<a class="btn btn-secondary" href="/login/crud/Cargo"><i class="fa fa-reply"></i> Voltar para listagem</a>
			<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
		</div>
	</div>
</form>	
