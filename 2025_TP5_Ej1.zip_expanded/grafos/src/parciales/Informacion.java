package parciales;

import java.util.List;

public class Informacion {
	private List<String> recorridos;
	private int cuadras;
	
	
	public Informacion(List<String> recorridos, int cuadras) {
		this.recorridos = recorridos;
		this.cuadras = cuadras;
	}


	public List<String> getRecorridos() {
		return recorridos;
	}


	public void setRecorridos(List<String> recorridos) {
		this.recorridos = recorridos;
	}


	public int getCuadras() {
		return cuadras;
	}


	public void setCuadras(int cuadras) {
		this.cuadras = cuadras;
	}

	
	
}
