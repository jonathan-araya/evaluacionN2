package cl.inacap.evaluacionN2App.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.evaluacionN2Model.dao.ClientesDAO;
import cl.inacap.evaluacionN2Model.dao.ClientesDAOLocal;
import cl.inacap.evaluacionN2Model.dto.Cliente;

/**
 * Servlet implementation class VerClienteController
 */
@WebServlet("/VerClienteController.do")
public class VerClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientesDAOLocal clientesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> clientes = clientesDAO.getAll();
		
		if (request.getParameter("nombreEliminar") != null) {
			String nombre = request.getParameter("nombreEliminar").trim();
			
			List<Cliente> busqueda = clientesDAO.filterByName(nombre);
			
			Cliente clienteEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if (clienteEliminar != null) {
				clientesDAO.delete(clienteEliminar);
			}
		}
		
		request.setAttribute("clientes", clientes);
		
		request.getRequestDispatcher("WEB-INF/vistas/verCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
