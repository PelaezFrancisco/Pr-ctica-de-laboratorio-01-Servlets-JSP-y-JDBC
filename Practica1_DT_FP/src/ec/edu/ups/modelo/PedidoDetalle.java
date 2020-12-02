package ec.edu.ups.modelo;

import java.io.Serializable;

public class PedidoDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedidoDetalleId;
    private int pedidoDetalleCantidad;
    private double pedidoDetallePrecioUnitario;
    private double pedidoDetalleSubtotal;
    private int pro_id;
    private int ped_id;
    private Producto producto;
    
    
    
	public PedidoDetalle() {
	}
	public PedidoDetalle(int id, int cant, double precioU, double subtotal, int pro_id, int ped_id) {
		this.setPedidoDetalleId(id);
		this.setPedidoDetalleCantidad(cant);
		this.setPedidoDetallePrecioUnitario(precioU);
		this.setPedidoDetalleSubtotal(subtotal);
		this.setPro_id(pro_id);
		this.setPed_id(ped_id);
	}
	public int getPedidoDetalleId() {
		return pedidoDetalleId;
	}
	public void setPedidoDetalleId(int pedidoDetalleId) {
		this.pedidoDetalleId = pedidoDetalleId;
	}
	public int getPedidoDetalleCantidad() {
		return pedidoDetalleCantidad;
	}
	public void setPedidoDetalleCantidad(int pedidoDetalleCantidad) {
		this.pedidoDetalleCantidad = pedidoDetalleCantidad;
	}
	public double getPedidoDetallePrecioUnitario() {
		return pedidoDetallePrecioUnitario;
	}
	public void setPedidoDetallePrecioUnitario(double pedidoDetallePrecioUnitario) {
		this.pedidoDetallePrecioUnitario = pedidoDetallePrecioUnitario;
	}
	public double getPedidoDetalleSubtotal() {
		return pedidoDetalleSubtotal;
	}
	public void setPedidoDetalleSubtotal(double pedidoDetalleSubtotal) {
		this.pedidoDetalleSubtotal = pedidoDetalleSubtotal;
	}
	
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getPed_id() {
		return ped_id;
	}
	public void setPed_id(int ped_id) {
		this.ped_id = ped_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    

}
