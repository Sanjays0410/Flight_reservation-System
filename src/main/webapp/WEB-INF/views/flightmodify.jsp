<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
 
 <form action="flightmodify" method="post">

		<label> FLIGHT ID:</label> <input type="text" value="<%=session.getAttribute("flightid") %>" name=flightid required/> <br>
		</br> <label for="flightname">Choose a Flight:</label> <select
			value="<%=session.getAttribute("flightname") %>"  name="flightname" id="flightname" required>
			<option value="IndiGo">IndiGo</option>
			<option value="Air India">Air India</option>
			<option value="SpiceJet">SpiceJet</option>
			<option value="GoAir">GoAir</option>
			<option value="AirAsia India">AirAsia India</option>
		</select> <br> </br> <label> Seating Capacity</label> <input type="text"
			value="<%=session.getAttribute("seatingcapacity") %>" name="seatingcapacity" required /> <br> </br> <label>Reservation
			Capacity</label> <input type="text" value="<%=session.getAttribute("reservationcapacity") %>" name="reservationcapacity"  required /> <br> </br>
		<input type="submit" value="Modify" />

	</form>

 <%
		String msg =(String)request.getAttribute("MESSAGE");
	

		if (msg != null) {
	%>

	<h1>
		<%=msg%></h1>
	<%
		}
	%>
 
 <br>
 <br>
 <a href="index.jsp"> <input type="submit" value="BACK"/></a>
     
    </div>

</body>
</html>