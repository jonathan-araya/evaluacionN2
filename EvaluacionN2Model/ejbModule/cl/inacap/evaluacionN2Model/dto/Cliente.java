package cl.inacap.evaluacionN2Model.dto;

public class Cliente {
	private String rut;
	private String nombre;
	private String tipo_solicitud;
	
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo_solicitud() {
		return tipo_solicitud;
	}
	public void setTipo_solicitud(String tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	} 

}
