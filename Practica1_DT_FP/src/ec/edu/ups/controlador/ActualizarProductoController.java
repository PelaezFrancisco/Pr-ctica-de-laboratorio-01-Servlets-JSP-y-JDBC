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
 * Servlet implementation class ActualizarProducto
 */
@WebServlet("/ActualizarProducto")
public class ActualizarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
	private List<Producto>listaProducto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProductoController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
        producto = new Producto();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		try {
			listaProducto = productoDao.ProEmpPer();
			System.out.println("Tamaño de la Lista: " + listaProducto.size());
			request.setAttribute("productos", listaProducto);
			url = "/private/admin/actualizar_productos.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
