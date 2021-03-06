package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ListarPersonaController
 */
@WebServlet("/ListarPersonaController")
public class ListarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private List<Persona> listaPersona;
	
	//private ProductoDAO productoDao;
	private List<Producto>listaProducto;
	
	public ListarPersonaController() {
	personaDao = DAOFactory.getFactory().getPersonaDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String url = null;
		try {
			listaPersona = personaDao.find();
			System.out.println("Tama�o de la Lista: " + listaPersona.size());
			request.setAttribute("personas", listaPersona);
			url = "/JSPs/listar_persona.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	*/
	}

}
