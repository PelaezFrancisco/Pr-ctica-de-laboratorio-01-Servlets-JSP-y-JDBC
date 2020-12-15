package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.modelo.PedidoCabecera;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;


public interface GenericDAO<T, ID, EMAIL> {

	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();

	public T find_email(EMAIL email);

	public T  read2(String nombre);

	public List<T> busqueda(String nombre);

	public List<T> ProEmpPer(int ID);

	public ArrayList<Producto> lista(int id);
	
	

}
