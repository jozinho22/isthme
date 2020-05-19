<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tag:begin />
<%@ include file="/WEB-INF/tags/gestion-navbar.jsp"%>

<div id="section">
	<div class="py-5 text-center">
		<div class="container py-4 text-white">
			<header>
				<p class="font-italic mb-1">Voici les derniers avis reçus.</p>
			</header>
		</div>
	</div>
	<div id="quote" class="col-lg-12 col-xl-10 mx-auto">
		<div class="carousel-inner px-5 pb-4">
			<div class="carousel-item active">
				<blockquote class="blockquote border-0 p-0">
					<b>${avis.author} </b>
					<br> 
					<cite title="Source Title">${avis.quote}</cite>
				</blockquote>
			</div>
		</div>

		<div class="pull-right" style="margin: 10px">
			<form action="valider-avis" method="POST">
				<input name="id" value="${avis.id}">
				<button style="display: inline-block;" class="btn btn-success"
					type="submit">Valider</button>
			</form>
		</div>

		<div class="pull-left" style="margin: 10px">
			<form action="refuser-avis" method="POST">
				<input type="text" name="id" value="${avis.id}" hidden="true">
				<button style="display: inline-block;" class="btn btn-danger"
					type="submit">Refuser</button>
			</form>
		</div>

	</div>
</div>

<tag:end />