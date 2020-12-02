package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Persona;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
	private Empresa empresa;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
    	empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
    	System.out.println("Creacion de empresa");
		empresa = new Empresa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 1;
		String url = null;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			empresa = empresaDAO.read(id);
			if (empresa== null) {
				System.out.println("empresa null");
			}
			request.setAttribute("empresa", empresa);
			url = "/public/index.jsp";
			System.out.println("Index controller funciono correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>>ERROR DE INDEX CONTROLLER");
			url = "/public/error.html";
		}
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
