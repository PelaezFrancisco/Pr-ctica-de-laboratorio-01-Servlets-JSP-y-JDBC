package ec.edu.ups.controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class CrearProductoController
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
					maxFileSize=1024*1024*50,      	// 50 MB
					maxRequestSize=1024*1024*100)   	// 100 MB
@WebServlet("/CrearProductoController")
public class CrearProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
	private List<Producto>listaProducto;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProductoController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
			int codigo =Integer.valueOf(request.getParameter("idP"));
			System.out.println("El codigo es del metodo GET: "+ codigo);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;
		
		//int codigoP = Integer.valueOf(request.getParameter("id"));
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("mail")!=null) {
			response.setContentType("text/html");  
			PrintWriter pw=response.getWriter(); 
			response.sendRedirect("/Practica1_DT_FP/public/IniciarSesion.html");
			pw.close(); 
		}
		
		try {
	   
			//producto.setProductoId(Integer.valueOf(request.getParameter("id")));
			producto.setProductoNombre(request.getParameter("nombre"));
			producto.setProductoDescripcion(request.getParameter("descrip"));
			producto.setProductoStock(Integer.valueOf(request.getParameter("stock")));
			producto.setProductoPrecioVenta(Double.parseDouble(request.getParameter("precioV")));
			producto.setProductoImagen("images/"+request.getParameter("imagen"));
			producto.setCat_id(Integer.valueOf(request.getParameter("categ")));
			producto.setEmp_id(Integer.valueOf(request.getParameter("emp")));
			productoDao.create(producto);	
			url="/private/admin/inicio_admin.jsp" ;
			
			} 
		catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	 private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        //System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	        	//System.out.println("Este es el famoso token="+token);
	        	
	        	String var = token.trim().substring(6);
	        	System.out.println("Token con trim= "+var);
	        	
	            if (var.startsWith("imagen")) {
	            	//System.out.println("Si esta como imagen");
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	    }

}
