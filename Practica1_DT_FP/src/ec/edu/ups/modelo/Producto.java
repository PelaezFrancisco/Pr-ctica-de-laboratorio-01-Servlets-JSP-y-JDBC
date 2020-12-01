package ec.edu.ups.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int productoId;
    private String productoNombre;
    private String productoDescripcion; 
    private int productoStock;
    private double productoPrecioVenta;
    private String productoImagen;
    private Categoria categoria;
    private Empresa empresa;
    private int cat_id;
    private int emp_id;
    
    

	public Producto() {
		
		// TODO Auto-generated constructor stub
	}
    public Producto(int productoId, String productoNombre, String productoDescripcion, int productoStock, double productoPrecioVenta, String productoImagen, int cat_id, int emp_id) {
		this.setProductoId(productoId);
		this.setProductoNombre(productoNombre);
		this.setProductoDescripcion(productoDescripcion);
		this.setProductoStock(productoStock);
		this.setProductoPrecioVenta(productoPrecioVenta);
		this.setProductoImagen(productoImagen);
		this.setCat_id(cat_id);
		this.setEmp_id(emp_id);
	}
	
	public int getProductoId() {
		return productoId;
	}
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	public String getProductoDescripcion() {
		return productoDescripcion;
	}
	public void setProductoDescripcion(String productoDescripcion) {
		this.productoDescripcion = productoDescripcion;
	}
	public int getProductoStock() {
		return productoStock;
	}
	public void setProductoStock(int productoStock) {
		this.productoStock = productoStock;
	}
	public double getProductoPrecioVenta() {
		return productoPrecioVenta;
	}
	public void setProductoPrecioVenta(double productoPrecioVenta) {
		this.productoPrecioVenta = productoPrecioVenta;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getProductoImagen() {
		return productoImagen;
	}
	public void setProductoImagen(String productoImagen) {
		this.productoImagen = productoImagen;
	}
	
	
    
}
