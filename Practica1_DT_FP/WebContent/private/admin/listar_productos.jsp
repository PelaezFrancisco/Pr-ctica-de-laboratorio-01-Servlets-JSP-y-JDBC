<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ListarProductos</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/listar.css" rel="stylesheet" type="text/css" />

</head>

<body>
    <header class="masthead bg-primary text-white text-center">
        <div class="container d-flex align-items-center flex-column">
            <!-- Masthead Avatar Image-->
            <img class="masthead-avatar mb-5" src="assets/img/portfolio/lista.png" alt="" />
            <!-- Masthead Heading-->
            <h1 class="masthead-heading text-uppercase mb-0">Listar Productos</h1>
            <!-- Icon Divider-->
        </div>
    </header>
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">

                <ul class="navbar-nav ml-auto">

                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/IniciarSesionController">Pagina Principal</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="/Practica1_DT_FP/private/admin/CrearProducto.html">Agregar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="">Modificar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="BuscarProductos.html">Buscar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="">Listar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="ListarProductos.html">Listar Productos</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index1.html">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <c:set var="lista" scope="request" value="${productos}" />

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