package ec.edu.ups.modelo;

import java.io.Serializable;

public class PedidoDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedidoDetalleId;
    private int pedidoDetalleCantidad;
    private double pedidoDetallePrecioUnitario;
    private double pedidoDetalleSubtotal;
    private Producto producto;
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
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    

}
