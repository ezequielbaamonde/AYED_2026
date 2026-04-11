package tp2;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	
	public BinaryTree<Integer> suma(){
		if (!this.arbol.isEmpty() && this.arbol != null){
			sumatoria(this.arbol);
		}
		return arbol;
	}
	
	private int sumatoria(BinaryTree<Integer> nodo){
		int sumaIzquierda = 0;
		int sumaDerecha = 0;
		
		//Bajamos hasta las hojas en PostOrden (De hijo izquierdo a derecho, a raíz)
		if (nodo.hasLeftChild()) sumaIzquierda = sumatoria(nodo.getLeftChild());
		if (nodo.hasRightChild()) sumaDerecha = sumatoria(nodo.getRightChild());
		
		//Guardo valor original para avisarle al padre cuánto sume en total
		int valorOriginal = nodo.getData();
		
		nodo.setData(sumaIzquierda + sumaDerecha);
		return valorOriginal + nodo.getData();
		
	}
}
