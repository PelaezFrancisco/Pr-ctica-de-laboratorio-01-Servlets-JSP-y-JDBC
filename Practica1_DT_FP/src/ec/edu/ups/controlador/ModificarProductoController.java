package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarProductoController
 */
@WebServlet("/ModificarProductoController")
public class ModificarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductoController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		try {
			producto.setProductoId(Integer.valueOf(request.getParameter("id")));
			producto.setProductoNombre(request.getParameter("nombre"));
			producto.setProductoDescripcion(request.getParameter("descrip"));
			producto.setProductoStock(Integer.valueOf(request.getParameter("stock")));
			producto.setProductoPrecioVenta(Double.parseDouble(request.getParameter("precioV")));
			producto.setCat_id(Integer.valueOf(request.getParameter("categ")));
			producto.setEmp_id(Integer.valueOf(request.getParameter("emp")));
			productoDao.update(producto);
			url = "/ListarProductoController";
			
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}

}
