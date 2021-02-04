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


		<h1>ROUTE DATA MODIFICATION</h1>

		<form action="Routemodify" method="post">
			<label>Rouite id :</label> <input type="text"
				value="<%String routeid = (String) session.getAttribute("Routeid");
			if (routeid != null) {%> <%=routeid%>  <%}%>"
				name="routeid" readonly required /> <br> <br> <label>Choose
				a Source:</label> <select
				value="<%String source = (String) session.getAttribute("Source");
			if (source != null) {%>  <%=source%> <%}%>"
				name="Source" id="source" required>
				<option> <%String source1 = (String) session.getAttribute("Source");
			if (source1 != null) {%>  <%=source1%> <%}%></option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> <label>Choose a Destination:</label> <select
				value="<%String destination = (String) session.getAttribute("Destination");
			if (destination != null) {%> <%=destination%>  <%}%>"
				name="Destination" id="destination" required>
				<option> <%=session.getAttribute("Destination")%></option>
				<option value="Banglore">Banglore</option>
				<option value="Chennai">Chennai</option>
				<option value="Delhi">Delhi</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Kolkata">Kolkata</option>
				<option value="Rajasthan">Rajasthan</option>
			</select> <br> <br> <label> Distance:</label> <input type="text"
				value="<%=session.getAttribute("Distance")%>" name="Distance"
				required /> <br> <br> <label>ENTER FARE PER MILE:</label>
			<input type="text" value="<%=session.getAttribute("Fare")%>"
				name="Fare" required /> <br> <br> <input type="submit"
				value="MODIFY" />

		</form>


		<%
			String msg = (String) request.getAttribute("MESSAGE");

			if (msg != null) {
		%>

		<h1>
			<%=msg%></h1>
		<%
			}
		%>

		<br> <br><input action="action" type="button" value="BACK" onclick="history.go(-1);" />

	</div>

</body>
</html>