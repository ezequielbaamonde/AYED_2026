package ar.edu.unlp.info.oo1.ejercicio11_oo1;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta(double monto) {
		this.saldo = monto;
	}
	
	public Cuenta() {
		this.saldo = 0;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double monto) {
		this.saldo+= monto;
	}
	
	protected void extraerSinControlar (double monto) {
		this.saldo-= monto;
	}
	
	
	public boolean extraer(double monto) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}
	
	//Completar en subclases
	protected abstract boolean puedeExtraer(double monto);
	
	
	
	
	
	
}
