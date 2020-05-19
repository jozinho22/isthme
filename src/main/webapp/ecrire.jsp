<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
		
		<tag:begin />
		<tag:navbar />
		
		<div id="section">
			<!-- Demo header-->
			<section class="py-5 text-center">
				<div class="container py-4 text-white">
					<header>
						<p class="font-italic mb-1">Create an elegant quote carousel
							using default Bootstrap 4 carousel component.</p>
						<p class="font-italic">
							Snippet by <a class="text-white" href="https://bootstrapious.com/">
								<u>Bootstrapious</u>
							</a>
						</p>
					</header>
				</div>
			</section>
			
			<form action="ecrire" method="POST">
				<div class="form-group">
					<input
						name="author" type="text" class="form-control"
						id="input-livre-dor" placeholder="Votre nom">
				</div>
		
				<div class="form-group">
					<textarea name="quote" class="form-control"
						id="textarea-livre-dor" rows="3" placeholder="Votre ressenti"></textarea>
				</div>
				
				<button type="submit" id="btn-livre-dor-write" type="button" class="btn">
					Soumettre son ressenti
				</button>	
			</form>
		</div>
		
		<tag:footer />
		<tag:end />