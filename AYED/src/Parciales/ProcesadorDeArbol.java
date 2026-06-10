package Parciales;

public class ProcesadorDeArbol {
	private BinaryTree<Integer> ab;

	public Valores procesar() {
		Valores v = new Valores();
		if (this.ab != null && !this.ab.isEmpty()) {
			recorrer(this.ab, v);
		}
		return v;
	}
	
	private void recorrer(BinaryTree<Integer> a, Valores v) {
		if(a.hasLeftChild()) {
			recorrer(a.getLeftChild(), v);
		}
		if(a.hasRightChild()) {
			recorrer(a.getRightChild(), v);
		}
		//Si tiene un único hijo, debo luego validar que el dato sea impar
		if (a.getData()%2 != 0){
			v.setCantImpar(v.getCantImpar() + 1);
			if((a.hasLeftChild() && !a.hasRightChild()) || (a.hasRightChild() && !a.hasLeftChild())) {
				v.getLista().add(a.getData());
			}
		}
	}
}
