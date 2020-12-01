package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;


public class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer, String> implements EmpresaDAO{

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Empresa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa read(Integer id) {
		Empresa empresa = null;
		ArrayList<Categoria> categorias = new ArrayList();
		ArrayList<Producto> productos = new ArrayList();
		ArrayList<Persona> personas = new ArrayList();
		
		
		//QUERY PARA PERSONAS
		ResultSet rs_3 = conexion.query("SELECT * from GES_Personas pe, GES_Empresas em "
				+ "WHERE pe.emp_id ="+id+" AND em.emp_id="+id);
		/*
		 * EJECUCION DE QUERY PERSONA SE GUARDA EL OBJETO PERSONA
		 */
		try {
			if (rs_3 != null && rs_3.next()) {
				Persona persona_aux = new Persona();
				persona_aux.setId(rs_3.getInt("per_id"));
				persona_aux.setNombre(rs_3.getString("per_nombre"));
				persona_aux.setApellido(rs_3.getString("per_apellido"));
				persona_aux.setRol(rs_3.getString("per_rol").charAt(0));
				persona_aux.setCedula(rs_3.getString("per_cedula"));
				persona_aux.setDireccion(rs_3.getString("per_direccion"));
				persona_aux.setEmail(rs_3.getString("per_email"));
				persona_aux.setTelefono(rs_3.getString("per_telefono"));
				//Se guarda en el arraylist
				personas.add(persona_aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>>ERROR EN EL QUERY DE PERSONA");
		}finally {
			try {
				rs_3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*
		 * EJECUCION DE QUERY CATEGORIA SE GUARDA EL OBJETO CATEGRIA
		 * sacamos todas las categorias existentes para hacer la comparacion
		 * en la consulta de producto
		 */
		//QUERY PARA CATEGORIAS
		ResultSet rs_2 = conexion.query("SELECT * from GES_CATEGORIAS");
		try {
			if (rs_2 != null && rs_2.next()) {
				Categoria categoria_aux = new Categoria();
				categoria_aux.setCategoriaId(rs_2.getInt("cat_id"));
				categoria_aux.setCategoriaNombre(rs_2.getString("cat_nombre"));
				categoria_aux.setCategoriaDescripcion(rs_2.getString("cat_descripcion"));
				
				//Se guarda en el arraylist
				categorias.add(categoria_aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>ERROR EN QUERY A CATEGORIAS");
		}finally {
			try {
				rs_2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * EJECUCION DE QUERY PRODUCTO SE GUARDA EL OBJETO PRODUCTO
		 */
		
		//QUERY PARA PRODUCTOS
		ResultSet rs_1 = conexion.query("SELECT * from GES_Productos pr, GES_Empresas em "
				+ "WHERE pr.emp_id ="+id+" AND em.emp_id="+id);
		try {
			if (rs_1 != null && rs_1.next()) {
				Producto producto_aux = new Producto();
				producto_aux.setProductoId(rs_1.getInt("pro_id"));
				producto_aux.setProductoNombre(rs_1.getString("pro_nombre"));
				producto_aux.setProductoDescripcion(rs_1.getString("pro_descripcion"));
				producto_aux.setProductoPrecioVenta(rs_1.getDouble("pro_precioV"));
				producto_aux.setProductoStock(rs_1.getInt("pro_stock"));
				int idcat=rs_1.getInt("cat_id");
				
				//Para capturar la categoria id
				for (int i = 0; i < categorias.size(); i++) {
					if (categorias.get(i).getCategoriaId()==idcat) {
						producto_aux.setCategoria(categorias.get(i));
					}
				}
				//Se guarda en el arraylist
				productos.add(producto_aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>ERROR EN QUERY A PRODUCTOS");
		}finally {
			try {
				rs_1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * EJECUCION DE QURY EMPRESA SE GUARDA EL OBJETO EMPRESA
		 */
		//QUERY PARA EMPRESAS
		ResultSet rs = conexion.query("SELECT * FROM GES_Empresas WHERE emp_id=" + id);
		try {
			if (rs != null && rs.next()) {
				empresa = new Empresa();
				empresa.setEmpresaId(rs.getInt("emp_id"));
				empresa.setEmpresaNombre(rs.getString("emp_nombre"));
				empresa.setEmpresaRuc(rs.getString("emp_ruc"));
				empresa.setEmpresaDireccion(rs.getString("emp_direccion"));
				empresa.setEmpresaTelefono(rs.getString("emp_telefono"));
				empresa.setEmpresaEmail(rs.getString("emp_email"));
				empresa.setProducto(productos);
				empresa.setPersona(personas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(">>>ERROR EN QUERY A EMPRESAS");
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return empresa;
	}

	@Override
	public void update(Empresa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empresa entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empresa> find() {
		List<Empresa> list = new ArrayList<Empresa>();
		Empresa empresa;
		ResultSet rs = conexion.query("SELECT * FROM GES_Empresas");
		try {
			if (rs != null && rs.next()) {
				empresa = new Empresa();
				empresa.setEmpresaId(rs.getInt("emp_id"));
				empresa.setEmpresaNombre(rs.getString("emp_nombre"));
				empresa.setEmpresaRuc(rs.getString("emp_ruc"));
				empresa.setEmpresaDireccion(rs.getString("emp_direccion"));
				empresa.setEmpresaTelefono(rs.getString("emp_telefono"));
				empresa.setEmpresaEmail(rs.getString("emp_email"));
				empresa.setProducto(null);
				empresa.setPersona(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(">>>ERROR EN QUERY A EMPRESAS");
		}
		return list;
	}

	@Override
	public Empresa find_email(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> ProEmpPer() {
		// TODO Auto-generated method stub
		return null;
	}

}
