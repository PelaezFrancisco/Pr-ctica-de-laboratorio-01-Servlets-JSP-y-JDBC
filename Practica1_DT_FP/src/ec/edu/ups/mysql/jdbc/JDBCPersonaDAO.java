package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.modelo.Persona;

/**
 * Clase JDBCPersonaDAO.
 * 
 * La clase JDBCPersonaDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface PersonaDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo Persona
 * 
 * @author Gabriel A. León Paredes Doctor en Tecnologías de Información
 *         https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCGenericDAO
 * @see PersonaDAO
 * @see Persona
 * 
 * @version 1.0
 */
public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, Integer, String> implements PersonaDAO {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS GES_Personas");
		conexion.update("CREATE TABLE GES_Personas (" + "ID INT NOT NULL, " + "CEDULA VARCHAR(10), "
				+ "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255)" + ", PRIMARY KEY (ID))");
	}

	@Override
	public void create(Persona persona) {
		conexion.update("INSERT GES_Personas VALUES (" + persona.getId() + ", '" + persona.getCedula() + "', '"
				+ persona.getNombre() + "', '" + persona.getApellido() + "', '" + persona.getTelefono() + "', '" 
				+ persona.getDireccion() + "', '" + persona.getEmail() + "', '" + persona.getContrasena() + "')");
	}

	@Override
	public Persona read(Integer id) {
		Persona persona = null;
		ResultSet rs = conexion.query("SELECT * FROM GES_Personas WHERE per_id= " + id);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("per_id"), rs.getString("per_cedula"), rs.getString("per_nombre"),
						rs.getString("per_apellido"), rs.getString("per_rol").charAt(0), rs.getString("per_telefono"), rs.getString("per_direccion"),
						rs.getString("per_email"), rs.getString("per_telefono"));
				/*persona.setId(rs.getInt("per_id"));
				persona.setCedula( rs.getString("per_cedula"));	
				persona.setNombre(rs.getString("per_nombre"));
				persona.setApellido(rs.getString("per_apellido"));
				persona.setRol((rs.getString("per_rol").charAt(0)));
				persona.setTelefono(rs.getString("per_telefono"));
				persona.setDireccion(rs.getString("per_direccion"));
				persona.setEmail(rs.getString("per_email"));
				persona.setContrasena(rs.getString("per_contrasena"));*/
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return persona;
	}

	@Override
	public void update(Persona persona) {
		conexion.update("UPDATE GES_Personas SET per_cedula = '" + persona.getCedula() + "', per_nombre = '" + persona.getNombre()
									+ "', per_apellido = '" + persona.getApellido() + "', per_telefono = '" + persona.getTelefono()
									+ "', per_direccion = '" + persona.getDireccion() + "', per_email = '" + persona.getEmail()
									+ "' WHERE per_id = " + persona.getId());

	}

	@Override
	public void delete(Persona persona) {
		conexion.update("DELETE FROM GES_Personas WHERE per_id = " + persona.getId());

	}

	@Override
	public List<Persona> find() {
		List<Persona> list = new ArrayList<Persona>();
		ResultSet rs = conexion.query("SELECT * FROM GES_Personas");
		try {
			while (rs.next()) {
				/*list.add(new Persona(rs.getInt("per_id"), rs.getString("per_cedula"), rs.getString("per_nombre"),
						rs.getString("per_apellido"), rs.getString("per_telefono"), rs.getString("per_direccion"),
						rs.getString("per_email"), rs.getString("per_telefono")));*/
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	@Override
	public Persona find_email(String email) {
		Persona persona = null;
		ResultSet rs = conexion.query("SELECT * FROM GES_Personas WHERE per_email= \"" + email+"\"");
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("per_id"), rs.getString("per_cedula"), rs.getString("per_nombre"),
						rs.getString("per_apellido"), rs.getString("per_rol").charAt(0) , rs.getString("per_telefono"), rs.getString("per_direccion"),
						rs.getString("per_email"), rs.getString("per_telefono"));
				/*persona.setId(rs.getInt("per_id"));
				persona.setCedula( rs.getString("per_cedula"));	
				persona.setNombre(rs.getString("per_nombre"));
				persona.setApellido(rs.getString("per_apellido"));
				persona.setRol((rs.getString("per_rol").charAt(0)));
				persona.setTelefono(rs.getString("per_telefono"));
				persona.setDireccion(rs.getString("per_direccion"));
				persona.setEmail(rs.getString("per_email"));
				persona.setContrasena(rs.getString("per_contrasena"));*/
			}
		} catch (SQLException e) {
			System.out.println(">>>Error al buscar persona con mail "+ email + e.getMessage());
		}

		return persona;
	}

}
