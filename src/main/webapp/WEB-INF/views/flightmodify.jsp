<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>FLIGHT DATA MODIFY</h1>

		<form action="flightmodify" method="post">

			<label> FLIGHT ID:</label> <input type="text"
				value="<%String flightid = (String) session.getAttribute("flightid");
			if (flightid != null) {%> <%=flightid%> <%}%>"
				name=flightid required readonly /> <br> </br> <label
				for="flightname">Choose a Flight:</label> <select
				value="<%String flightname = (String) session.getAttribute("flightname");
			if (flightname != null) {%> <%=flightname%>  <%}%>"
				name="flightname" id="flightname" required>
				<option> <%=session.getAttribute("flightname")%></option>
				<option value="IndiGo">IndiGo</option>
				<option value="Air India">Air India</option>
				<option value="SpiceJet">SpiceJet</option>
				<option value="GoAir">GoAir</option>
				<option value="AirAsia India">AirAsia India</option>
			</select> <br> </br> <label> Seating Capacity</label> <input type="text"
				value="<%=session.getAttribute("seatingcapacity")%>"
				name="seatingcapacity" required /> <br> </br> <label>Reservation
				Capacity</label> <input type="text"
				value="<%=session.getAttribute("reservationcapacity")%>"
				name="reservationcapacity" required /> <br> </br> <input
				type="submit" value="Modify" />

		</form>

		<%
			String msg = (String) request.getAttribute("MESSAGE");

			if (msg != null) {
		%>

		<h1>
			<%=msg%></h1>
		<%
			}
		%>
<br>
<br>
		<input action="action" type="button" value="BACK" onclick="history.go(-1);" />

	</div>

</body>
</html>