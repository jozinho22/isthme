<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<tag:begin />
<%@ include file="/WEB-INF/tags/gestion-navbar.jsp"%>

<div id="section">
	<div class="py-5 text-center">
		<div class="container py-4 text-white">
			<header>
				<p class="font-italic mb-1">Rechercher un client.</p>
			</header>
		</div>
	</div>
	<form id="custom-form" action="resultat-recherche-clients" method="GET">
		<div class="col-12 col-sm-6 col-md-6 text-center">
			<input name="req-recherche" placeholder="Recherche de clients"
				class="form-control" style="display: inline-block;">
			<hr>
			<div class="center">
				<button style="display: inline-block;" class="btn btn-success"
					type="submit">Valider</button>
			</div>
		</div>
	</form>
</div>

<tag:end />