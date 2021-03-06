package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCPersonaDAO;
import ec.edu.ups.mysql.jdbc.JDBCProductoDAO;
import ec.edu.ups.mysql.jdbc.JDBCEmpresaDAO;
import ec.edu.ups.mysql.jdbc.JDBCPedidoCDAO;
import ec.edu.ups.mysql.jdbc.JDBCPedidoDetalle;
/**
 * Clase JDBCGenericDAO.
 * 
 * 
 * Esta clase implementa los métodos abstractos de la clase DAOFatcory
 * gestionando de esta manera a través de esta clase el acceso a los DAOs que
 * persistiran la información en la base de datos.
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see DAOFactory
 * @version 1.0
 * 
 */
public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getPersonaDAO().createTable();		

	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JDBCPersonaDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new JDBCProductoDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		// TODO Auto-generated method stub
		return new JDBCEmpresaDAO();
	}

	@Override
	public PedidoCabeceraDAO getPedidoCabeceraDAO() {
		// TODO Auto-generated method stub
		return new JDBCPedidoCDAO();
	}
	
	@Override
	public PedidoDetalleDAO getPedidoDetalleDAO() {
		return new JDBCPedidoDetalle();
	}

}
