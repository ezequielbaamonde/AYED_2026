package ar.edu.unlp.info.oo1.semana7septiembre;

public class Item {
	private String detalle;
	private Integer cantidad;
	private double costoUnitario;
	
	public Item(String detalle, Integer cantidad, double costoUnitario){
		this.detalle= detalle;
		this.cantidad= cantidad;
		this.costoUnitario= costoUnitario;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}

	public double costo(){
		return (this.cantidad * this.costoUnitario);
	}
}
