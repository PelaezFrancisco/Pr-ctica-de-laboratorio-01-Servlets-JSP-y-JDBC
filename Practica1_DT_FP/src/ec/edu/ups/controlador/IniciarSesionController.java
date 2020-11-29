package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.modelo.Persona;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private Persona persona;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
        // TODO Auto-generated constructor stub
    	//Creamos el Dao Para Persona
    	personaDao = DAOFactory.getFactory().getPersonaDAO();
    	System.out.println("Creacion de persona");
		persona = new Persona();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		char rol = 'Z';
		try {
			String email = request.getParameter("correo");
			String contrasena = request.getParameter("contrasena");
			persona = personaDao.find_email(email);
			System.out.println("Email recibido = "+email);
			System.out.println("Email de Base = "+persona.getEmail());
			
			try {
				rol = persona.getRol();
				System.out.println("Rol de Persona = "+ rol );
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Problema Resolviendo el Rol");
			}
			
			
			request.setAttribute("persona", persona);
			
			//If para redireccion de rol
			if (rol=='A') {
				System.out.println("Se manda a Admin");
				url = "/private/admin/inicio_admin.jsp";
			}else {
				System.out.println("Se manda a user");
				url = "/private/user/inicio_user.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
