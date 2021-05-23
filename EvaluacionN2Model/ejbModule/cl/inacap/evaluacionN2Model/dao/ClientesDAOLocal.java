package cl.inacap.evaluacionN2Model.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.evaluacionN2Model.dto.Cliente;

@Local
public interface ClientesDAOLocal {
	
	void save(Cliente cliente);
	List<Cliente> getAll();
	void delete(Cliente cliente);
	List<Cliente> filterByName(String nombre);
}
