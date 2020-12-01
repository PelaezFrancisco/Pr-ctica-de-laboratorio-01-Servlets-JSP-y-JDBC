<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto Encontrado</title>
</head>
<body>

     <c:set var="pro" scope="request" value="${producto}" />
	<h1>Persona encontrada</h1>
	<p>Id: ${pro.productoId}</p>
	<p>Nombre: ${pro.productoNombre}</p>
	<p>Descripcion: ${pro.productoDescripcion}</p>
	<p>Stock:${pro.productoStock}</p>
	<p>PrecioV:${pro.productoPrecioVenta}</p>
	<p>Categoria: ${pro.cat_id}</p>
	<p>Empresa: ${pro.emp_id}</p>



</body>
</html>