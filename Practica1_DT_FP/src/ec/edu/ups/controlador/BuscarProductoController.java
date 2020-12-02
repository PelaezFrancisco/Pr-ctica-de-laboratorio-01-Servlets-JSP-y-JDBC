package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class BuscarProductoController
 */
@WebServlet("/BuscarProductoController")
public class BuscarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Producto>listaBusqueda;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductoController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		try {
			String id = request.getParameter("id");
			listaBusqueda = productoDao.busqueda(id);
			System.out.println("Tamaño de la Lista: " + listaBusqueda.size());
			request.setAttribute("productosBusqueda", listaBusqueda);
			url = "/private/admin/buscar_producto.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
