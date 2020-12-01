package ec.edu.ups.modelo;

import java.util.Date;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.*;

public class PedidoCabecera implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int pedidoCabeceraNumero;
    private LocalDateTime pedidoCabeceraFecha;
    private double pedidoCabeceraSubtotal;
    private double pedidoCabeceraIva;
    private double pedidoCabeceraDescuento;
    private double pedidoCabeceraTotal;
    private char pedidoCabeceraEstado;
    private int pedidoCabeceraPerI;
    
	private Persona persona;
    private List<PedidoDetalle> pedidoDetalle = new ArrayList<>();
    
    
	public PedidoCabecera() {
		
	}
	public PedidoCabecera(int numP, LocalDateTime fecha, double subtotal, double iva, double desc, double total, char estado, int perId ) {
		this.setPedidoCabeceraNumero(numP);
		this.setPedidoCabeceraFecha(fecha);
		this.setPedidoCabeceraSubtotal(subtotal);
		this.setPedidoCabeceraIva(iva);
		this.setPedidoCabeceraDescuento(desc);
		this.setPedidoCabeceraTotal(total);
		this.setPedidoCabeceraEstado(estado);
		this.setPedidoCabeceraPerI(perId);
	}
	public int getPedidoCabeceraNumero() {
		return pedidoCabeceraNumero;
	}
	public void setPedidoCabeceraNumero(int pedidoCabeceraNumero) {
		this.pedidoCabeceraNumero = pedidoCabeceraNumero;
	}
	public LocalDateTime getPedidoCabeceraFecha() {
		return pedidoCabeceraFecha;
	}
	public void setPedidoCabeceraFecha(LocalDateTime pedidoCabeceraFecha) {
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
	public char getPedidoCabeceraEstado() {
		return pedidoCabeceraEstado;
	}
	public void setPedidoCabeceraEstado(char pedidoCabeceraEstado) {
		this.pedidoCabeceraEstado = pedidoCabeceraEstado;
	}
	public int getPedidoCabeceraPerI() {
		return pedidoCabeceraPerI;
	}
	public void setPedidoCabeceraPerI(int pedidoCabeceraPerI) {
		this.pedidoCabeceraPerI = pedidoCabeceraPerI;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
