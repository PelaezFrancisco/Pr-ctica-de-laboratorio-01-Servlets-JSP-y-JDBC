package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.PedidoDetalle;

/**
 * Servlet implementation class ModificarPedidos
 */
@WebServlet("/ModificarPedidos")
public class ModificarPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
	private PedidoDetalleDAO detalleDAO;
	private PedidoCabeceraDAO cabeceraDAO;
	private PedidoDetalle detalle;
	private PedidoCabecera cabecera;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedidos() {
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
        detalleDAO = DAOFactory.getFactory().getPedidoDetalleDAO();
        cabeceraDAO = DAOFactory.getFactory().getPedidoCabeceraDAO();
        detalle = new PedidoDetalle();
        cabecera = new PedidoCabecera();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		int idCab = Integer.parseInt(request.getParameter("idcab"));
		int idDet = Integer.parseInt(request.getParameter("iddet"));
		int idPro = Integer.parseInt(request.getParameter("idpro"));
		int cant = Integer.parseInt(request.getParameter("cant"));
		
		try {
			detalle = detalleDAO.read(idDet);
			detalle.setPedidoDetalleCantidad(cant);
			
			detalleDAO.update(detalle);
			
			cabecera = cabeceraDAO.read(idCab);
			request.setAttribute("cabecera", cabecera);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(">>>ERROR AL MODIFICAR PRODUCTO");
		}
		
		request.setAttribute("pedido", cabecera);
		url = "/private/user/factura.jsp";
		
		
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
