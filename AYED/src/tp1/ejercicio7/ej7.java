package practica1;
import java.util.*;
//import java.util.iterable

public class ej7 {
	/*c. Si, también existe el ITERATOR para ArrayList...
		- Iterator<Integer> it = lista.iterator();
	*/
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
	    //Verificación de seguridad y casos base (0 o 1 elemento)
	    if (lista == null || lista.size() <= 1) {
	        return true; 
	    }

	    int inicio = 0;
	    int fin = lista.size() - 1;

	    //Comparamos los extremos hacia el centro
	    while (inicio < fin) {
	        //Al ser Integer (objeto), usamos .equals()
	    	
	        if (!lista.get(inicio).equals(lista.get(fin))) {
	            return false; // Encontró una diferencia, no es capicúa
	        }
	        
	        inicio++;
	        fin--;
	    }

	    // Si terminó el ciclo, es porque todos coincidieron
	    return true;
	}
	
	public static void imprimir(ArrayList<Estudiante> lista) {
		for(Estudiante e: lista) {
			System.out.println(e.getNombre());
		}
	}
	
	public static void genLista() {
		Estudiante e1 = new Estudiante("23364/4", "Ezequiel", "Baamonde", 45782596, "eze@gmail.com");
		Estudiante e2 = new Estudiante("23364/5", "Tomas", "Baamonde", 45782597, "tomas@gmail.com");
		Estudiante e3 = new Estudiante("23364/6", "Raul", "Gutierrez", 45782598, "raul@gmail.com");
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(e3);
		estudiantes.add(e1);
		estudiantes.add(e2);
		ArrayList<Estudiante> estudiantes_copia = new ArrayList<>(estudiantes);
		
		System.out.println("Impresión de lista original: ");
		/*for(Estudiante e: estudiantes) {
			System.out.println(e.getNombre());
		}*/
		imprimir(estudiantes);
		System.out.println("----------------------------");
		System.out.println("Impresión de la copia: ");
		/*for(Estudiante c: estudiantes_copia) {
			System.out.println(c.getNombre());
		}*/
		imprimir(estudiantes_copia);
		
		e1.setNombre("Fabricio");
		System.out.println("----------------------------");
		System.out.println("Re-Impresión de la original: ");
		imprimir(estudiantes);
		System.out.println("----------------------------");
		System.out.println("Re-Impresión de la copia: ");
		imprimir(estudiantes_copia);
		
		//-------------------------------------------------
		Estudiante e4 = new Estudiante("23364/6", "Raul", "Gutierrez", 45782598, "raul@gmail.com");
		if (estudiantes.contains(e4)) {
			System.out.println("El alumno " + e4.getNombre() + " ya existe en la lista :)");
		}else{
			estudiantes.add(e4);
		}
		//-------------------------------------------------
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 1));
		boolean resultado = esCapicua(numeros);
		System.out.println("¿La lista es capicua?: " + resultado);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lista = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese números (0 para finalizar): ");
		int num = s.nextInt();
		while (num != 0) {
			lista.add(num);
			num = s.nextInt();
		}
		s.close();
		System.out.println("Iterando sobre la lista 1...");
		for (int e: lista) {
			System.out.println(e);
		}
		System.out.println("------------------------------");
		genLista();
	}

}
