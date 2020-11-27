package ec.edu.ups.modelo;

import java.util.Date;
import java.io.Serializable;
import java.util.*;

public class PedidoCabecera implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedidoCabeceraNumero;
    private Date pedidoCabeceraFecha;
    private double pedidoCabeceraSubtotal;
    private double pedidoCabeceraIva;
    private double pedidoCabeceraDescuento;
    private double pedidoCabeceraTotal;
    private String pedidoCabeceraEstado;
    private Persona persona;
    private List<PedidoDetalle> pedidoDetalle = new ArrayList<>();
    
	public int getPedidoCabeceraNumero() {
		return pedidoCabeceraNumero;
	}
	public void setPedidoCabeceraNumero(int pedidoCabeceraNumero) {
		this.pedidoCabeceraNumero = pedidoCabeceraNumero;
	}
	public Date getPedidoCabeceraFecha() {
		return pedidoCabeceraFecha;
	}
	public void setPedidoCabeceraFecha(Date pedidoCabeceraFecha) {
		this.pedidoCabeceraFecha = pedidoCabeceraFecha;
	}
	public double getPedidoCabeceraSubtotal() {
		return pedidoCabeceraSubtotal;
	}
	public void setPedidoCabeceraSubtotal(double pedidoCabeceraSubtotal) {
		this.pedidoCabeceraSubtotal = pedidoCabeceraSubtotal;
	}
	public double getPedidoCabeceraIva() {
		return pedidoCabeceraIva;
	}
	public void setPedidoCabeceraIva(double pedidoCabeceraIva) {
		this.pedidoCabeceraIva = pedidoCabeceraIva;
	}
	public double getPedidoCabeceraDescuento() {
		return pedidoCabeceraDescuento;
	}
	public void setPedidoCabeceraDescuento(double pedidoCabeceraDescuento) {
		this.pedidoCabeceraDescuento = pedidoCabeceraDescuento;
	}
	public double getPedidoCabeceraTotal() {
		return pedidoCabeceraTotal;
	}
	public void setPedidoCabeceraTotal(double pedidoCabeceraTotal) {
		this.pedidoCabeceraTotal = pedidoCabeceraTotal;
	}
	public String getPedidoCabeceraEstado() {
		return pedidoCabeceraEstado;
	}
	public void setPedidoCabeceraEstado(String pedidoCabeceraEstado) {
		this.pedidoCabeceraEstado = pedidoCabeceraEstado;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<PedidoDetalle> getPedidoDetalle() {
		return pedidoDetalle;
	}
	public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}
}
