<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saisieClimatisationView" method="get">
		Temperature (°C): <br /> <input type="text" name="Temperature" value="${temper}"><br />
		Pression (bar): <br /> <input type="text" name="Pression" value="${press}"><br />
		Humidité (%): <br /> <input type="text" name="humidite" value="${humidit}"> <br />
		Nom Appareil: <br/> <input type="text" name="nomAppareil" value="${Nom}"> <br />
		Date (Année):<br/> <input type="text" name="Date" value="${uneDate}"><br />
<br><br>
<input type="submit" name="Submit"> 
	</form>
</body>
</html>

