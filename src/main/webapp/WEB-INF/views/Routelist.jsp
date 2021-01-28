<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>LIST ALL ROUTE</h1>


<style>

body
{
 background-color: lightgrey;
}
table {
  border-collapse: collapse;
  width: 75%;
}

th, td {
  text-align: left;
  padding: 8px;
}


tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: green;
  color: white;
}
</style>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<th>ROUTE ID</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>DISTANCE</th>
					<th>FARE</th>
					<th>--ACTION--DELETE</th>
					<th>--ACTION--MODIFY</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="r" items="${ROUTE_LIST}">
					<tr>
						<td>${r.routeid}</td>
						<td>${r.source}</td>
						<td>${r.destination}</td>
						<td>${r.distance}</td>
						<td>${r.fare}</td>
						<td> <a href="Routedel?Routeid=${r.routeid}&Source=${r.source}&Destination=${r.destination}&Distance=${r.distance}&Fare=${r.fare}"
							>DELETE </a></td>
						<td> <a href="RouteModify?Routeid=${r.routeid}&Source=${r.source}&Destination=${r.destination}&Distance=${r.distance}&Fare=${r.fare}"
							>Modify </a></td>



					</tr>


				</c:forEach>

			</tbody>


		</table>


		<%
			String msg = (String) request.getAttribute("MESSAGE");

			if (msg != null) {
		%>

		<h1>
			<%=msg%></h1>
		<%
			}
		%>

		<br> <br> <a href="index.jsp"> <input type="submit"
			value="BACK" /></a>




	</div>

</body>
</html>