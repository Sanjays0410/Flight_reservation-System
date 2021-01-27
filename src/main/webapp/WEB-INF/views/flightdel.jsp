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
	<a href="index.jsp"> <input type="submit" value="BACK"/></a>
</div>
</body>
</html>