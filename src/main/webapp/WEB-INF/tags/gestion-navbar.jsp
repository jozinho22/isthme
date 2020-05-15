<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.douineau.utils.TagBuilder"%>


<% 
	boolean ok = false ;
	String login = (String) session.getAttribute("session-login");
	if(login != null) {
		ok = true;
	} else {
		response.sendRedirect("error");
	}
	
	Long avisRestants = (Long) session.getAttribute("avisRestants");
%>

<nav id="navbar" class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a href="gestion"> 
		<img src="img/logo_isthme_blanc_nav.png"
			class="logo-navbar">
		</a>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="recherche-clients">Recherche client</a>
			</li>
			<%
				if(avisRestants.intValue() > 0 ) {
					out.print(TagBuilder.buildGererLesPosts(String.valueOf(avisRestants)));
				}
			%>
		</ul>
	</div>
	<div class="pull-right">
		<a href="deconnexion" >
			<i id="deconnexion" class="fa fa-undo" style="font-size: 36px"></i>
		</a>
	</div>
</nav>