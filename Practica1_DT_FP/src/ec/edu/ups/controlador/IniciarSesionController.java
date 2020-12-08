package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Persona;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private EmpresaDAO empresaDao;
	private Persona persona;
	private Empresa empresa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
        // TODO Auto-generated constructor stub
    	//Creamos el Dao Para Persona
    	personaDao = DAOFactory.getFactory().getPersonaDAO();
    	empresaDao = DAOFactory.getFactory().getEmpresaDAO();
    	System.out.println("Creacion de persona");
		persona = new Persona();
		empresa = new Empresa();
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
			//MD5 para contrasena
			String contrasena = getMd5(request.getParameter("contrasena"));
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
			
			
			//request.setAttribute("persona", persona);
			
			
			
			//If para control de contrasena
			System.out.println("Contrasena puesta= "+contrasena);
			System.out.println("Contrasena de base= "+persona.getContrasena());
			if (contrasena.equals(persona.getContrasena())) {
				
				//Carga los datos del usuario dentro del HttpSession
				HttpSession  session=request.getSession(true);
		        session.setAttribute("mail", email);
		        session.setAttribute("password", persona.getContrasena());
				
				//If para redireccion de rol
				if (rol=='A') {
					System.out.println("Se manda a Admin");
					url = "/private/admin/inicio_admin.jsp";
				}else {
					System.out.println("Se manda a user");
					url = "/private/user/inicio_user.jsp";
				}
			}else {
				url = "/public/IniciarSesion.html";
			}
			
			empresa = empresaDao.read(persona.getId());
			request.setAttribute("empresa", empresa);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} catch (Exception e) {
			System.out.println("ERROR DE INICIO DE SESION");
			e.printStackTrace();
			response.setContentType("text/html");  
			PrintWriter pw=response.getWriter(); 
			//request.setAttribute("empresa", null);
			response.sendRedirect("/Practica1_DT_FP/public/IniciarSesion.html");
			pw.close(); 
			//url = "/public/IniciarSesion.html";
		}
		
	}
	
	//MD5 hashing
	public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

}
