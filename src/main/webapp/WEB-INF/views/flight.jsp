  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>

body
{
 background-color: lightgrey;
}
</style>

<div align="center">

	<h1>FLIGHT PAGE</h1>

	<form action="flight.html" method="post">
		<label> FLIGHT ID:</label> <input type="text" name="flightid" required/> <br>
		</br> <label for="flightname">Choose a Flight:</label> <select
			name="flightname" id="flightname" required>
			<option> </option>
			<option value="IndiGo">IndiGo</option>
			<option value="Air India">Air India</option>
			<option value="SpiceJet">SpiceJet</option>
			<option value="GoAir">GoAir</option>
			<option value="AirAsia India">AirAsia India</option>
		</select> <br> </br> <label> Seating Capacity</label> <input type="number"
			name="seatingcapacity" placeholder="only numberic are aloow" required /> <br> </br> <label>Reservation
			Capacity</label> <input type="number" name="reservationcapacity" placeholder="only numberic are allow" required /> <br> </br>
		<input type="submit" value="ADD" />
		
		
	</form>
	<br>
	<br>
	
	<a href="index.jsp"> <input type="submit" value="BACK"/></a>
	
	<%String msg=(String)request.getAttribute("MESSAGE");
	
	if(msg!=null){%>
	
	<h1> <%=msg %></h1>
	<%} %>

</div>
</body>
</html>