<!DOCTYPE html>
<html>
<title>FLIGHT RESERVATION SYSTEM</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Teko:wght@500&display=swap"
	rel="stylesheet">
<style>
.accordion {
	background-color: lavender;
	color: #001133;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 18px;
	transition: 0.4s;
}

.active, .accordion:hover {
	background-color: #ccc;
}

.panel {
	padding: 0 18px;
	background-color: darkseagreen;
	max-height: 0;
	overflow: hidden;
}

.button11 {
	background-color: #ccc;
	border: none;
	color: black;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.h5 {
	font-family: 'Teko', sans-serif;
}

body {
	background-color: darkseagreen;
	/* background-color:lavender;*/
}

img {
	border-radius: 50%;
}
/* this below is for logout button */
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

marquee {
	color: white;
	background-color: forestgreen;
}
</style>
</head>
<body>


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
	</form>

	<h2 align="left">CATALOGUE OF FLIGHT MANAGEMENT</h2>
	<button class="accordion">FLIGHT</button>
	<div class="panel">
		<br> <a class="button11" href="flight.html">INSERT</a> <a
			href="flightlist.html" class="button11">DISPLAY/DELETE/MODIFY</a>
	</div>
	<br>

	<button class="accordion">ROUTE</button>
	<div class="panel">
		<br> <a href="Routeadd.html" class="button11">INSERT</a> <a
			href="Routelist.html" class="button11">DISPLAY/DELETE/MODIFY</a> <br>
	</div>
	<br>

	<button class="accordion">SCHEDULE</button>
	<div class="panel">
		<br> <a href="Scheduleadd.html" class="button11">INSERT</a> <a
			href="Schedulelist.html" class="button11">DISPLAY/DELETE/MODIFY</a> <br>
	</div>
	<br>

	<button class="accordion">PASSENGER</button>
	<div class="panel">
		<br> <a href="" class="button11">VIEW</a> <br>
	</div>
	<br>


	<br>
	<br>
	<hr>
	<marquee behavior="scroll" direction="left">FLIGHT RESERVTION
		SYSTEM </marquee>


	<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i =0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}
    
</script>

</body>
</html>
