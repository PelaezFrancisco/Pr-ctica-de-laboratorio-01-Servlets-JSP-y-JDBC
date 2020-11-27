<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%--Esto es una directiva para utilizar la clase Date --%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Ecodeup</title>
</head>
<body>
	Bienvenido a Ecoeup donde se utiliza Java y JavaWeb
	<br>
	<%--Este es un cometnario es JSP --%>
	
	<%-- Esto es un scriplet --%>
	<%out.println(); %>
	<%out.println("Hola desde jsp"); %>
	<br>
	<%-- Esto es una expresion en JSp --%>
	<%="Esto es una expresion" %>
	<br>
	<%--Arriba se declaro la directiva para la clase Date --%>
	<%
	Date d = new Date();
	out.println(d);
	%>
	<br>
	<%-- Declaraciones en JSP --%>
	<%! public static int contador = 7; %>
	<% out.println("Valor de la variable contador= "+contador); %>
	<br>
	<%-- Navegador y Version del Sistema Operativo --%>
	<% out.println(request.getHeader("USER-AGENT")); %>
	
</body>
</html>