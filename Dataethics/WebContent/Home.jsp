<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
		<h1>MULTI-SPECIALITY HOSPITAL</h1>
</div>

<div id="primary">
			<table id="alter" width="800px" border="0" cellpadding="0"  align="center" cellspacing="0">
				<tr> 
					<td width="20%">
		<div><strong><a href="<%= request.getContextPath()%>/Home.jsp" id="active">Home</a></strong></div>
					</td>
					<td width="20%">
				<div><strong><a href="<%= request.getContextPath()%>/LoginPage.jsp" id="active">Login</a></strong></div>
					</td>
					<td width="20%">
				<div><strong><a href="<%= request.getContextPath()%>/Registration.jsp" id="active">New Patients Registration</a></strong></div>
					</td>
				</tr>
				</table>
	</div>
	<div>
	<marquee behavior="scroll" direction="left">Emergency Services available 24*7</marquee>
	</div>
<div id="content" align="center">
	<img src="DoctorMBA.jpg" width="800" height="475"/>  		
</div>
<div id="footer">
Copyright � Yamini Praveena Tella
</div>
</body>
</html>