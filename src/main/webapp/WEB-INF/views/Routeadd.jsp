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
		<h1>ROUTE DETAILS</h1>

		<form action="Routeadd" method="post">
			<label>Rouite id :</label> <input type="text" name="routeid" required />
			<br> <br> <label>Choose a Source:</label> <select
				name="source" id="source" required>
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> <label>Choose a Destination:</label> <select
				name="destination" id="destination" required>
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> <label> Distance:</label> <input type="number"
				name="distance"  placeholder="only numberic values are allowed" required /> <br> <br> <label>ENTER
				FARE :</label> <input type="text" name="fare" placeholder="only numberic values are allowed" required /> <br>
			<br> <input type="submit" value="ADD" />

		</form>

		<%String msg=(String)request.getAttribute("MESSAGE");
	
	if(msg!=null){%>

		<h1>
			<%=msg %></h1>
		<%} %>
		
<br>
<br>

<input action="action" type="button" value="BACK" onclick="history.go(-1);" />
	</div>
</body>
</html>