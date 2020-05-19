<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.douineau.utils.TagBuilder"%>
		
		<tag:begin />
		<tag:navbar />
		
		<div id="section">
			<!-- Demo header-->
			<div class="py-5 text-center">
				<div class="container py-4 text-white">
					<header>
						<p class="font-italic mb-1">Voici les derniers avis.</p>
					</header>
				</div>
			</div>
		
			<section class="pb-5">
				<div class="container">
					<div class="row">
		
						<div id="quote" class="col-lg-12 col-xl-10 mx-auto">
							<!-- Bootstrap carousel-->
							<div class="carousel slide" id="carouselExampleIndicators"
								data-ride="carousel">

								<div class="carousel-inner px-5 pb-4">		
									<%
										int k = 0;
									%>
									<c:forEach items="${listAvis}" var="avis">
										<%
											out.print(TagBuilder.buildCarouselItem(k));
											k++;
										%>
												<div class="media-body ml-3">
													<blockquote class="blockquote border-0 p-0">
														<b>${avis.quote}</b>														
														<br>
														<cite title="Source Title">${avis.author}</cite>
													</blockquote>
												</div>
										<%
											out.print(TagBuilder.closeCarouselItem());
										%>	
									</c:forEach>
								</div>
		
								<!-- Bootstrap controls [dots]-->
								<!--                         <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> -->
								<!--                             <i class="fa fa-angle-left text-dark text-lg"></i> -->
								<!--                             <span class="sr-only">Previous</span> -->
								<!--                         </a> -->
								<!--                         <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> -->
								<!--                             <i class="fa fa-angle-right text-dark text-lg"></i> -->
								<!--                             <span class="sr-only">Next</span> -->
								<!--                         </a> -->
							</div>
						</div>
					</div>
				</div>
			</section>
			<a href="ecrire">
				<button id="btn-livre-dor-write" type="button" class="btn">Ecrire
					son propre ressenti</button>
			</a>
		</div>
		
		<script type="text/javascript">
		
		</script>
		
		<tag:footer />
		<tag:end />