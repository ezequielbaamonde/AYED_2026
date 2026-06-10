package Parciales;

public class ParcialArbolesCuatro {
	private BinaryTree<Integer> ab;
	
	public ParcialArbolesCuatro(BinaryTree<Integer> arbolBinario) {
		this.ab = arbolBinario;
	}
	
	public boolean isTwoTree(int num) {
		boolean res = false;
		if (this.ab != null && !this.ab.isEmpty()) {
			res = evaluarAB(this.ab, num);
		}
		return res;
	}
	
	private boolean evaluarAB(BinaryTree<Integer> a, int num) {
		BinaryTree<Integer> aux;
		boolean cumple = false;
		aux = buscarNodo(a, num);
		if (aux != null) {
			int cantidadHijosIzq = -1;
			int cantidadHijosDer = -1; 
			if (aux.hasLeftChild()) {
				cantidadHijosIzq = recorrerSubArbol(aux.getLeftChild());
			}
			if (aux.hasRightChild()) {
				cantidadHijosDer = recorrerSubArbol(aux.getRightChild());
			}
			cumple = (cantidadHijosIzq == cantidadHijosDer);
		}
		return cumple;
	}
	
	private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> a, int num){
		BinaryTree<Integer> nodo;
		nodo = null;
		if (a.getData().equals(num)) {
			nodo = a;
		}else {
			if(a.hasLeftChild()) {
				nodo = buscarNodo(a.getLeftChild(), num);
			}
			
			if (nodo == null && a.hasRightChild()) {
				nodo = buscarNodo(a.getRightChild(), num);
			}
		}
		return nodo;
	}
	
	private int recorrerSubArbol(BinaryTree<Integer> a) {
		int cantNodos = 0;
		int izq = 0;
		int der = 0;
		if (a.hasLeftChild() && a.hasRightChild()) {
			cantNodos++;
		}
		if(a.hasLeftChild()) {
			izq = recorrerSubArbol(a.getLeftChild());
		}
		if(a.hasRightChild()) {
			der = recorrerSubArbol(a.getRightChild());
		}
		return cantNodos + izq + der;
	}
}