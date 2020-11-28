package ec.edu.ups.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private char rol;
	private String telefono;
	private String direccion;
	private String email;
	private String contrasena;
	
	public Persona() {
		// Constructor obligatorio
	} 

	public Persona(int id, String cedula, String nombre, String apellido ,String telefono, String direccion, String email, String contrasena) { 
		// Constructor opcional
		this.setId(id);
		this.setCedula(cedula);
		this.setNombre(nombre);
		this.setApellido(apellido);
		//this.setRol(rol);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
		this.setEmail(email);
		this.setContrasena(contrasena);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

