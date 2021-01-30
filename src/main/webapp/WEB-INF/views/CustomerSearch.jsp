<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1>CUSTOMER PAGE</h1>

<form action="Customersearch.html" method="post">
<label>Choose a Source:</label> <select
				name="Source" id="Source" required>
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> <label>Choose a Destination:</label> <select
				name="Destination" id="Destination" required>
				<option> </option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> 
			<label for="Days">Choose Days: {to choose multiple days use ctrl} </label> 
			<select
				name="Days" id="Days" required multiple>
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
			<input type="submit" value="SEARCH"/>



</form>



	<%String msg=(String)request.getAttribute("MESSAGE");
	
	if(msg!=null){%>

		<h1>
			<%=msg %></h1>
		<%} %>
		




</div>

</body>
</html>