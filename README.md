# Pr-ctica-de-laboratorio-01-Servlets-JSP-y-JDBC
Practica con desarrollo de Servelts, JSP y JDBC

/public/index.jsp

Se encuentra el index publico, donde no es necesario ingresar a la sesion. Aqui se puede filtrar los diferentes productos existentes por la respectiva empresa

![index Publico](/readmeImages/1.png)

/public/IniciarSesion.html

Esta pagina publica se encuentran dos campos para ingresar a la sesion, siendo estos el email y la contraseña

![index Publico](/readmeImages/2.png)

/private/admin_index.jsp

Es la pagina principal del administrador, en esta se puede ver un mensaje de bienvenida personalizado dado el usuario que ingreso sesion, la informacion personal de este como veremos a continuacion

![index Publico](/readmeImages/3.png)

Se puede ver que se encuetran los datos personales de la persona que ingreso a la sesion. Como tambien podemos ver los datos de la empresa a la que pertenece.

![index Publico](/readmeImages/4.png)

Vemos aqui la creacion de un producto, el cual siempre va a pertenecer a la empresa a la cual se ingreso a la sesion.

![index Publico](/readmeImages/5.png)

Podemos constatar que el producto ingresado se puede visualizar desde el index publico a la empresa correspondiente

![index Publico](/readmeImages/6.png)

Podemos ver que el producto agregado anteriormente, se muestra en los productos que se pueden modificar, se modificara la descripcion del producto, cambiando el color de "azul/rojo" a "morado/verde".

![index Publico](/readmeImages/7.png)

Podemos constatar que en efecto si se modifico.

![index Publico](/readmeImages/8.png)

La busqueda de un producto a base del nombre.

![index Publico](/readmeImages/9.png)

La salida despues de la busqueda

![index Publico](/readmeImages/10.png)

Podemos ver que tambien esta funcionando el listar productos por parte del administrador

![index Publico](/readmeImages/11.png)

En esta pagina estamos queriendo eliminar el producto que nos acabamos de crear.

![index Publico](/readmeImages/12.png)

Podemos verificar que el producto fue eliminado

![index Publico](/readmeImages/13.png)

Para la compra de productos o creaciones de pedidos, es necesario tener que ingresarse por la cuenta de Usuario. En este ejemplo compraremos 3 unidades

![index Publico](/readmeImages/14.png)

Podemos constatar la factura en la cual se encuentran los datos de la factura detalle y la factura cabecera, asi como tambien los totales y subtotales


![index Publico](/readmeImages/15.png)


En esta imagen, se puede ver que existe tambien la forma de ver los pedidos hechos por cada usuario de cada empresa. En este caso podemos ver la factura de los campos realizados anteriormente

![index Publico](/readmeImages/16.png)


Podemos ver que tambien se pueden ver los detalles facturas seleccionados

![index Publico](/readmeImages/17.png)

Actualizar Producto Controller (Servlet)

![index Publico](/readmeImages/18.png)


Crear pedido Controller

![index Publico](/readmeImages/19.png)

Iniciar Sesion Controller

![index Publico](/readmeImages/20.png)

Generic DAO

![index Publico](/readmeImages/21.png)

Modelo Categoria

![index Publico](/readmeImages/22.png)

JDBCEmpresaDAO

![index Publico](/readmeImages/23.png)

Filtro Inicio de Sesion

![index Publico](/readmeImages/24.png)

Listar_pedidos.jsp


![index Publico](/readmeImages/25.png)

index.jsp

![index Publico](/readmeImages/26.png)
