<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tag:begin />
<%@ include file="/WEB-INF/tags/gestion-navbar.jsp" %>
		
		<div id="section">
		
			<div id="client-table">
				<h3>Commandes du client </h3>
				<h3><b>${client.nom} </b></h3>
				
				<table class="table table-striped">
					<thead class="thead-custom">
						<tr>
							<th scope="col">#</th>
							<th scope="col">MONTANT</th>
							<th scope="col">DATE</th>
						</tr>
					</thead>
					<tbody class="tbody-custom">
						<c:forEach items="${commandes}" var="commande">
							<tr>
								<th scope="col">${commande.id}</th>
								<th scope="col">${commande.montant}</th>
								<th scope="col">${client.createdAt}</th>					
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<tag:end />