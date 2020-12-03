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
import ec.edu.ups.mysql.jdbc.JDBCEmpresaDAO;

/**
 * Servlet implementation class ModificarPedidoController
 */
@WebServlet("/ModificarPedidoController")
public class ModificarPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedidoController() {
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		Empresa emp = new Empresa();
		int id = Integer.parseInt(request.getParameter("id"));
		emp = empresaDAO.read(id);
		request.setAttribute("empresa", emp);
		url = "/private/user/Modificar.jsp";
		
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
