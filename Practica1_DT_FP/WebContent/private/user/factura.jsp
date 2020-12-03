<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factura</title>
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
            <h1 class="masthead-heading text-uppercase mb-0">Factura</h1>
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

                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="public/IniciarSesion.html">Pagina Principal</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <br><br><br>
    
    <table>
        <tr>
            <td><strong>Codigo</strong></td>
            <td><strong>Fecha</strong></td>
            <td><strong>Subtotal</strong></td>
            <td><strong>Iva</strong></td>
            <td><strong>Descuento</strong></td>
            <td><strong>Total</strong></td>
            <td><strong>Estado</strong></td>
        </tr>
            <tr>
						            		
                <td>${pedido.pedidoCabeceraNumero}</td>
                <td>${pedido.pedidoCabeceraFecha}</td>
                <td>${pedido.pedidoCabeceraSubtotal}</td>
                <td>${pedido.pedidoCabeceraIva}</td>
                <td>${pedido.pedidoCabeceraDescuento}</td>
                <td>${pedido.pedidoCabeceraTotal}</td>
                <td>${pedido.pedidoCabeceraEstado}</td>
				
            </tr> 
    </table>
    <br><br><hr><br><br>
    
    <c:set var="lista" scope="request" value="${pedido.pedidoDetalle}" />

    <table>
        <tr>
            <td><strong>Nombre</strong></td>
            <td><strong>Cantidad</strong></td>
            <td><strong>PrecioU</strong></td>
            <td><strong>Subtotal</strong></td>
            
        </tr>
        <c:forEach var="pedD" items="${lista}">
            <tr>
						            		
                <td>${pedD.producto.productoNombre}</td>
                <td>${pedD.pedidoDetalleCantidad}</td>
                <td>${pedD.pedidoDetallePrecioUnitario}</td>
                <td>${pedD.pedidoDetalleSubtotal}</td>
				
            </tr>
        </c:forEach>
    </table>

</body>
</html>