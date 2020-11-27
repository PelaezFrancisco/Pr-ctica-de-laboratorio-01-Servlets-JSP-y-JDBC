<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejemplo persona</title>
</head>
<body>
	<H1>Utilizacion de JSTLs</H1>
	<H2>Acceso a objetos</H2>
	<c:set var="p1" value="${requestScope['persona']}"/>
	<c:set var="p2" scope="request" value="${persona}"/>
	<c:set var="p3" scope="session" value="${persona}"/>
	
	<p>nombre: ${p1.nombre} </p>
	<p>cedula: ${p1.cedula} </p>
	
	<H2>Sentencia If</H2>
	<c:if test="${p1.nombre == 'Francisco'}">
		<p>Dentro de if: Es Pelaez</p>
	</c:if>
	
	<H2>Sentencia else if</H2>
	<c:choose>
		<c:when test="${p1.nombre ==  'Diana'}">
			<p>Es Tixi</p>
		</c:when>
		<c:when test="${p1.nombre == 'Gabriel'}">
			<p>Es Leon</p>
		</c:when>
		<c:otherwise>
			<p>No se sabe</p>
		</c:otherwise>
	</c:choose>
		
</body>
</html>