<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

		<h1>SCHEDULE DATA MODIFY </h1>

		<form action="schedulemodify" method="post">
			<label>Schedule id:</label> <input type="text" name="scheduleid"
				value="<%=session.getAttribute("Scheduleid")%>" required readonly>
			<br> <br> <label>Flight id:</label> <input type="text"
				name="Flightid" value="<%=session.getAttribute("Flightid")%>"
				required /> <br> <br> <label>Route id:</label> <input
				type="text" name="Routeid"
				value="<%=session.getAttribute("Routeid")%>" required /> <br>
			<br> <label>Travel Duration:</label> <input type="number"
				name="Travelduration"
				value="<%=session.getAttribute("Travelduration")%>"
				placeholder="only numberic values are allowed" required /> <br>
			<br> <label for="Availabledays">Choose Days: {to choose
				multiple days use ctrl} </label> <select name="Availabledays"
				value="<%=session.getAttribute("Availabledays")%>"
				id="Availabledays" required  multiple>
				<option><%=session.getAttribute("Availabledays")%>  </option>
				<option></option>
				<option></option>
				<option></option>
				<option value="Monday">Monday</option>
				<option value="Tuesday">Tuesday</option>
				<option value="Wednesday">Wednesday</option>
				<option value="Thursday">Thursday</option>
				<option value="Friday">Friday</option>
				<option value="Saturday">Saturday</option>
				<option value="Sunday">Sunday</option>
			</select> <br> <br> <label> Departure time:</label> <input
				type="text" name="Departuretime"
				value="<%=session.getAttribute("Departuretime")%>" required /> <br>
			<br> <input type="submit" value="MODIFY" />


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
		<a href="index.jsp"> <input type="submit" value="BACK"/></a>


	</div>






</body>
</html>