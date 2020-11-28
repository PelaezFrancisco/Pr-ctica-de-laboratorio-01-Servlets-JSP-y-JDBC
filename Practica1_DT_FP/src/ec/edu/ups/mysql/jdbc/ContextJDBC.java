package ec.edu.ups.mysql.jdbc;

import java.sql.*;

public class ContextJDBC {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/jee?serverTimezone=UTC";
	private static String USER = "root";
	//private static final String PASS = "DFTUrptu9799";
	private static final String PASS = "Patito.123@456";
	
	//Solo Cambia la contrasena
	//private static final String PASS = "";
	private static ContextJDBC jdbc1 = null;
	private Statement statement = null;
	
	Connection conexion = null;
	
	public ContextJDBC() {
		try {
			this.connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo getJDBC
	 * Obtiene una conexion activa a la Base De Datos
	 */
	protected static ContextJDBC getJDBC1() {
		//Creacion de la conexion a la Base de datos solo si no ha sido creada patron de diseño singleton
		if (jdbc1 == null) {
			jdbc1 = new ContextJDBC();
		}
		return jdbc1;
	}
	/**
	 * 
	 * Metodo Connect 
	 * Conexion a la Base de Datos a traves de JDBC
	 * @throws SQLException 
	 * 
	 */
	public void connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVER);
			//conexion = DriverManager.getConnection(URL,USER,PASS);
			
		} catch (Exception e) {
			// TODO: handle exception
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
			System.out.println("Conexion Exitosa");
		}
	}
	
	/**
	 * Metodo Query
	 * Realiza la sentencia de Select a la Base de datos
	 */
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): ---" + sql + "---" + e);
		}
		return null;
	}
	
}