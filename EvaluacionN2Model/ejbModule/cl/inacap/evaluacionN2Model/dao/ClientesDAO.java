package cl.inacap.evaluacionN2Model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.evaluacionN2Model.dto.Cliente;

/**
 * Session Bean implementation class ClientesDAO
 */
@Stateless
@LocalBean
public class ClientesDAO implements ClientesDAOLocal {
	
	List<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Default constructor. 
     */
    public ClientesDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		clientes.add(cliente);
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return clientes;
	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub
		clientes.remove(cliente);
		
	}

	@Override
	public List<Cliente> filterByName(String nombre) {
		
		List<Cliente> aux = new ArrayList<>();
		for(Cliente c: clientes) {
			if (c.getNombre().contains(nombre)) {
				aux.add(c);
			}
		}
			
		
		return aux;
	}

}
