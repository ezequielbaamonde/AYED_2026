package tp1.ejercicio5;

public class ej5 {
	//Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
	//en un único método. Escriba tres métodos de clase, donde respectivamente:
	//	a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
	//	b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
	//	tipo arreglo).
	//	c. Devuelva lo pedido sin usar parámetros ni la sentencia "return"
	
	public static Estadistica opReturn(int[] arreglo) {
		int max = -1;
		int min = 9999999;
		int suma = 0;
		
		for (int num: arreglo) {
			if (num > max) {
				max= num;
			}
			if (num < min) {
				min = num;
			}
			suma += num;
		}
		double promedio = (double) suma / arreglo.length;
		
		return new Estadistica(min, max, promedio);
	}
	
	//C.
	public static void sinReturn(int[] arreglo) {
		int max = -1;
		int min = 9999999;
		int suma = 0;
		
		for(int num: arreglo) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			suma += num;
		}
		System.out.println("Número máximo: " + max);
		System.out.println("Número mínimo: " + min);
		double promedio = (double) suma / arreglo.length;
		System.out.println("Promedio del arreglo: " + promedio);
		
	}
	
	
	public static void main(String[] args) {
		int[] arreglo = {1, 2, 3};
		
		//A.
		Estadistica res1 = opReturn(arreglo);
	    System.out.println("Resultados del Arreglo A:");
	    System.out.println("Mínimo: " + res1.getMin());
	    System.out.println("Máximo: " + res1.getMax());
	    System.out.println("Promedio: " + res1.getPromedio());
	    
	    System.out.println("-------------------------------");
	    
	    //B.
	    
	    
	    System.out.println("-------------------------------");
	    //C
	    System.out.println("Resultados del Arreglo C:");
	    sinReturn(arreglo);
	    
	}

}
