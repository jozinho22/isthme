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
	<div id="quote" class="col-lg-10 col-xl-8 mx-auto"
		style="text-align: center;">
		<div class="carousel-inner px-5 pb-4">
			<div class="carousel-item active">
				<blockquote class="blockquote border-0 p-0">
				<%
					Integer index = (Integer) session.getAttribute("index");
				%>
					<b>${avisRestants.get(index).author} </b>
					<br> 
					<cite title="Source Title">${avisRestants.get(index).quote}</cite>
				</blockquote>
			</div>
		</div>

		<div class="pull-right" style="margin: 10px">
			<form action="valider-avis" method="POST">
				<input name="id" value="${avisRestants.get(index).id}">
				<button style="display: inline-block;" class="btn btn-success"
					type="submit">Valider</button>
			</form>
		</div>

		<div class="pull-left" style="margin: 10px">
			<form action="refuser-avis" method="POST">
				<input type="text" name="id" value="${avisRestants.get(index).id}" hidden="true">
				<button style="display: inline-block;" class="btn btn-danger"
					type="submit">Refuser</button>
			</form>
		</div>

	</div>
</div>

<script>
// 			function passNbNext(elem) {
// 				var index = parseInt(document.getElementById("index").value);
// 				document.getElementById("index").value = index + 1;
// 				console.log(document.getElementById("index").value);
// 				console.log(document.getElementById("index"));
// 			}
// 			function passNbPrev(elem) {
// 				var index = parseInt(document.getElementById("index").value);
// 				document.getElementById("index").value = index - 1;
// 				console.log(document.getElementById("index").value);
// 			}
		</script>

<tag:end />