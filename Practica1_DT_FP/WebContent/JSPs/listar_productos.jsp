<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="lista" scope="request" value="${productos}" />
	<h1>Lista de personas</h1>

	<table>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>Descripcion</strong></td>
			<td><strong>Stock</strong></td>
			<td><strong>PrecioV</strong></td>
			<td><strong>categoria</strong></td>
			<td><strong>Empresa</strong></td>
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
	<a href="/Practica1_DT_FP/index.html">Regresar al index</a>

</body>
</html>