package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Empresa;

public interface GenericDAO <T, ID>{
	
	public List <Empresa> find();

}
