<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/IniciarSesion.css" rel="stylesheet" type="text/css">
<title>Persona Encontrada</title>
</head>
<body>
	<c:set var="lista" scope="request" value="${personas}" />
	<h1>Lista de personas</h1>

	<table>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Cedula</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>Apellido</strong></td>
			<td><strong>Telefono</strong></td>
			<td><strong>Direccion</strong></td>
			<td><strong>Email</strong></td>
		</tr>
		<c:forEach var="pro" items="${lista}">
			<tr>
				<td>${pro.productoId}</td>
				<td>${pro.productoNombre}</td>
				<td>${pro.productoDescripcion}</td>
				<td>${pro.productoStock}</td>
				<td>${pro.productoPrecioVenta}</td>
				<td>${pro.cat_id}</td>
				<td>${pro.emp_id}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/EjemploPersonaWebJDBC/index.html">Regresar al index</a>

</body>
</html>

