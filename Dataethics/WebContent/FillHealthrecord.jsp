<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Form</title>
<style>
table#alter td {    
    background-color: #E6E6FA";  
}  
a#active
{
    color: black;
    font-weight:bold;   
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:475px;
    width:150px;
    float:left;
    padding:5px;	      
}
#primary {
background-color:#eeeeee;
line-height:25px;
color:white;
padding:4px;
}
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#section {
    width:600px;
    float:left;
    padding:100px;	 	 
}

</style>
</head>
<body>
<div id="header">
		<h1>MULTI SPECIALITY HOSPITAL</h1>
</div>
<div id="primary">
			<table id="alter" width="800px" border="0" cellpadding="0"  align="center" cellspacing="0">
				<tr> 
					<td width="20%">
		<div><strong><a href="<%= request.getContextPath()%>/PatientHome.jsp" id="active">Home</a></strong></div>
					</td>
					<td width="20%">
			<div><strong><a href="<%= request.getContextPath()%>/PatientServlet" id="active">View Health Record</a></strong></div>
					</td>
					<td width="20%">
			<div><strong><a href="<%= request.getContextPath()%>/PatUpdtServlet" id="active">Update Health Record</a></strong></div>
					</td>
					<td width="30%">
				<div><strong><a href="<%= request.getContextPath()%>/Logout.jsp" id="active">Logout</a></strong></div>
					</td>
				</tr>
				</table>
	</div>
	<div id="nav">
	<img src="<%=request.getContextPath()%>/Services-27.jpg" alt="logo Image" height="175" width="150"></img>
	<marquee behavior="scroll" direction="left">Emergency Services available 24*7</marquee>
	</div>
	<form name="form2" action="<%=request.getContextPath()%>/HealthRecord" method="post">
		<table cellspacing="5" cellpadding="5">
		    <tr><th><font size="5">Health History</font></th>	
			</tr>
			<tr>
			<td><font size="4">First Name:</font></td>
				<td><input type="text" name="Fname"></input></td>	
			</tr>
			<tr>
			<td><font size="4">Last Name:</font></td>
				<td><input type="text" name="Lname"></input></td>	
			</tr>
			<tr>
			<td><font size="4">Gender:</font></td>
				<td><input type="radio" name="rdoGender" id="Male" value="Male"><label for="Male">Male</label>
				<input type="radio" name="rdoGender" id="Female" value="Female"><label for="Female">Female</label>
				</td>
			</tr>
			<tr>
	      <td>Age</td>
		<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td><font size="4">Phone Number:</font></td>
				<td><input type="text" name="cellno"></input></td>
			<td>
				<input type="checkbox" name="mobile_permissions" value="doctor">only doctor
				<input type="checkbox" name="mobile_permissions" value="me">only me
				<input type="checkbox" name="mobile_permissions" value="admin">only admin
			</td>
		</tr>
			<tr>
			<td><font size="4">SSN:</font></td>
				<td><input type="text" name="ssn"></input></td>
				<td>
				<input type="checkbox" name="ssn_permissions" value="doctor">only doctor
				<input type="checkbox" name="ssn_permissions" value="me">only me
				<input type="checkbox" name="ssn_permissions" value="admin">only admin
			</td>
		</tr>	
	<tr>
	<td>Address</td>
	<td>
		<textarea name="address"></textarea>
	</td>
</tr>
			</table>
			Check the following symptoms you currently have or have had in the past year.<br>
			<table cellspacing="5" cellpadding="5">
			<tr>
	          <th>General:</th>
	          <td>
				<input type="checkbox" name="general" value="Fever">Fever
				<input type="checkbox" name="general" value="Headache">Headache
				<input type="checkbox" name="general" value="Loss of Sleep">Loss of Sleep
				<input type="checkbox" name="general" value="Loss of weight">Loss of weight
				<input type="checkbox" name="general" value="Dizziness/Fainting">Dizziness/Fainting
				<input type="checkbox" name="general" value="None">None
			 </td>
			 </tr>
			<tr>
			<th>Eye/Ear/Throat:</th>
				<td>
				<input type="checkbox" name="ent" value="Blurred vision">Blurred vision
				<input type="checkbox" name="ent" value="Difficulty Swallowing">Difficulty Swallowing
				<input type="checkbox" name="ent" value="Sinus Problems">Sinus Problems
				<input type="checkbox" name="ent" value="Nose bleeds">Nose bleeds
				<input type="checkbox" name="ent" value="Ear-ache/Ear discharge">Ear-ache/Ear discharge
				<input type="checkbox" name="ent" value="None">None
			 </td>
			 </tr>
			<tr>
	          <th>Cardio Vascular:</th>
	          <td>
				<input type="checkbox" name="cardio" value="ChestPain">Chest pain
				<input type="checkbox" name="cardio" value="BloodPressure">High/Low Blood Pressure
				<input type="checkbox" name="cardio" value="Swelling of ankles">Swelling of ankles
				<input type="checkbox" name="cardio" value="Irregular?Rapid Heartbeat">Irregular/Rapid Heart beat
				<input type="checkbox" name="cardio" value="Poor circulation">Poor Circulation
				<input type="checkbox" name="cardio" value="None">None
			 </td>
			</tr>
	<tr>
	<th>Symptoms:</th>
	<td>
		<textarea name="symptoms"></textarea>
		<input type="checkbox" name="symptoms_permissions" value="doctor">only doctor
		<input type="checkbox" name="symptoms_permissions" value="me">only me
		<input type="checkbox" name="symptoms_permissions" value="admin">only admin
	</td>
	</tr>
	<tr>
		<td><font size="4">Doctor Pin:</font></td>
		<td><input type="text" name="dpin"></input> <font color="blue">This pin is used to provide access to the doctor</font></td>
	</tr>
	<tr>
		<td><font size="4">Admin Pin:</font></td>
		<td><input type="text" name="apin"></input> <font color="blue">This pin is used to provide access to the admin</font></td>
	</tr>
			<tr align="right">
			<th><div align="right">
			<input size="6" type="submit" name="submit" value="Register">
			</div></th>
			
			<th align="center">
			<input size="6" type="reset" name="submit2" value="Reset">
			</th>
			
			</tr>
		</table>
	</form>
	
<div id="footer">
Copyright © Yamini Praveena Tella
</div>
</body>
</html>