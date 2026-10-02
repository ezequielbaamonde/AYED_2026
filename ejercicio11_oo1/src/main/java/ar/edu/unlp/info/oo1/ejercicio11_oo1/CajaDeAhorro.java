package ar.edu.unlp.info.oo1.ejercicio11_oo1;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro(double monto) {
		super(monto);
		
	}
	
	protected boolean puedeExtraer(double monto) {
		if (this.getSaldo() >= (monto+((monto*2)/100))) {
			return true;
		}
		return false;
	}
	
	protected void extraerSinControlar (double monto) {
		super.extraerSinControlar(monto*1.02);
	}
	
	public void depositar(double monto) {
		super.depositar(monto-(monto*0.02));
	}
}
