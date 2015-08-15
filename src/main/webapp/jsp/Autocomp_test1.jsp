<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autocomp_Test1</title>
</head>
<body>
	<%
		System.out.println("Autocomp Test1 - JSP executed!");
	%>
	<form action="test1" method="post" id="form">
	    <div><label>Username</label></div>
		<div><input type="text" id="username" name="username"></input></div>
	    <div><label>Password</label></div>
		<div><input type="password" id="password" name="password"></input></div>
		<div><input type="submit" value="Login" /></div>
	</form>
	<script type="text/javascript">
		//document.getElementById("form").submit();
	</script>
</body>
</html>