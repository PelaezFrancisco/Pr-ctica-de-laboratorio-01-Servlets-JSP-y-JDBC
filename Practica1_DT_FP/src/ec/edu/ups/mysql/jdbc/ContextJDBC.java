package ec.edu.ups.mysql.jdbc;

import java.sql.DriverManager;
import java.sql.Statement;

import com.sun.jdi.connect.spi.Connection;

public class ContextJDBC {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/jee?serverTimezone=UTC";
	private static String USER = "root";
	//private static final String PASS = "DFTUrptu9799";
	private static final String PASS = "Patito.123@456";
	private static ContextJDBC jdbc1 = null;
	private Statement statement = null;
	
	Connection conexion = null;
	
	public ContextJDBC() {
		super();
	}
	protected static ContextJDBC  getJDBC1() {
		//Conexion con la Base de Datos
		if (jdbc1== null) {
			jdbc1 = new ContextJDBC();
		}
		return jdbc1;
		
	}
	/**
	 * 
	 * Metodo Connect 
	 * Conexion a la Base de Datos a traves de JDBC
	 * 
	 */
	public void connect() {
		try {
			Class.forName(DRIVER);
			//conexion = DriverManager.getConnection(URL,USER,PASS);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}