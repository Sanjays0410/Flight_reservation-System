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

<table border="1" bordercolor="blue">

<thead>
		<tr>
			<td>FLIHT ID</td>
			<td>FLIGHT NAME</td>
			<td> SEATING CAPACITY</td>
			<td> R	ESERVATION CAPACITY</td>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach var="f" items="${FLIGHT_LIST}">
	<tr>
	<td> ${f.flightid} </td>
	<td> ${f.flightname}</td>
	<td>${f.seatingcapacity}</td>
	<td>${f.reservationcapacity}</td>
		<td> <a href="<c:url value='flightdelete-${f.flightid}' />">Delete</a></td>
	
	</tr>
	
	
	</c:forEach>

	</tbody>


</table>

</body>
</html>