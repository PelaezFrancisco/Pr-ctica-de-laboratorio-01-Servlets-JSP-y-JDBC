package ec.edu.ups.modelo;

import java.io.Serializable;

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private int categoriaId;
	private String categoriaNombre;
	private String categoriaDescripcion;
	
	public Categoria() {
		
		// TODO Auto-generated constructor stub
	}
	public Categoria(int categoriaId, String categoriaNombre, String categoriaDescripcion ) {
		this.categoriaId=categoriaId;
		this.categoriaNombre= categoriaNombre;
		this.categoriaDescripcion= categoriaDescripcion;
		
		// TODO Auto-generated constructor stub
	}
	
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoriaNombre() {
		return categoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	public String getCategoriaDescripcion() {
		return categoriaDescripcion;
	}
	public void setCategoriaDescripcion(String categoriaDescripcion) {
		this.categoriaDescripcion = categoriaDescripcion;
	}
	
	
}
	
