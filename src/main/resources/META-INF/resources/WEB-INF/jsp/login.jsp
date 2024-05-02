
<%@ include file="common/header.jspf"%>
<body>
	<div class="container">
		<h1>Login</h1>
		<small>${errorMsg}</small> <small>${msg1} ${count} ${msg2}</small>
		<form method="post" class="mt-10 row"
			style="display: flex; justify-content: center; align-items: center;">
			<div class="mb-3 row">
				<div class="col-sm-10">
					Name: <input type="text" name="name" required="required">
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-10">
					Password: <input type="password" name="password" required="required">
				</div>
			</div>
			<div class="mb-3 row" class="col-sm-10">
				<div class="col-sm-10">
					<input type="submit" name="submit">
				</div>
			</div>
		</form>
	</div>
		<%@ include file="common/footer.jspf"%>
</body>
</html>
