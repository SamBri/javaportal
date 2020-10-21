<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logger</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>



	<!-- group radio buttons in a container  !-->

	<div style="positon: relative;">
		<div class="container px-lg-5"
			style="position: absolute; top: 45%; left: 50%; transform: translate(-50%, -45%);">

			<div>
				<p style="text-align: center;">Select Use Case:</p>
			</div>

			<!-- split into two views -->
			<div class="row">
				<!-- ScopeWrapper: Left -->
				<div class="col py-3 px-lg-5 border bg-light " id="scopeWrapper">
					<form action="<%=request.getContextPath() + "/ScopedObj"%>"
						method="get" id="form-1">
						<div>
							<input type="radio" id="useCase2" name="Scope" value="request" checked>
							<label for="useCase2">Request Scope </label>
						</div>
						<div>
							<input type="radio" id="useCase1" name="Scope" value="session"
								> <label for="useCase1">Session Scope </label>
						</div>

						<div>
							<input type="radio" id="useCase3" name="Scope"
								value="application"> <label for="useCase3">Application
								Scope </label>
						</div>


					</form>
				</div>



				<!-- OptionsWrapper: Right -->
				<div class="col py-3 px-lg-5 border bg-light" id="optionsWrapper">
					<label for="route">Choose a route mechanism:</label> <select
						name="Select" id="nuts-bots" form="form-1" required>
						<option value="">--Please choose an option--</option>
						<option value="forwards">Forwards</option>
						<option value="redirect">Redirect</option>
					</select>

				</div>





			</div>

			<!-- Submit input type   -->

			<div
				style="position: absolute; bottom: -6rem; left: 50%; transform: translate(-50%, -45%);">
				<input form="form-1" type="submit" class="btn btn-success"
					value="Check!">
			</div>




		</div>

	</div>


	<%-- 	<a href="<%=request.getContextPath() + "/ScopedObj" + "?action=request"%>">Incident</a> --%>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>


</body>
</html>

