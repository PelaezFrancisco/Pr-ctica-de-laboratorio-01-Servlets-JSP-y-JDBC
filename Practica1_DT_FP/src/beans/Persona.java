package beans;

import java.io.Serializable;

public class Persona implements Serializable{

	
	//Constructor Vacio
	public Persona() {
		
	}
	
	private String nombre;

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
