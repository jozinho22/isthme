<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tag:begin />
<%@ include file="/WEB-INF/tags/gestion-navbar.jsp" %>
		
		<div id="section">
		
			<h3>Clients</h3>
			<div id="client-table">
		
		
				<table class="table table-striped">
					<thead class="thead-custom">
						<tr>
							<th scope="col">#</th>
							<th scope="col">NOM</th>
							<th scope="col">PRENOM</th>
							<th scope="col">EMAIL</th>
							<th scope="col">TEL</th>
							<th scope="col">COMMANDES</th>
						</tr>
					</thead>
					<tbody class="tbody-custom">
						<c:forEach items="${clients}" var="client">
							<tr>
								<th scope="col">${client.id}</th>
								<th scope="col">${client.nom}</th>
								<th scope="col">${client.prenom}</th>
								<th scope="col">${client.email}</th>
								<th scope="col">${client.tel}</th>
								<th>
									<form action="gestion-commandes" method="GET">
										<input type="text" name="id" value="${client.id}" hidden="true">
										<button class="btn btn-warning" type="submit">Commandes</button>
									</form> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<tag:end />