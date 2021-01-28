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








<h1> FLIGHT LIST</h1>

	<table border="1" bordercolor="blue">

		<thead>
			<tr>
				<th>FLIHT ID</th>
				<th>FLIGHT NAME</th>
				<th>SEATING CAPACITY</th>
				<th>RESERVATION CAPACITY</th>
				<th>--ACTION DELETE--</th>
				<th>--ACTION MODIFY--</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="f" items="${FLIGHT_LIST}">
				<tr>
					<td>${f.flightid}</td>
					<td>${f.flightname}</td>
					<td>${f.seatingcapacity}</td>
					<td>${f.reservationcapacity}</td>
					<td> <a href="flightdelete?flightid=${f.flightid}&flightname=${f.flightname}&seatingcapacity=${f.seatingcapacity}&reservationcapacity=${f.reservationcapacity}"
							>DELETE </a></td>
					<td> <a href="flightmodify?flightid=${f.flightid}&flightname=${f.flightname}&seatingcapacity=${f.seatingcapacity}&reservationcapacity=${f.reservationcapacity}"
							>MODIFY </a></td>
					
	

				</tr>


			</c:forEach>

		</tbody>


	</table>
	
	
	<%
		String msg =(String)request.getAttribute("MESSAGE");
	

		if (msg != null) {
	%>

	<h1>
		<%=msg%></h1>
	<%
		}
	%>
	
	<br>
	<br>
	
	<a href="index.jsp"> <input type="submit" value="BACK"/></a>
</div>
</body>
</html>