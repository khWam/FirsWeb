<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>

		<c:when test="${not empty sessionScope.pseudo}">
			<div>${sessionScope.pseudo} est connecté</div>
			<a href="LogOutControleur"> se déconnecter</a>
		</c:when>
		<c:otherwise>
		<a href="sessionControleur"> se connecter</a>
		</c:otherwise>

	</c:choose>
<a href ="saisieClimatisationControleur"> saisie d'une climatisation</a>
	<ul>
		<c:forEach var="object" items="${listObjects}">
			<li>${object}</li>
		<%-- 	<li>${object.pression}</li> --%>
		</c:forEach>
	</ul>
</body>
</html>