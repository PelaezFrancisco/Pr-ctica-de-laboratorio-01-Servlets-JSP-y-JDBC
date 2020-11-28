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
 * Servlet implementation class ActualizarPersonaController
 */
@WebServlet("/ActualizarPersonaController")
public class ActualizarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private Persona persona;

	public ActualizarPersonaController() {
		personaDao = DAOFactory.getFactory().getPersonaDAO();
		persona = new Persona();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
			persona.setId(Integer.valueOf(request.getParameter("per_id")));
			persona.setCedula(request.getParameter("per_cedula"));
			persona.setNombre(request.getParameter("per_nombre"));
			persona.setApellido(request.getParameter("per_apellido"));
			//persona.setRol(request.getParameter("per_rol"));
			persona.setTelefono(request.getParameter("per_telefono"));
			persona.setDireccion(request.getParameter("per_direccion"));
			persona.setEmail(request.getParameter("per_email"));
			persona.setContrasena(request.getParameter("per_contrasena"));
			personaDao.update(persona);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
