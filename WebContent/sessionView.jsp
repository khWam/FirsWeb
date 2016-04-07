<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="sessionControleur" method="post">
		<span> pseudo: </span><input type="text" value="${pseudo}"
			name="Pseudo" /> <span> ${pseudoError}</span><br />
			<input type="submit" value ="Connecter" name="Action"/>
	</form>
</body>
</html>