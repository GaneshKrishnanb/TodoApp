<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<body>
			<div class = "container">
			<h1> Add Your TODO'S here</h1>
            <form:form method = "post" modelAttribute="todo">
            <form:input type ="hidden" id = "id" path ="id"/>
            <form:input type ="hidden" id = "done" path ="done"/>
            <fieldset class = "mb-3">
	            <form:label path="description">Description</form:label>
	            <form:input type ="text" path ="description" id  = "description" required = "required"/>
	            <form:errors path="description" cssClass="text-danger" />
            </fieldset>  
            
             <fieldset class = "mb-3">
	            <form:label path="targetDate">Target Date</form:label>
	            <form:input type ="text" path ="targetDate" id  = "targetDate" required = "required"/>
	            <form:errors path="targetDate" cssClass="text-danger" />
            </fieldset>              
            <input type ="submit" class="btn btn-success"/>
            </form:form>          
            </div>
            <%@ include file="common/footer.jspf" %>
			<script type = "text/javascript">
			$('#targetDate').datepicker({
			    format: 'yyyy-mm-dd'
			});
			</script>				