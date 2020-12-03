package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.Producto;

public class JDBCPedidoDetalle extends JDBCGenericDAO<PedidoDetalle, Integer, String> implements PedidoDetalleDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(PedidoDetalle entity) {
		String sentencia = "INSERT INTO GES_Pedido_Detalles VALUES(default, "+entity.getPedidoDetalleCantidad()+
				" ,"+entity.getPedidoDetallePrecioUnitario()+","+entity.getPedidoDetalleSubtotal()+
				", "+entity.getPro_id()+","+entity.getPed_id()+")";
		conexion.update(sentencia);
	}

	@Override
	public PedidoDetalle read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PedidoDetalle entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PedidoDetalle entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PedidoDetalle> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDetalle find_email(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDetalle read2(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDetalle> busqueda(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDetalle> ProEmpPer(int ID) {
		List<PedidoDetalle>pedidoD = new ArrayList<PedidoDetalle>();
		ResultSet rs= conexion.query("select * from ges_pedido_detalles pde where pde.ped_numeroP="+ID);
		try {
			while(rs.next()) {
				PedidoDetalle pedidoDet = new PedidoDetalle();
				pedidoDet.setPedidoDetalleId(rs.getInt("pde_id"));
				pedidoDet.setPedidoDetalleCantidad(rs.getInt("pde_cantidad"));
				pedidoDet.setPedidoDetallePrecioUnitario(rs.getDouble("pde_precioU"));
				pedidoDet.setPedidoDetalleSubtotal(rs.getDouble("pde_subtotal"));
				pedidoDet.setPro_id(rs.getInt("pro_id"));
				pedidoDet.setPed_id(rs.getInt("ped_numeroP"));
				pedidoD.add(pedidoDet);
				}
		} catch (Exception e) {
			System.out.println("Erros al listar ");
			e.printStackTrace();
		}
		return pedidoD;
	}

	@Override
	public ArrayList<Producto> lista(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
