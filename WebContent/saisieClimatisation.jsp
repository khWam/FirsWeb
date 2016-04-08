<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="jquery-2.2.2.js"></script>
<script type="text/javascript" src="Climatisation.js"></script>

</head>
<body>
	<c:if test="${not empty pseudo}">
		<div>${pseudo} est connecté</div>

	</c:if>
	<a href="ListClimatisationControleur">liste des climatisations</a>
	<br />
	<br />

	<form action="saisieClimatisationControleur" method="POST">
		<br /> <br />
		Temperature (°C): <br />
		<input type="text" name="Temperature" value="${temper}" /><span>${temperatureErreurs}</span><br />
		Pression (bar): <br /> <input type="text" name="Pression"
			value="${press}" /><span> ${pressionErreurs} </span><br /> 
			Humidité(%): <br /> <input type="text" name="humidite" value="${humidit}" /><span>${humiditeErreurs} ${humidSignErreurs}</span><br /> 
			
			Nom Appareil: <br /> <input type="text" id="SourceNbId" name="nomAppareil" value="${Nom}" />
			<span>${appareilErreur}</span> 
			<span id="nbID" style="color: blue"></span> <br /> 
			Date (Année):<br /> <input type="text" name="Date" value="${uneDate}" /><span> ${dateErreurs}</span> <br />
		<br>
		<br> <input type="submit" value="enregistrer" name="Submit"><span>${sauveErreur}</span>
		<br />
	</form>
</body>
</html>