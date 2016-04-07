<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#p1{text-align: center;
color: red}
#p2{text-align: center;
color: #973397}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>affichage de la date et l heure</title>

</head>
<body>
<p id=p1>${dateDuJour}</p>
<br/>
<p id=p2>${heureDuJour}</p>
<div>
les donnée mesurée par le capteur sont:
${Climatisation1.getPressionPoucesMercures()}<br/>;
${Climatisation1. getTemperatureFerenheit()}
</div>

</body>
</html>