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
	
	<h1> FLIGHT DELETE</h1>
	<br>
	<br>
	
	<marquee behavior="scroll" direction="left">DO U WANT TO DELETE FLIGHT... ONCE DELETE CAN BE GET!  </marquee>
	<br>
	<br>
	
	<table border="1" bordercolor="blue">

		<thead>
			<tr>
				<th>FLIHT ID</th>
				<th>FLIGHT NAME</th>
				<th>SEATING CAPACITY</th>
				<th>RESERVATION CAPACITY</th>
				<th>--ACTION DELETE--</th>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><% String flightid=(String)session.getAttribute("flightid");if(flightid!=null){ %>
				
				<%=flightid %> <%} %>
				
				</td>
				<td><% String flightname=(String)session.getAttribute("flightname"); if(flightname!=null){%>
				
				<%=flightname %> <%} %>
				</td>
				<td><% String seatingcapacity=(String)  String.valueOf(session.getAttribute("seatingcapacity"));if(seatingcapacity!=null){%>
				
				<%=seatingcapacity %>  <%} %>
				</td>
				<td><% String reservationcapacity=(String)  String.valueOf(session.getAttribute("reservationcapacity"));%>
				
				<%=String.valueOf(reservationcapacity) %> 
				
				</td>
				<td> <a href="flightdel?<%=session.getAttribute("flightid") %>"
							> <input type="submit" value="Delete"> </a></td>
			</tr>

		</tbody>


	<!-- </table>
	<form action="flightdel" method="post">
		<input type="submit" value="delete" />
		
	</form> -->


	<%
		String msg =(String)request.getAttribute("MESSAGE");
	

		if (msg != null) {
	%>

	<h1>
		<%=msg%></h1>
	<%
		}
	%>
	</table>
	
	<br>
	<br>
	<input action="action" type="button" value="BACK" onclick="history.go(-2);" />
</div>
</body>
</html>