package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		String sentencia = "INSERT INTO GES_Pedido_Cabeceras VALUES(default, '"+entity.getPedidoCabeceraFecha()
		+"',"+entity.getPedidoCabeceraSubtotal()+","+entity.getPedidoCabeceraIva()+","+entity.getPedidoCabeceraDescuento()
		+","+entity.getPedidoCabeceraTotal()+",'P',"+entity.getPedidoCabeceraPerI()+")";
		conexion.update(sentencia);
		
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
				pedidoCab.setPedidoCabeceraFecha(rs.getDate("ped_fecha").toString());
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

	/*REGRESA EL ULTIMO PEDIDO CABECERA*/
	@Override
	public PedidoCabecera read2(String nombre) {
		PedidoCabecera cab = new PedidoCabecera();
		ResultSet rs= conexion.query("select MAX(ped_numeroP) from GES_Pedido_Cabeceras");
		try {
			if (rs.next()) {
				//System.out.println("Entra a read2 if");
				cab.setPedidoCabeceraNumero(rs.getInt("MAX(ped_numeroP)"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cab;
	}

	@Override
	public List<PedidoCabecera> busqueda(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoCabecera> ProEmpPer(int ID) {
		
		List<PedidoCabecera>pedidoT =new ArrayList<PedidoCabecera>();
		
				ResultSet rs= conexion.query("select * from ges_pedido_cabeceras pc, ges_pedido_detalles pd, ges_productos pro, ges_empresas emp  where pd.ped_numeroP = pc.ped_numeroP and pd.pro_id= pro.pro_id and pro.emp_id ="+ ID+" and   emp.emp_id= "+ID);
		try {
			while(rs.next()) {
				PedidoCabecera pedidoCab = new PedidoCabecera();
				pedidoCab.setPedidoCabeceraNumero(rs.getInt("ped_numeroP"));
				pedidoCab.setPedidoCabeceraFecha(rs.getDate("ped_fecha").toString());
				pedidoCab.setPedidoCabeceraSubtotal(rs.getDouble("ped_subtotal"));
				pedidoCab.setPedidoCabeceraIva(rs.getDouble("ped_iva"));
				pedidoCab.setPedidoCabeceraDescuento(rs.getDouble("ped_descuento"));
				pedidoCab.setPedidoCabeceraEstado(rs.getString("ped_estado").charAt(0));
				pedidoCab.setPedidoCabeceraPerI(rs.getInt("per_id"));
				pedidoT.add(pedidoCab);
				}
		} catch (Exception e) {
			System.out.println(">>>Error a listar ");
		}
		return pedidoT;
	}

	@Override
	public ArrayList<Producto> lista(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
