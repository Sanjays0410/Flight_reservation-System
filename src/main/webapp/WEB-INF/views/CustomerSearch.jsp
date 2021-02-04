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
        color: black;
        background-color: darkorange;
    }
    
      img {
  border-radius: 50%;
}

.butt {
	background-color: maroon;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>

<marquee behavior="scroll" direction="left">FLIGHT RESERVTION
		SYSTEM </marquee>
	<hr>
	<h5 align="center">
		<font color="#001133" size="60"> <img
			src="resources\img\logo.jpg" width="150" height="150">Flight
			Reservation System
		</font>
	</h5>


	<div align="left">
		<%
		String msg =(String)session.getAttribute("MESSAGE");
	

		if (msg != null) {
	%>

	<h1>
		<%=msg%></h1>
	<%
		}
	%>

	</div>

	<div align="Right">
		<h1>
			<a href="index.jsp"><input type="submit" class="butt"
				value="Logout"> </a>
		</h1>

		<hr>
	</div>
	<div align="center">


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
				 </label> <select name="Availabledays"
				id="Availabledays" required >
				<option></option>
				<option value="Monday">Monday</option>
				<option value="Tuesday">Tuesday</option>
				<option value="Wednesday">Wednesday</option>
				<option value="Thursday">Thursday</option>
				<option value="Friday">Friday</option>
				<option value="Saturday">Saturday</option>
				<option value="Sunday">Sunday</option>
				
				</select> <br> <br> <label for="Seats">Choose no of seats:
				 </label> <select name="Seats"
				id="Seats" required >
				<option></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				
			</select> <br> <br> <input type="submit" value="SEARCH" />


		</form>
		<%String msg3=(String)request.getAttribute("MESSAGE");
	
	if(msg3!=null){%>


	<h1>
			<%=msg3%></h1>
			
			
			<marquee behavior="scroll" direction="left">To view flight name and seats available click on flightid..........To view the Fare chick on Routeid...  </marquee>
			<br>
			<br>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<th> FLIGHT ID</th>
					<th>ROUTE ID</th>
					<th>TRAVEL DURATION{IN HRS}</th>
					<th>AVAILABLE DAYS</th>
					<th>DEPARTURE TIME</th>
					<th> BOOK TICKET</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="f" items="${FLIGHT_LIST}">
					<tr> 
						<td> <a href="Viewflightbyid?flightid=${f.flightid}">${f.flightid}</a></td>
						<td><a href="ViewRoutebyid?routeid=${f.routeid}">${f.routeid}</a></td>
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

<br>
<br>
<br>
<br>
<br>
<br>
<br>


	</div>

</body>
</html>