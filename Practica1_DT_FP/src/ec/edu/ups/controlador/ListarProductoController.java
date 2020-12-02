package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ListarProductoController
 */
@WebServlet("/ListarProductoController")
public class ListarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Producto>listaProducto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductoController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		int codigo=8;
		//codigo = Integer.valueOf(request.getParameter(codigo));
		System.out.println("El codigo es "+ codigo);
		try {
			listaProducto = productoDao.ProEmpPer(codigo);
			System.out.println("Tamaño de la Lista: " + listaProducto.size());
			request.setAttribute("productos", listaProducto);
			url = "/private/admin/listar_productos.jsp";
				
			
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}
	


}
