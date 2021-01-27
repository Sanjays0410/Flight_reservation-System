<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div  align="center">

<table border="1" bordercolor="blue">

		<thead>
			<tr>
				<td>ROUTE ID</td>
				<td>SOURCE</td>
				<td>DESTINATION</td>
				<td>DISTANCE</td>
				<td>FARE</td>
			</tr>
		</thead>
		<tbody>


			<tr>

				<td><% String routeid=(String)session.getAttribute("Routeid");if(routeid!=null){ %>
				
				<%=routeid %> <%} %>
				
				</td>
				<td><% String source=(String)session.getAttribute("Source"); if(source!=null){%>
				
				<%=source %> <%} %>
				</td>
				<td><% String destination=(String)session.getAttribute("Distination"); if(destination!=null){%>
				
				<%=destination %> <%} %>
				</td>
				
				
				
				<td><% String distance=(String)  String.valueOf(session.getAttribute("Distance"));if(distance!=null){%>
				
				<%=distance %>  <%} %>
				</td>
				<td><% String fare=(String)  String.valueOf(session.getAttribute("Fare")); if(fare!=null){%>
				
				<%=String.valueOf(fare) %> <%} %>
				
				</td>
				<td> <a href="Routedelete?<%=session.getAttribute("Routeid") %>"
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














</div>

</body>
</html>