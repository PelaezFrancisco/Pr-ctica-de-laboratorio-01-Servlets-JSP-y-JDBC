package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Empresa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer> implements EmpresaDAO{

	@Override
	public List<Empresa> find() {
		List<Empresa> list = new ArrayList<Empresa>();
		ResultSet rs = conexion.query("SELECT * FROM Ges_Empresa");
		try {
			while (rs.next()) {
				list.add(new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("ruc"),
						rs.getString("direccion"),rs.getString("telefono"),rs.getString("emailn")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
}
