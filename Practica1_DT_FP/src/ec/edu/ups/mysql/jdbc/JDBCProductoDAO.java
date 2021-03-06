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
			conexion.update("INSERT GES_Productos VALUES ( default " + ", '" + producto.getProductoNombre() + "', '" 
					+producto.getProductoDescripcion() + "',"+producto.getProductoStock()+ ", " 
					+producto.getProductoPrecioVenta()+ ", " +producto.getCat_id()+ ", " 
					+producto.getEmp_id()+", '"+producto.getProductoImagen()+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error crear producto");
		}
		
	}
	
	@Override
	public Producto read(Integer id) {
		Producto producto = null;
		
		ResultSet rs = conexion.query("SELECT * FROM GES_Productos WHERE pro_id="+id);
		System.out.println(id);
		try {
			if (rs != null && rs.next()) {
				producto= new Producto(rs.getInt("pro_id"),rs.getString("pro_nombre"),rs.getString("pro_descripcion"),
						rs.getInt("pro_stock"),rs.getDouble("pro_precioV"),rs.getString("pro_imagen"),rs.getInt("cat_id"),rs.getInt("emp_id"));
				System.out.println(rs.getString("pro_nombre"));
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return producto;
	}

	@Override
	public Producto read2(String nombre) {
		
		Producto producto = null;
		
		ResultSet rs = conexion.query("SELECT * FROM GES_Productos WHERE pro_nombre='"+nombre+"'");
		System.out.println(nombre);
		try {
			
			if (rs != null && rs.next()) {
				
				producto= new Producto(rs.getInt("pro_id"),rs.getString("pro_nombre"),rs.getString("pro_descripcion"),
						rs.getInt("pro_stock"),rs.getDouble("pro_precioV"),rs.getString("pro_imagen"),rs.getInt("cat_id"),rs.getInt("emp_id"));
			System.out.println(rs.getString("pro_nombre"));	
			}
		} catch (Exception e) {
			e.getStackTrace();
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
		System.out.println("Se elimino el producto");
	}

	@Override
	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs= conexion.query("SELECT * FROM GES_Productos");
		try {
			while(rs.next()) {
				list.add(new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getString("pro_descripcion"),
						rs.getInt("pro_stock"), rs.getDouble("pro_precioV"), rs.getString("pro_imagen"),rs.getInt("cat_id"), rs.getInt("emp_id")));
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
	public ArrayList<Producto> ProEmpPer(int id) {
		ArrayList<Producto> list = new ArrayList<Producto>();
		ResultSet rs = null;

		try {

			rs = conexion.query("SELECT * from ges_personas p, ges_empresas e, ges_productos pro where p.per_id="+ id+ " and p.emp_id=e.emp_id And pro.emp_id= e.emp_id");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {	
			while(rs.next()){
				Producto pro = new Producto();
				pro.setProductoId(rs.getInt("pro_id"));
				pro.setProductoNombre(rs.getString("pro_nombre"));
				pro.setProductoDescripcion(rs.getString("pro_descripcion"));
				pro.setProductoPrecioVenta(rs.getDouble("pro_precioV"));
				pro.setProductoStock(rs.getInt("pro_stock"));
				pro.setCat_id(rs.getInt("cat_id"));
				pro.setProductoImagen(rs.getString("pro_imagen"));
				pro.setEmp_id(rs.getInt("emp_id"));
				
				System.out.println("Producto de compra= "+rs.getString("pro_nombre"));
				list.add(pro);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Producto> busqueda(String nombre) {
		List<Producto> productoB = new ArrayList<Producto>();
		ResultSet rs=conexion.query("SELECT * FROM GES_Productos WHERE pro_nombre='"+nombre+"'");
		System.out.println(nombre);
		try {
			if (rs != null && rs.next()) {
				Producto producto = new Producto();
				producto.setProductoId(rs.getInt("pro_id"));
				producto.setProductoNombre(rs.getString("pro_nombre"));
				producto.setProductoDescripcion(rs.getString("pro_descripcion"));
				producto.setProductoStock(rs.getInt("pro_stock"));
				producto.setProductoPrecioVenta(rs.getDouble("pro_precioV"));
				producto.setCat_id(rs.getInt("cat_id"));
				producto.setEmp_id(rs.getInt("emp_id"));
				productoB.add(producto);
			System.out.println(rs.getString("pro_nombre"));	
			}else {
				System.out.println("No se encontro el producto");
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return productoB;
	}

	@Override
	public ArrayList<Producto> lista(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
