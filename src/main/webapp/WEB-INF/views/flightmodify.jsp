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

	<h1>FLIGHT MODIFY</h1>

	<form action="flight.html" method="post">
		<label> FLIGHT ID:</label> <input type="text" name="flightid" /> <br>
		</br> <label for="flightname">Choose a Flight:</label> <select
			name="flightname" id="flightname">
			<option value="IndiGo">IndiGo</option>
			<option value="Air India">Air India</option>
			<option value="SpiceJet">SpiceJet</option>
			<option value="GoAir">GoAir</option>
			<option value="AirAsia India">AirAsia India</option>
		</select> <br> </br> <label> Seating Capacity</label> <input type="text"
			name="seatingcapacity" /> <br> </br> <label>Reservation
			Capacity</label> <input type="text" name="reservationcapacity" /> <br> </br>
		<input type="submit" value="MODIFY" /> <br>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<td>FLIHT ID</td>
					<td>FLIGHT NAME</td>
					<td>SEATING CAPACITY</td>
					<td>RESERVATION CAPACITY</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="f" items="${FLIGHT_LIST}">
					<tr>
						<td>${f.flightid}</td>
						<td>${f.flightname}</td>
						<td>${f.seatingcapacity}</td>
						<td>${f.reservationcapacity}</td>
						<td><a href="<c:url value='flightmodify-${f}' />">Modify</a></td>

					</tr>


				</c:forEach>

			</tbody>


		</table>


	</form>

</body>
</html>