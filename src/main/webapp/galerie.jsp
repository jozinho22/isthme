<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
		
		<tag:begin />
		<tag:navbar />
		
		<div id="section" class="carousel slide" data-ride="carousel">
		
			<ul id="carousel-inner-1" class="carousel-indicators">
				<li data-target="#section" data-slide-to="0" class="active"></li>
				<li data-target="#section" data-slide-to="1"></li>
<!-- 				<li data-target="#section" data-slide-to="2"></li> -->
<!-- 				<li data-target="#section" data-slide-to="3"></li> -->
<!-- 				<li data-target="#section" data-slide-to="4"></li> -->
<!-- 				<li data-target="#section" data-slide-to="5"></li> -->
			</ul>
			
			<div id="carousel-inner-1" class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/hamac5.jpg" class="responsive">
					<div class="carousel-caption">
						<p>Hamacs une place</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="img/mer1.jpg" class="responsive">
					<div class="carousel-caption">
						<p>Hamacs 2 places</p>
					</div>
				</div>
			</div>
			
			<div id="carousel-inner-2" class="carousel-inner">
				<img src="img/hamac5.jpg" class="responsive">
				<p><b>Hamacs une place</b></p>
				<hr>
				<img src="img/mer1.jpg" class="responsive">
				<p>Hamacs 2 places</p>	
			</div>
			
			<a id="carousel-inner-1" class="carousel-control-prev" href="#section" data-slide="prev"> <span
				class="carousel-control-prev-icon"></span>
			</a> 
			<a id="carousel-inner-1" class="carousel-control-next" href="#section" data-slide="next"> <span
				class="carousel-control-next-icon"></span>
			</a>
		</div>
		
		<tag:footer />
		<tag:end />