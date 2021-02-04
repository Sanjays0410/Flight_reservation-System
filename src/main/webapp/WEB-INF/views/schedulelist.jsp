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
<div align="center">

<h1> VIEW ALL SCHEDULE</h1>


<style>

body
{
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


tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: green;
  color: white;
}
</style>

		<table border="1" bordercolor="blue">

			<thead>
				<tr>
					<th>SCHEDULE ID</th>
					<th>FLIGHT ID</th>
					<th>ROUTE ID</th>
					<th>AVAILABLE DAYS</th>
					<th>TRAVEL DURATION</th>
					<th>DEPARTURE TIME</th>
					<th>--ACTION--DELETE</th>
					<th>--ACTION--MODIFY</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="s" items="${SCHEDULE_LIST}">
					<tr>
						<td>${s.scheduleid}</td>
						<td>${s.flightid}</td>
						<td>${s.routeid}</td>
						<td>${s.availabledays}</td>
						<td>${s.travelduration}</td>
						<td>${s.departuretime}</td>
						<td> <a href="Scheduledel?Scheduleid=${s.scheduleid}&Flightid=${s.flightid}&Routeid=${s.routeid}&AvailableDays=${s.availabledays}&Travelduration=${s.travelduration}&Departuretime=${s.departuretime}"
							>DELETE </a></td>
							<td> <a href="ScheduleModify?Scheduleid=${s.scheduleid}&Flightid=${s.flightid}&Routeid=${s.routeid}&AvailableDays=${s.availabledays}&Travelduration=${s.travelduration}&Departuretime=${s.departuretime}"
							>MODIFY </a></td>
							

					</tr>


				</c:forEach>

			</tbody>


		</table>


		<%
			String msg = (String) request.getAttribute("MESSAGE");

			if (msg != null) {
		%>

		<h1>
			<%=msg%></h1>
		<%
			}
		%>

		<br> <br> <input action="action" type="button" value="BACK" onclick="history.go(-1);" />













</div>

</body>
</html>