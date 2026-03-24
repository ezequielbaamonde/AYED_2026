package tp1.ejercicio5;

public class Estadistica {
	int max;
    int min;
    double promedio;

    // Constructor para asignar los valores fácilmente
    public Estadistica(int min, int max, double promedio) {
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
    
}
