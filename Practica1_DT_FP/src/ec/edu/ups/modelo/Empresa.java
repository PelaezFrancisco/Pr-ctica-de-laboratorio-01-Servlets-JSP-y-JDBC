package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int empresaId;
	private String empresaNombre;
	private String empresaRuc;
	private String empresaDireccion;
	private String empresaTelefono;
	private String empresaEmail;
	private List<Producto> producto = new ArrayList<>();
	private List<Persona> persona = new ArrayList<>();
	
	
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empresa(int empresaId, String empresaNombre,String empresaRuc,String empresaDireccion,String empresaTelefono,String empresaEmail) {
		this.empresaId=empresaId;
		this.empresaNombre=empresaNombre;
		this.empresaRuc=empresaRuc;
		this.empresaDireccion=empresaDireccion;
		this.empresaTelefono=empresaTelefono;
		this.empresaEmail=empresaEmail;
	}
	
	public int getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
	public String getEmpresaNombre() {
		return empresaNombre;
	}
	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}
	public String getEmpresaRuc() {
		return empresaRuc;
	}
	public void setEmpresaRuc(String empresaRuc) {
		this.empresaRuc = empresaRuc;
	}
	public String getEmpresaDireccion() {
		return empresaDireccion;
	}
	public void setEmpresaDireccion(String empresaDireccion) {
		this.empresaDireccion = empresaDireccion;
	}
	public String getEmpresaTelefono() {
		return empresaTelefono;
	}
	public void setEmpresaTelefono(String empresaTelefono) {
		this.empresaTelefono = empresaTelefono;
	}
	public String getEmpresaEmail() {
		return empresaEmail;
	}
	public void setEmpresaEmail(String empresaEmail) {
		this.empresaEmail = empresaEmail;
	}
	public List<Producto> getProducto() {
		return producto;
	}
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	public List<Persona> getPersona() {
		return persona;
	}
	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Empresa [empresaId=" + empresaId + ", empresaNombre=" + empresaNombre + ", empresaRuc=" + empresaRuc
				+ ", empresaDireccion=" + empresaDireccion + ", empresaTelefono=" + empresaTelefono + ", empresaEmail="
				+ empresaEmail + ", producto=" + producto + ", persona=" + persona + "]";
	}
	
	
}
