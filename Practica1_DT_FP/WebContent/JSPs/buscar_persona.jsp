<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persona Encontrada</title>
</head>
<body>
	<c:set var="p" scope="request" value="${persona}" />
	<h1>Persona encontrada</h1>		
		
	<p>Id: ${per.id}</p>
	<p>Cedula: ${per.cedula}</p>
	<p>Nombre: ${per.nombre}</p>
	<p>Apellid: ${per.apellido}</p>
	
	<a href="/EjemploPersonaWebJDBC/index.html">Regresar al index</a>
	
</body>
</html>

