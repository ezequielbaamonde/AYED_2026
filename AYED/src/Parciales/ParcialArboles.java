package Parciales;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
		if (this.arbol != null && !this.arbol.isEmpty()) {
			nuevoArbol.setData(this.arbol.getData());
			construirArbol(this.arbol, nuevoArbol);
		}
		return nuevoArbol;
	}
	
	private void construirArbol(BinaryTree<Integer> a, BinaryTree<Integer> aNuevo) {
		if(a.hasLeftChild()) {
			BinaryTree<Integer> nodoIzq = new BinaryTree<Integer>();
			//Seteo nuevo valor
			nodoIzq.setData(aNuevo.getData() + a.getLeftChild().getData());
			aNuevo.addLeftChild(nodoIzq);
			construirArbol(a.getLeftChild(), aNuevo.getLeftChild());
		}
		
		if(a.hasRightChild()) {
			BinaryTree<Integer> nodoDer = new BinaryTree<Integer>();
			nodoDer.setData(a.getRightChild().getData());
			aNuevo.addRightChild(nodoDer); //Mismo valor en hijo derecho
			construirArbol(a.getRightChild(), aNuevo.getRightChild());
		}
	}
}
