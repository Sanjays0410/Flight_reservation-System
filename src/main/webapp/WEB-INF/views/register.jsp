<!DOCTYPE html>
<html>
    <title>FLIGHT RESERVATION SYSTEM</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Teko:wght@500&display=swap" rel="stylesheet">
<style>

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
    
    .h5
    {
        font-family: 'Teko', sans-serif;
       
    }
    body
    {
        
        background-color:darkseagreen;  
     /* background-color:lavender;*/
        
       
    }
    marquee
    {
        color: white;
        background-color: forestgreen;
    }
    
    * {
  box-sizing: border-box;
}


#regForm {
  background-color: #ffffff;
  margin: 100px auto;
  font-family: Raleway;
  padding: 50px;
  width: 50%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
  font-family: Raleway;
  border: 1px solid #aaaaaa;
}

/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
  display: none;
}

button {
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}
     img {
  border-radius: 50%;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: #4CAF50;
}
    
</style>
</head>
<body>
    <marquee behavior="scroll" direction="left">FLIGHT RESERVTION SYSTEM  </marquee>
<hr>
    <h5  align="center" ><font color="#001133" size="60" > <img src="resources/img/logo.jpg"  width="100" height="100">Flight Reservation System</font></h5>
<hr>
    
     <marquee behavior="scroll" direction="left">REGISTER HERE>>>>>>>>>>>>> </marquee>
    
    <form id="regForm" action="register" method="post">
  <h1>Register:</h1>
  <!-- One "tab" for each step in the form: -->
  <div class="tab">Personal INfo:
    <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
    <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
    <p><input placeholder="DOB..." oninput="this.className = ''" name="DOB"></p>
    <p><label for="gender">Choose a Gender:</label> <select 
			name="gender" id="gender" required>
			<option value="MALE">MALE</option>
			<option value="FEMALE">FEMALE</option>
		</select>
   
 
    </p>
  </div>
  <div class="tab">Contact Info:
    <p><input placeholder="Phone..." oninput="this.className = ''" name="phone"></p>
  </div>
  <div class="tab">Address:
    <p><input placeholder="Street" oninput="this.className = ''" name="Street"></p>
    <p><input placeholder="Location" oninput="this.className = ''" name="Location"></p>
    <p><input placeholder="City" oninput="this.className = ''" name="City"></p>
    <p><label for="State">Choose a State:</label> <select required
			name="State" id="State" >
			<option value="KARNATAKA">KARNATAKA</option>
			<option value="ANDRA PRADESH">ANDRA PRADESH</option>
				<option value="TAMIL NADU">TAMIL NADU</option>
					<option value="KERALA">KERALA</option>
						<option value="MAHARASTRA">MAHARASTRA</option>
		</select>
    </p>
    <p><input placeholder="Pincode" oninput="this.className = ''" name="Pincode"></p>
  </div>
  <div class="tab">Login Info:
    <p><input placeholder="Email id..." oninput="this.className = ''" name="email"></p>
    <p><input placeholder="Password..." oninput="this.className = ''" name="password" type="password"></p>
  </div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  
  <a href="index.jsp"> <button type="button" >BACK</button></a>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
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

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>
    </body>
</html>