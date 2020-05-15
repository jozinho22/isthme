<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tag:begin />
<%@ include file="/WEB-INF/tags/gestion-navbar.jsp"%>
		
		<div id="section">
			<div id="quote" class="col-lg-10 col-xl-8 mx-auto" style="text-align : center;">
				<div class="carousel-inner px-5 pb-4">
					<div class="carousel-item active">
						<blockquote class="blockquote border-0 p-0">
							<b >${avis.author}</b>
							<br>
							<cite title="Source Title">${avis.quote}</cite>
						</blockquote>
					</div>
		
					<form id="prev-avis" action="previous-avis" method="POST">
						<input id="index" type="text" name="index" value="${index}"
							hidden="true">
						<%
							Integer indexPrev = (Integer) session.getAttribute("index");
							if(indexPrev.intValue() > 0 && avisRestants.intValue() != 1) {
								out.print(TagBuilder.buildPrev());
							}
						%>
					</form>
		
					<form action="next-avis" method="POST">
						<input id="index" type="text" name="index" value="${index}"
							hidden="true">
						<%
							Integer indexNext = (Integer) session.getAttribute("index");
							if(indexNext.intValue() != avisRestants.intValue() - 1 && avisRestants.intValue() != 1) {
								out.print(TagBuilder.buildNext());
							}
						%>
		
					</form>
				</div>
		
				<div class="pull-right" style="margin: 10px">
					<form action="valider-avis" method="POST">
						<input type="text" name="id" value="${avis.id}" hidden="true">
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