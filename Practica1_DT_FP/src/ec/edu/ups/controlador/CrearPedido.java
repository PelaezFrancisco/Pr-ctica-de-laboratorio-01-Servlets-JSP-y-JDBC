package ec.edu.ups.controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class CrearPedido
 */
@WebServlet("/CrearPedido")
public class CrearPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PedidoDetalleDAO detalleDAO;
    private PedidoCabeceraDAO cabeceraDAO;
    private EmpresaDAO empresaDAO;
    private PersonaDAO personaDAO;
    private ProductoDAO productoDAO;
    private PedidoCabecera cabecera;
    private ArrayList<PedidoDetalle> detalles;
    private ArrayList<Producto> listaproductos;
    private ArrayList<Persona> listaPersonas;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPedido() {
        cabeceraDAO = DAOFactory.getFactory().getPedidoCabeceraDAO();
        detalleDAO = DAOFactory.getFactory().getPedidoDetalleDAO();
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        productoDAO = DAOFactory.getFactory().getProductoDAO();
        cabecera = new PedidoCabecera();
        detalles = new ArrayList<PedidoDetalle>();
        listaproductos = new ArrayList<Producto>();
        listaPersonas = new ArrayList<Persona>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Double subtotal=0.0;
		Double iva=1.2;
		Double descuento=1.0;
		/*
		 * TRAEMOS EL ID DE EMPRESA Y LA CANTIDAD DE VENTA DE PRODUCTOS
		 */
		//Id de empresa
		int idEmp=Integer.parseInt(request.getParameter("emp"));
		//Traemos lista de productos de la empresa
		listaproductos = empresaDAO.lista(idEmp);
		//System.out.println("Lista de prudctos de empresa de compra= "+listaproductos.size());
		for (int i = 0; i < listaproductos.size(); i++) {
			try {
				//Recibimos la cantida de compra(cant) del producto (i)
				int cant = Integer.parseInt(request.getParameter("cant"+listaproductos.get(i).getProductoId()));
				//Creamos el objeto detalle
				PedidoDetalle ped = new PedidoDetalle();
				ped.setPed_id(0);	//Id del pedido cabecera
				ped.setPedidoDetalleCantidad(cant);
				ped.setPedidoDetallePrecioUnitario(listaproductos.get(i).getProductoPrecioVenta());
				ped.setPedidoDetalleSubtotal(listaproductos.get(i).getProductoPrecioVenta()*cant);
				ped.setPro_id(listaproductos.get(i).getProductoId()); //Id del producto
				ped.setProducto(listaproductos.get(i));
				//Sumamos al subtotal de cabcera
				subtotal=subtotal+listaproductos.get(i).getProductoPrecioVenta()*cant;
				//Agregamos el objeto detalle a la lista
				detalles.add(ped);
				
				//Reducimos el stock
				int stock_aux = listaproductos.get(i).getProductoStock();
				listaproductos.get(i).setProductoStock(stock_aux-cant);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(">>>Error recibiendo cantidades en CrearPedido");
			}
		}
		//System.out.println("Cantidad de detalles= "+detalles.size());
		/*
		 * TRAEMOS A LA PERSONA QUE HACE EL PEDIDO 
		 */
		listaPersonas=(ArrayList<Persona>) personaDAO.find();
		int perId = 0;
		//System.out.println("Tamaño de listarPersonas= "+listaPersonas.size());
		for (int i = 0; i < listaPersonas.size(); i++) {
			//System.out.println("per_emp_id= "+listaPersonas.get(i).getEmpresaId());
			//System.out.println("per_rol= "+listaPersonas.get(i).getRol());
			if (listaPersonas.get(i).getEmpresaId()==idEmp && Character.compare(listaPersonas.get(i).getRol(), 'U')==0) {
				perId = listaPersonas.get(i).getId();
				//System.out.println("La persona que hizo el pedido es= "+listaPersonas.get(i).getNombre());
			}
		}
		/*
		 * CREAMOS LA CABECERA
		 */
		//System.out.println("Id de persona a Cabecera= "+perId);
		
		Date fecha = new Date();
		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(fecha);
		//System.out.println("Fecha creada= "+mysqlDateString);
		cabecera.setPedidoCabeceraFecha(mysqlDateString);
		cabecera.setPedidoCabeceraSubtotal(subtotal);
		cabecera.setPedidoCabeceraIva(iva);
		cabecera.setPedidoCabeceraDescuento(descuento);
		cabecera.setPedidoCabeceraTotal((subtotal/descuento)*iva);
		cabecera.setPedidoCabeceraEstado('P');	//P de pendiente
		cabecera.setPedidoCabeceraPerI(perId);
		
		cabeceraDAO.create(cabecera);
		
		PedidoCabecera cab_aux = new PedidoCabecera();
		cab_aux = cabeceraDAO.read2("");
		int cabId = cab_aux.getPedidoCabeceraNumero();
		//System.out.println("Pedido de cabecera creado= "+cabId);
		/*
		 * AHORA CREAMOS EL DETALLE 
		 */
		//Antes que nada cambiamos los ped.setPed_id(0);
		for (int i = 0; i < detalles.size(); i++) {
			detalles.get(i).setPed_id(cabId);
			
			detalleDAO.create(detalles.get(i));
			//System.out.println("creacion de detalles");
		}
		/*
		 * YA HABIDO CREADO EL ENCABEZADO Y DETALLE, HACEMOS LA DISMINUCION DE INVENTARIO
		 */
		for (int i = 0; i < listaproductos.size(); i++) {
			productoDAO.update(listaproductos.get(i));
			System.out.println("Modificaciones Exitosas");
		}
		
		/*
		 * FINALIZACION
		 */
		cab_aux.setPedidoCabeceraFecha(mysqlDateString);
		cab_aux.setPedidoDetalle(detalles);
		cab_aux.setPedidoCabeceraEstado('P');
		cab_aux.setPedidoCabeceraSubtotal(subtotal);
		cab_aux.setPedidoCabeceraIva(iva);
		cab_aux.setPedidoCabeceraDescuento(descuento);
		cab_aux.setPedidoCabeceraTotal((subtotal/descuento)*iva);
		cab_aux.setPedidoCabeceraEstado('P');	//P de pendiente
		cab_aux.setPedidoCabeceraPerI(perId);
		
		request.setAttribute("pedido", cab_aux);
		
		String url= "/private/user/factura.jsp";
		//System.out.println("Empresa de Compra: "+idEmp);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
