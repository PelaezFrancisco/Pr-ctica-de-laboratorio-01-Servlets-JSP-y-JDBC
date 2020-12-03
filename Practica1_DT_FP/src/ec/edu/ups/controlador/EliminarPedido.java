package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.PedidoCabecera;

/**
 * Servlet implementation class EliminarPedido
 */
@WebServlet("/EliminarPedido")
public class EliminarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoCabeceraDAO cabeceraDAO;
	private EmpresaDAO empresaDAO;
	private PedidoCabecera cabecera;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPedido() {
        cabeceraDAO = DAOFactory.getFactory().getPedidoCabeceraDAO();
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
        cabecera = new PedidoCabecera();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		int idCab = Integer.parseInt(request.getParameter("idcab"));
		
		cabecera = cabeceraDAO.read(idCab);
		cabeceraDAO.delete(cabecera);
		
		Empresa emp = new Empresa();
		
		emp = empresaDAO.read(cabecera.getPedidoCabeceraPerI());
		request.setAttribute("empresa", emp);
		
		url = "/private/user/inicio_user.jsp";
		
		
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
