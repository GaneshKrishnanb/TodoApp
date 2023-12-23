<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<body>
			<div>
			<h1> Your TODO'S for ${name} </h1>
			<table class ="table">
				<thead>
					<tr>
						<th> ID </th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th> </th>
						<th> </th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${todo}" var ="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>	
						<td>${todo.done}</td>
						<td><a href ="delete-todo?id=${todo.id}" class="btn btn-danger"> Delete </a> </td>
						<td><a href ="update-todo?id=${todo.id}" class="btn btn-success"> Update </a> </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href ="add-to-do" class ="btn btn-success"> Add-to-do</a>
			</div>
			<%@ include file="common/footer.jspf" %>			