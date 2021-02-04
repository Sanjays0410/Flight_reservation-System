<%@page import="org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap"%>
<%@page import="org.springframework.web.servlet.mvc.support.RedirectAttributes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.springframework.ui.Model"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<h1>SCHEDULE DETAILS</h1>

		<form action="Scheduleadd.html" method="post">
			<label>Schedule id:</label> <input type="text" name="scheduleid" required>
			<br> <br> <label>Flight id:</label> <input type="text"
				name="flightid" required /> <br> <br> <label>Route id:</label> <input
				type="text" name="routeid" required /> <br> <br> <label>Travel
				Duration:{specifie in Hours}</label> <input type="number" name="travelduration"  placeholder="only numberic values are allowed" required  /> <br> <br>
			<label for="availabledays">Choose Days: {to choose multiple days use ctrl} </label> 
			<select
				name="availabledays" id="availabledays" required multiple>
				<option>  </option>
				<option value="Monday">Monday</option>
				<option value="Tuesday">Tuesday</option>
				<option value="Wednesday">Wednesday</option>
				<option value="Thursday">Thursday</option>
				<option value="Friday">Friday</option>
				<option value="Saturday">Saturday</option>
				<option value="Sunday">Sunday</option>
			</select>
			<br>
			<br>
			<label> Departure time:{specifie AM or PM}</label>
			<input type="text" name="departuretime" required />
			<br>
			<br>
			<input type="submit" value="ADD"/>
			

		</form>



	<%String msg=(String)request.getAttribute("MESSAGE");if(msg!=null){ %>
	
	<h1> <%=msg %></h1>
	<%} %>


<br>
<br>

<input action="action" type="button" value="BACK" onclick="history.go(-1);" />

	</div>

</body>
</html>