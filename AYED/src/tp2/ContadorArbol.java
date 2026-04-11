package tp2;
import java.util.*;

public class ContadorArbol{
	private BinaryTree<Integer> arbol;
	
	public List<Integer> numerosParesA() {
		List<Integer> pares = new ArrayList<>();
		
		// Si no hay árbol, devuelvo la lista vacía
	    if (this.arbol == null || this.arbol.isEmpty()) {
	        return pares; 
	    }
		inOrden(this.arbol, pares);
		return pares;
	}
	
	public List<Integer> numerosParesB() {
		List<Integer> paresB = new ArrayList<>();
		
		// Si no hay árbol, devuelvo la lista vacía
	    if (this.arbol == null || this.arbol.isEmpty()) {
	        return paresB; 
	    }
		postOrden(this.arbol, paresB);
		return paresB;
	}
	
	private void inOrden(BinaryTree<Integer> arbol, List<Integer> lista){
		//Caso base
		if (arbol == null) return;
		if (arbol.hasLeftChild()) inOrden(arbol.getLeftChild(), lista);
		if (arbol.getData() % 2 == 0) lista.add(arbol.getData());
		if (arbol.hasRightChild()) inOrden(arbol.getRightChild(), lista);
	}
	
	private void postOrden(BinaryTree<Integer> arbol, List<Integer> lista){
		//Caso base
		if (arbol == null) return;
		if (arbol.hasLeftChild()) postOrden(arbol.getLeftChild(), lista);
		if (arbol.hasRightChild()) postOrden(arbol.getRightChild(), lista);
		if (arbol.getData() % 2 == 0) lista.add(arbol.getData());
	}
	
}
