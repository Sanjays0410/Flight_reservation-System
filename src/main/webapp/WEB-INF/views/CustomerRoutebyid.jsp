<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>
body {
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

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: green;
	color: white;
}

marquee
{
background-color:orange;
}
</style>

<div align="center">


<h1> ROUTR ON ID</h1>


<marquee behavior="scroll" direction="left">FLIGHT RESERVATION SYSTEM  </marquee>
			<br>
			<br>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<th>ROUTE ID</th>
					<th>SOURCE</th>
					<th>DESTINATION</th>
					<th>DISTANCE{IN HRS}</th>
					<th>FARE PER SEAT</th>
					

				</tr>
			</thead>
			<tbody>

			
					<tr> 
						
						<td>${ROUTE_ID}</td>
						<td>${SOURCE}</td>
						<td>${DESTINATION}</td>
						<td>${DISTANCE}</td>
						<td>${FARE}</td>
					</tr>

			

			</tbody>


		</table>


<br>
<br>


<input action="action" type="button" value="BACK" onclick="history.go(-1);" />












</div>
</body>
</html>