<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-12 col-sm-12 col-md-3 text-center"></div>
			<div class="col-12 col-sm-12 col-md-6 text-center">
				<div id="socials" class="container text-center">
					<a href="https://www.instagram.com/isthme.r/?hl=fr" target="_blank">
						<i class="fa fa-instagram" style="font-size: 36px"></i>
					</a> <a href="https://www.facebook.com/raymond.campincar"
						target="_blank"> <i class="fa fa-facebook"
						style="font-size: 36px"></i>
					</a> <a href="mailto:isthme.contact@gmail.com"> <i
						class="fa fa-envelope" style="font-size: 36px"></i>
					</a> <a href="https://api.whatsapp.com/send?phone=33188200022"
						target="_blank"> <i class="fa fa-whatsapp"
						style="font-size: 36px"></i>
					</a> <i class="fa fa-question"
						style="font-size: 36px" data-container="body"
						data-toggle="popover" data-placement="top"> </i>
				</div>
			</div>
			<div class="col-12 col-sm-12 col-md-3 text-center">
				<div class="container text-center">
					<a href="https://stackoverflow.com/users/6741310/jozinho22"
						target="_blank"> 
						<img id="img" style="opacity : 0.1"
						src="https://stackoverflow.com/users/flair/6741310.png?theme=dark"
						width="150" height="40" style="margin-top:15px">
					</a>
				</div>
			</div>
		</div>
	</div>

</footer>

<div id="popover-content" hidden="true" style="display: flex;">
	<h6 id="email" style="display: inline;">isthme.contact@gmail.com</h6>
	<h6 id="email" style="display: inline;">(site actuellement en construction)</h6>
</div>

<script>
	$(document).ready(function() {
		$("[data-toggle=popover]").popover({
			html : true,
			content : function() {
				return $('#popover-content').html();
			}
		});
	});

	function copyText() {
		console.log('dfds');
		var textToCopy = document.getElementById("email").textContent;
		copyStringToClipboard(textToCopy);
	}

	function copyStringToClipboard(str) {
		// Create new element
		var el = document.createElement('textarea');
		// Set value (string to be copied)
		el.value = str;
		// Set non-editable to avoid focus and move outside of view
		el.setAttribute('readonly', '');
		el.style = {
			position : 'absolute',
			left : '-9999px'
		};
		document.body.appendChild(el);
		// Select text inside element
		el.select();
		// Copy text to clipboard
		document.execCommand('copy');
		// Remove temporary element
		document.body.removeChild(el);
	}
	
	function displayImage() {
		var img = document.getElementById("img").style.display = 'block';
		
	}
</script>