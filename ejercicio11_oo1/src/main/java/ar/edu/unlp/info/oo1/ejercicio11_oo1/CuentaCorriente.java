package ar.edu.unlp.info.oo1.ejercicio11_oo1;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente() {
		this.descubierto = 0;
	}
	
	public boolean puedeExtraer(double monto) {
		return (monto <= this.getSaldo() + this.getDescubierto());
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
}
