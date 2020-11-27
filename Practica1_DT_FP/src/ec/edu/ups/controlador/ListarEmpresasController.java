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
import ec.edu.ups.modelo.Empresa;

/**
 * Servlet implementation class ListarEmpresasController
 */
@WebServlet("/ListarEmpresasController")
public class ListarEmpresasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
	private List <Empresa>listaEmpresa;
	
	public ListarEmpresasController() {
		empresaDAO = DAOFactory.getFactory().getEmpresaDao();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
			listaEmpresa = empresaDAO.find();
			System.out.println("Tamaño de la lista recuperada: " + listaEmpresa.size());
			request.setAttribute("personas", listaEmpresa);
			url = "/JSPs/listar_empresas.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}


}
