package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

public class JDBCPedidoCDAO extends JDBCGenericDAO<PedidoCabecera, Integer, String> implements PedidoCabeceraDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PedidoCabecera read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PedidoCabecera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PedidoCabecera> find() {
		List<PedidoCabecera>pedidoC =new ArrayList<PedidoCabecera>();
		Persona persona = new Persona();
		
				ResultSet rs= conexion.query("SELECT * FROM GES_Pedido_Cabeceras");
		try {
			while(rs.next()) {
				PedidoCabecera pedidoCab = new PedidoCabecera();
				pedidoCab.setPedidoCabeceraNumero(rs.getInt("ped_numeroP"));
				//pedidoCab.setPedidoCabeceraFecha(rs.getDate("ped_fecha"));
				pedidoCab.setPedidoCabeceraSubtotal(rs.getDouble("ped_subtotal"));
				pedidoCab.setPedidoCabeceraIva(rs.getDouble("ped_iva"));
				pedidoCab.setPedidoCabeceraDescuento(rs.getDouble("ped_descuento"));
				pedidoCab.setPedidoCabeceraEstado(rs.getString("ped_estado").charAt(0));
				pedidoCab.setPedidoCabeceraPerI(rs.getInt("per_id"));
				pedidoC.add(pedidoCab);
				}
		} catch (Exception e) {
			System.out.println(">>>Error a listar ");
		}
		return pedidoC;
	}

	@Override
	public PedidoCabecera find_email(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> ProEmpPer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoCabecera read2(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> busqueda(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}