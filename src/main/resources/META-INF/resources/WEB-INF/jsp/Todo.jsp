
<%@ include file="common/header.jspf"%>

<body>
	<%@ include file="common/navigation.jspf"%>

	<h1 style="display: flex; justify-content: center;">Enter Todo
		Details</h1>
	<div class="container col align-self-center"
		style="display: flex; justify-content: center; align-items: center">
		<form:form method="Post" class="mt-10 row" modelAttribute="todo">
			<div class="row">
				
						<form:input type="hidden" path="id" class="form-control"/>
						<form:input type="hidden" path="username" class="form-control" />

				<fieldset class="mb-3 row">
					<div class="col-sm-10">
						<form:label path="Description" class="col-sm-2 col-form-label">Description</form:label>
						<form:input type="text" path="description" class="form-control" />
						<form:errors path="description" cssClass="text-warning" />
					</div>
				</fieldset>


				<div class="mb-3 row">
					<div class="col-sm-10">
						<form:label path="TargetDate" class="col-sm-4 col-form-label">Target Date</form:label>
						<form:input id="targetDate" path="targetDate" class="form-control" />
						<form:errors path="description" cssClass="text-warning" />
					</div>
				</div>

				<fieldset class="mb-3 row ">
					<div class="col-sm-10">
						<form:label path="done" class="col-sm-2 col-form-label">Done?</form:label>
						<form:select class="form-select"
							aria-label="Default select example" path="done" id="done">
							<option path="done">False</option>
							<option path="done">True</option>
						</form:select>
						<form:errors path="description" cssClass="text-warning" />
					</div>
				</fieldset>

				<div class="mb-3">
					<div class="col-sm-10 col align-self-end">
						<input type="submit" class="btn btn-success"
							style="display: flex; float: right">
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<%@ include file="common/footer.jspf"%>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd',
		});
	</script>
	</body>
</html>
