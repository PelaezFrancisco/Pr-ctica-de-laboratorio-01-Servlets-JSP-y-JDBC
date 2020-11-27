package ec.edu.ups.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int productoId;
    private String productoNombre;
    private String productoDescripcion; 
    private int productoStock;
    private double productoPrecioVenta;
    private Categoria categoria;
    
    public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
    public Producto(int productoId, String productoNommbre, String productoDescripcion, int productoStock, double productoPrecioVenta) {
		this.productoId=productoId;
		this.productoNombre=productoNommbre;
		this.productoDescripcion=productoDescripcion;
		this.productoStock= productoStock;
		this.productoPrecioVenta=productoPrecioVenta;	
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
}
