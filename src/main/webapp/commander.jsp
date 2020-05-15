<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
		
		<tag:begin />
		<tag:navbar />
		
		<div id="section">
			<div class="card shopping-cart">
		
				<div class="card-header">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i> Commander
					<div class="clearfix"></div>
				</div>
		
				<div class="card-body">
					<!-- PRODUCT 1 -->
					<div class="row">
						<div id="image-product" class="col-12 col-sm-4 col-md-4 text-center">
							<img src="img/hamac1.jpg">
						</div>
						<div class="col-12 text-sm-center col-sm-4 text-md-left col-md-4">
							<div class="desc">
								<h4 class="product-name">Hamac 1 place</h4>
								<h4>
									<small>40 balles</small>
								</h4>
							</div>
						</div>
						<div class="col-12 col-sm-4 text-sm-center col-md-3">
							<input type="text" disabled="disabled" value="40" hidden="true">
							<div class="quantity">
								<input onclick="addValue(this);" type="button" value="+"
									class="plus"> <input type="text" disabled="disabled"
									class="qty" size="4" value="0"> <input
									onclick="subValue(this);" type="button" value="-" class="minus">
							</div>
						</div>
					</div>
					<!-- END PRODUCT 1 -->
		
					<hr>
					<!-- PRODUCT 1 -->
					<div class="row">
						<div id="image-product" class="col-12 col-sm-4 col-md-4 text-center">
							<img src="img/hamac2.jpg" width="120" height="80">
						</div>
						<div class="col-12 text-sm-center col-sm-4 text-md-left col-md-4">
							<div class="desc">
								<h4 class="product-name">Hamac 2 places</h4>
								<h4>
									<small>60 balles</small>
								</h4>
							</div>
						</div>
						<div class="col-12 col-sm-4 text-sm-center col-md-3">
							<input type="text" disabled="disabled" value="60" hidden="true">
							<div class="quantity">
								<input onclick="addValue(this);" type="button" value="+"
									class="plus"> <input type="text" disabled="disabled"
									class="qty" size="4" value="0"> <input
									onclick="subValue(this);" type="button" value="-" class="minus">
							</div>
						</div>
					</div>
					<!-- END PRODUCT 1 -->
					<hr>
					<h5>
						Total (frais de port inclus) : <span id="total-ext">0</span> euros
					</h5>
				</div>
		
				<div class="card-footer">
					<input id="total" type="text" class="qty" hidden="true" size="4"
						value="0" style="padding: 10px; font-size: 16px;">

					<div class="pull-left btn-photos" style="margin: 10px">
						<a href="galerie" class="btn btn-warning">Voir plus de
							photos</a>
					</div>
					<div class="pull-right" style="margin: 10px">
						<a id="custom-btn" onclick="displayTotal();"
							data-target="#centered-modal" data-container="body"
							data-toggle="modal" data-placement="top" class="btn btn-success">Commander</a>
					</div>
				</div>
		
			</div>
			<tag:bottom-space />
			<tag:footer />
		</div>
		
		<div class="modal fade" id="centered-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
		
					<div class="modal-header">
						<h5 class="modal-title">Votre paiement de :</h5>
						<h5 class="modal-title" id="total-paypal"></h5>
						<h5 class="modal-title">€</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
		
					<div class="modal-body">
						<form action="inscription" method="POST">
							<input name="montant" id="total-to-send" value="0" hidden="true">
							<div class="row">
								<div class="col-12 col-sm-6 col-md-6 text-center">
									<label for="message-text" class="col-form-label">Votre nom</label> 
									<input name="nom" class="form-control" placeholder="Gicqueau">
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-6 col-md-6 text-center">
									<label for="message-text" class="col-form-label">Votre prénom</label> 
									<input name="prenom" type="text" class="form-control" placeholder="Teddy">
								</div>
							</div>
							<label for="message-text" class="col-form-label">Votre email</label> 
							<input name ="email" class="form-control"
								placeholder="name@example.com" value="moi@gmail.com"> 
							<label for="message-text" class="col-form-label">Numéro de téléphone</label> 
							<input name="tel" type="tel" class="form-control" placeholder="0612345678">
							<div class="form-group">
								<label for="message-text" class="col-form-label">Adresse de livraison:</label>
								<textarea name="adresse" class="form-control" id="message-text"></textarea>
							</div>
							<div class="modal-footer">
								<button onclick="sendMontant();" type="submit" class="btn btn-primary">Paypal</button>
							</div>
						</form>
					</div>
					
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$('#centered-modal').on('show.bs.modal', function(event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				var modal = $(this)
				// 	  modal.find('.modal-title').text('New message to ' + recipient)
				modal.find('.modal-body input').val(recipient)
			})
		
			function updatePrice(elem, operator) {
				var bigParent = elem.parentElement.parentElement;
				var children = bigParent.children;
				var price = parseInt(children[0].value);
		
				var oldTotal = parseInt(document.getElementById("total").value);
		
				var newTotal;
				if (operator == "+")
					newTotal = oldTotal + price;
				else if (operator == "-")
					newTotal = oldTotal - price;
				document.getElementById("total").value = newTotal;
				document.getElementById("total-ext").innerHTML = newTotal;
			}
		
			function addValue(elem) {
				var qty = parseInt(elem.nextElementSibling.value);
		
				var newQuant;
				if (qty < 10) {
					newQuant = qty + 1;
					updatePrice(elem, "+");
				} else
					newQuant = qty;
		
				elem.nextElementSibling.value = newQuant;
			}
		
			function subValue(elem) {
				var qty = elem.previousElementSibling.value;
		
				var newQuant;
				if (qty > 0) {
					newQuant = qty - 1;
					updatePrice(elem, "-");
				} else
					newQuant = qty;
		
				elem.previousElementSibling.value = newQuant;
			}
			function displayTotal() {
				var total = document.getElementById("total").value;
				document.getElementById("total-paypal").innerHTML = total;
				console.log(total);
			}
			function sendMontant() {
				var total = document.getElementById("total").value;
				console.log(document.getElementById("total-to-send"));
		// 		var totalStr = total.toString();
				document.getElementById("total-to-send").value = total;
				console.log(document.getElementById("total-to-send").value);
				console.log(document.getElementById("total-to-send"));
			}
		</script>
		
<%-- 		<tag:footer /> --%>
		<tag:end />