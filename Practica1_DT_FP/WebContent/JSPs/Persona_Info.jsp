<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html public>
<jsp:useBean class="ec.edu.ups.modelo.Persona" id="persona" scope="page"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pagina Persona JSP</title>
</head>
<body>
	<jsp:setProperty property="nombre" name="persona" value="Francisco"/>
	<%= "el nombre de la persona es: " %>
	<h1><jsp:getProperty property="nombre" name="persona"/></h1>
</body>
</html>