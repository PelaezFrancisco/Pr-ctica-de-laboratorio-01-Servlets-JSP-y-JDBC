<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="lista" scope="request" value="${empresas}" />
	<h1>Lista de personas</h1>

	<table>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>RUC</strong></td>
			<td><strong>Direccion</strong></td>
			<td><strong>Telefono</strong></td>
			<td><strong>Email</strong></td>
		</tr>
		<c:forEach var="e" items="${lista}">
			<tr>
				<td>${e.id}</td>
				<td>${e.nombre}</td>
				<td>${e.ruc}</td>
				<td>${e.direccion}</td>
				<td>${e.telefono}</td>
				<td>${e.email}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>