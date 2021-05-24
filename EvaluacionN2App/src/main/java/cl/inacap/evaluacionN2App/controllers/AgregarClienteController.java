package cl.inacap.evaluacionN2App.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AgregarClienteController
 */
@WebServlet("/AgregarClienteController.do")
public class AgregarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientesDAOLocal clientesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/vistas/agregarCliente.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<>();
		
		boolean tipo = true;

		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			
			errores.add("ingrese rut");
			
		}else if (validarRut(rut) == false) {
			
			errores.add("rut no valido");
		}
		
		String nombre = request.getParameter("nombre-txt").trim();
		
		if (nombre.isEmpty() ) {
			errores.add("ingrese nombre");
			
		} else if (validarNombre(nombre) == false) {
			errores.add("nombre no valido");
		}
			
		String solicitud = request.getParameter("tipo-select").trim();
		
		if (solicitud == "Retiro de cedula de identidad") {
			
		}
		
		if (errores.isEmpty()) {
			
			
			
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setRut(rut);
			cliente.setTipo_solicitud(solicitud);
			clientesDAO.save(cliente);
			
			//response.sendRedirect("VerClienteController.do");
			
			
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}
	
	
	
	public static boolean validarNombre(String nombre) {
		
		boolean validacion = false;
		
		boolean espacio=nombre.contains(" ");
		
		boolean mayuscula =Character.isUpperCase(nombre.charAt(0));
		
		int largo = nombre.length();
		
		boolean minimo = largo >5;
		
		validacion = ((espacio= true) && (espacio && mayuscula && minimo));
		
		return validacion;
	}
	
	
	
	
	public static boolean validarRut (String rut) {
		boolean validacion = false;
		
		try {
		rut =  rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }
		}catch (java.lang.NumberFormatException e) {
		}catch (Exception e) {
		}
		
		return validacion;
	}
	
	
	
	
	

}
