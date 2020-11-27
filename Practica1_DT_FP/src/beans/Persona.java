package beans;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cedula;

	//Constructor Vacio
	public Persona() {
		
	}
	
	public Persona(String nombre, String cedula) {
		this.setNombre(nombre);
		this.setCedula(cedula);
	}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
