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
		<h1>CUSTOMER PAGE</h1>



		<form action="Customersearch.html" method="post">
			<label>Choose a Source:</label> <select name="Source" id="Source"
				required>
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
			</select> <br> <br> <label for="Availabledays">Choose Days:
				{to choose multiple days use ctrl} </label> <select name="Availabledays"
				id="Availabledays" required >
				<option></option>
				<option value="Monday">Monday</option>
				<option value="Tuesday">Tuesday</option>
				<option value="Wednesday">Wednesday</option>
				<option value="Thursday">Thursday</option>
				<option value="Friday">Friday</option>
				<option value="Saturday">Saturday</option>
				<option value="Sunday">Sunday</option>
			</select> <br> <br> <input type="submit" value="SEARCH" />


		</form>
		<%String msg=(String)request.getAttribute("MESSAGE");
	
	if(msg!=null){%>


	<h1>
			<%=msg %></h1>
			
			<marquee behavior="scroll" direction="left">To view flight name and seats available click on flightid..........To view the Fare chick on Routeid...  </marquee>
			<br>
			<br>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<th> FLIGHT ID</th>
					<th>ROUTE ID</th>
					<th>TRAVEL DURATION</th>
					<th>AVAILABLE DAYS</th>
					<th>DEPARTURE TIME</th>
					<th> BOOK TICKET</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="f" items="${FLIGHT_LIST}">
					<tr> 
						<td> <a href="Viewflightonid?flightid=${f.flightid}">${f.flightid}</a></td>
						<td><a href="ViewRouteonid?routeid=${f.routeid}">${f.routeid}</a></td>
						<td>${f.travelduration}</td>
						<td>${f.availabledays}</td>
						<td>${f.departuretime}</td>
						<td> <a href="">BOOK</a></td>
					</tr>

				</c:forEach>

			</tbody>


		</table>

		
		<%} %>
		
		<%String msg1=(String)request.getAttribute("NO_FLIGHT");
	
	if(msg1!=null){%>

		<h1>
			<%=msg1 %></h1>
		<%} %>
		


		<%String msg2=(String)request.getAttribute("CHECK");
	
	if(msg2!=null){%>

		<h1>
			<%=msg2 %></h1>
		<%} %>



	</div>

</body>
</html>