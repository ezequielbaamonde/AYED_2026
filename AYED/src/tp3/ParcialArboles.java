package tp3;
import java.util.*;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
		if (arbol != null && !arbol.isEmpty()) {
			return evaluarArbol(arbol);
		}
		return false;
	}
	
	private static boolean evaluarArbol(GeneralTree<Integer> a) {
		if (a.isLeaf()) {
			return true;
		}
		
		int minimo = Integer.MAX_VALUE;
		//Debo recorrer el árbol en PostOrden, desde los hijos hasta el padre para evaluar primero cuál
		//es el mínimo valor y luego ver si el padre cumple con ese mínimo
		for (GeneralTree<Integer> hijo: a.getChildren()) {
			if (!evaluarArbol(hijo)){
				return false; //Si el hijo no cumple, el padre tampoco
			}
			//Mínimo valor entre los hijos
			if (hijo.getData() < minimo) {
				minimo = hijo.getData();
			}
		}
		//¿El dato del nodo es igual al mínimo de sus hijos?
		return a.getData().equals(minimo);
	}
	
	/*
	 * Punto 10, consultar... Similar al Ejercicio de AB en NOTION (Árboles Binarios -TP°2 🔢)*/
	public static List<Integer> resolverDiez(GeneralTree<Integer> arbol){
		List<Integer> camino = new LinkedList<Integer>();
		List<Integer> caminoAct = new LinkedList<Integer>();
		Maximo m = new Maximo(Integer.MIN_VALUE);
		if (arbol != null && !arbol.isEmpty()) {
			filtrado(arbol, camino, caminoAct, 0, 0, m);
		}
		return camino;
	}
	
	private static void filtrado(GeneralTree<Integer> a, List<Integer> res, List<Integer> act, int nivel, int suma, Maximo m){
		suma+= a.getData()*nivel;
		if(a.getData().equals(1)) {
			act.add(a.getData());
		}
		
		if(a.isLeaf()) {
			if( suma > m.getMax()) {
				m.setMax(suma);
				res.clear();
				res.addAll(act);
			}		
		}else {
			for(GeneralTree<Integer> hijo : a.getChildren()) {
				filtrado(hijo, res, act, (nivel+1), suma, m);
			}
		}
		
		// Elimino cada vez que hubo una carga en la lista.
		if (a.getData().equals(1)) {
			act.removeLast();
		}
	}
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if (arbol != null && !arbol.isEmpty()) {
			return esCreciente(arbol);
		}
		return false;
	}
	
	private static boolean esCreciente(GeneralTree<Integer> a) {
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		int cantNodosAct=0;
		int cantNodosAnt=0;
		cola.enqueue(a);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null){
				cantNodosAct++;
				if (aux.hasChildren()) {
					for (GeneralTree<Integer> hijo : aux.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}else{
				if (cantNodosAct != (cantNodosAnt + 1)){
					return false;
				}
				// Si validó bien, actualizamos el anterior para el próximo nivel
	            cantNodosAnt = cantNodosAct;
	            cantNodosAct = 0; // Reseteamos para el nuevo nivel
				//Marcamos nivel y reseteamos sumador
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return true; //Si terminamos es porque validamos todo el árbol
	}
	
}
