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

marquee
{
background-color:orange;
}

</style>





	<div align="center">
		<h1>SCHEDULE DATA DELETE</h1>
		
		<br>
	<br>
	
	<marquee behavior="scroll" direction="left">DO U WANT TO DELETE SCHEDULE... ONCE DELETE CAN BE GET!  </marquee>
	<br>
	<br>

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
				</tr>
			</thead>
			<tbody>


				<tr>

					<td>
						<%
							String scheduleid = (String) session.getAttribute("Scheduleid");
							if (scheduleid != null) {
						%>

						<%=scheduleid%> <%
 	}
 %>

					</td>
					<td>
						<%
							String flightid = (String) session.getAttribute("Flightid");
							if (flightid != null) {
						%>

						<%=flightid%> <%
 	}
 %>
					</td>
					<td>
						<%
							String routeid = (String) session.getAttribute("Routeid");
							if (routeid != null) {
						%>

						<%=routeid%> <%
 	}
 %>
					</td>



					<td>
						<%
							String availabledays = (String) String.valueOf(session.getAttribute("Availabledays"));
							if (availabledays != null) {
						%>

						<%=availabledays%> <%
 	}
 %>
					</td>
					<td>
						<%
							String travelduration = (String) String.valueOf(session.getAttribute("Travelduration"));
							if (travelduration != null) {
						%>

						<%=String.valueOf(travelduration)%> <%
 	}
 %>

					</td>
					<td>
						<%
							String departuretime = (String) String.valueOf(session.getAttribute("Departuretime"));
							if (departuretime != null) {
						%>

						<%=String.valueOf(departuretime)%> <%
 	}
 %>

					</td>
					<td><a
						href="scheduledelete?<%=session.getAttribute("Sucheduleid")%>">
							<input type="submit" value="Delete">
					</a></td>
				</tr>

			</tbody>


			<!-- </table>
	<form action="flightdel" method="post">
		<input type="submit" value="delete" />
		
	</form> -->


			<%
				String msg = (String) request.getAttribute("MESSAGE");

				if (msg != null) {
			%>

			<h1>
				<%=msg%></h1>
			<%
				}
			%>
		</table>
		<br> <br> <a href="index.jsp"> <input type="submit"
			value="BACK" /></a>




</div>

</body>
</html>