package ejercicio5;

public class Persona {
	private String nombre;
	private boolean jubilado; //Empleado o Jubilado
	private String domicilio;
	private boolean cobroJubilacion;
	
	
	public Persona() {
	}
	
	public Persona(String nombre, String domicilio, boolean jubilado, boolean cobro) {
		this.nombre = nombre;
		this.jubilado = jubilado;
		this.domicilio = domicilio;
		this.cobroJubilacion = cobro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean esJubilado() {
		return jubilado;
	}

	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public boolean haCobrado() {
		return cobroJubilacion;
	}

	public void setCobroJubilacion(boolean cobroJubilacion) {
		this.cobroJubilacion = cobroJubilacion;
	}

	
}
