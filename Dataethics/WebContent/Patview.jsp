<%@page import="com.mvc.bean.Healthform"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

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
			<div><strong><a href="<%= request.getContextPath()%>/PatientServlet" id="active">Update Health Record</a></strong></div>
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
	<h5>
	<form name="form2" action="<%=request.getContextPath()%>/PatUpdtServlet" method="post">
	<table align="center" cellspacing="5" cellpadding="5" border=1>
	<% ArrayList<Healthform> list=(ArrayList<Healthform>) request.getAttribute("list");
	for (Healthform d :list){%>
	<tr><td>First Name </td>
	<td><input type="text" name="fname" value="<%=d.getFname()%>" readonly="readonly"></td></tr>
	<tr>
	<td>Last Name</td>
	<td><input type="text" name="lname" value="<%=d.getLname()%>" readonly="readonly"></td></tr>
	<tr>
	<td>Gender</td>
	<td><%=d.getGender() %></td></tr>
	<tr>
	<td>Age</td><td><%=d.getAge() %></td></tr>
	<tr>
	<td>Phone Number</td>
	<td><%=d.getPnum_me() %></td></tr>
	<tr>
	<td>SSN</td><td><%=d.getSsn_me()%></td></tr>
	<tr><td>Address</td>
	<td><%=d.getAddress() %></td></tr>
	<tr><td>General</td>
	<td><%=d.getGeneral_view() %></td></tr>
	<tr><td>ENT</td><td><%=d.getEnt_view()%></td></tr>
	<tr><td>Cardio</td>
	<td><%=d.getCardio_view() %></td></tr>
	<tr><td>Symptoms</td>
	<td><%=d.getSymptoms_me() %></td></tr>
	<tr><td>Doctor Pin</td>
	<td><%=d.getDpin() %></td></tr>
	<tr><td>Admin Pin</td>
	<td><%=d.getApin() %></td></tr>
	<%} %>
	</table>
	</form>
	</h5>

</body>
</html>