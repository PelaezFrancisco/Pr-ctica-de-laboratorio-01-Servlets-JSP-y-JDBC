package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.PedidoCabecera;



/**
 * Servlet implementation class ListaPedidosController
 */
@WebServlet("/ListaPedidosController")
public class ListaPedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PedidoCabeceraDAO pedidoCabeceraDao ;
       private List<PedidoCabecera>listaPedidoC;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPedidosController() {
        pedidoCabeceraDao=DAOFactory.getFactory().getPedidoCabeceraDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		
		try {
			int codigoE = Integer.valueOf(request.getParameter("id"));
			System.out.println("Id de la empresa Recopilada" + codigoE);
			listaPedidoC = pedidoCabeceraDao.ProEmpPer(codigoE);
			
			System.out.println("Tamaño de la Lista"+ listaPedidoC.size());
			request.setAttribute("pedidosC", listaPedidoC);
			url = "/private/admin/listar_pedidos.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
