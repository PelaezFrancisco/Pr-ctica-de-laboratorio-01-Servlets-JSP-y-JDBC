package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;

public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer, String> implements ProductoDAO {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Producto producto) {
		// TODO Auto-generated method stub
		try {
			conexion.update("INSERT GES_Productos VALUES (" + producto.getProductoId() + ", '" + producto.getProductoNombre() + "', '" 
					+producto.getProductoDescripcion() + "',"+producto.getProductoStock()+ ", " 
					+producto.getProductoPrecioVenta()+ ", " +producto.getCat_id()+ ", " 
					+producto.getEmp_id()+ ")");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error crear producto");
		}
		
	}
	
	@Override
	public Producto read(Integer id) {
		Producto producto = null;
		Categoria categoria= null;
		Empresa empresa = null;
		ResultSet rs = conexion.query("SELECT * FROM GES_Productos WHERE pro_id="+id);
		try {
			if (rs != null && rs.next()) {
				producto= new Producto();
				
				
			}
		} catch (Exception e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return producto;
	}

	@Override
	public void update(Producto producto) {
		conexion.update("UPDATE GES_Productos SET pro_nombre = '" + producto.getProductoNombre() + "', pro_descripcion = '" + producto.getProductoDescripcion()
		+ "', pro_stock = " + producto.getProductoStock()+ ", pro_precioV = " + producto.getProductoPrecioVenta()
		+ ", cat_id = " + producto.getCat_id() + ", emp_id = " + producto.getEmp_id()
		+ " WHERE pro_id = " + producto.getProductoId());
		
	}

	@Override
	public void delete(Producto producto) {
		conexion.update("DELETE FROM GES_Productos WHERE pro_id= "+producto.getProductoId());
		
	}

	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs= conexion.query("SELECT * FROM GES_Productos");
		try {
			while(rs.next()) {
				list.add(new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getString("pro_descripcion"),
						rs.getInt("pro_stock"), rs.getDouble("pro_precioV"),rs.getInt("cat_id"), rs.getInt("emp_id")));
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public Producto find_email(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Producto> ProEmpPer() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs= conexion.query("select  * from GES_Productos pro ,GES_Empresas e, GES_Personas per  Where pro.emp_id = e.emp_id AND per.emp_id = e.emp_id");
		try {
			while(rs.next()) {
				list.add(new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getString("pro_descripcion"),
						rs.getInt("pro_stock"), rs.getDouble("pro_precioV"),rs.getInt("cat_id"), rs.getInt("emp_id")));
			}
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

	

}
