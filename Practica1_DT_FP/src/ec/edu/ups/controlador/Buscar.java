package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.PedidoCabecera;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoCabeceraDAO cabeceraDAO;
	private PedidoCabecera cabecera;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
    	cabeceraDAO = DAOFactory.getFactory().getPedidoCabeceraDAO();
    	cabecera = new PedidoCabecera();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=null;
		int idCab = Integer.parseInt(request.getParameter("idcab"));
		
		cabecera = cabeceraDAO.read(idCab);
		request.setAttribute("cabecera", cabecera);
		
		url = "/private/user/factura.jsp";
		
		
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
