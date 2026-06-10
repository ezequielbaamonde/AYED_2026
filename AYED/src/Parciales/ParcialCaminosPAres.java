package Parciales;
import java.util.*;
public class ParcialCaminosPAres {
	public List<Integer> resolver(BinaryTree<Integer> ab, int min){
		List<Integer> camino = new LinkedList<Integer>();
		Cumple c = new Cumple();
		c.setC(false);
		if (ab  != null && !ab.isEmpty()) {
			buscarCamino(ab, min, camino, 0, c);
		}
		return camino;
	}
	
	private void buscarCamino(BinaryTree<Integer> a, int min, List<Integer> camino, int pares, Cumple cumple) {
		camino.add(a.getData());
		if (a.getData() % 2 == 0) {
			pares++;
		}
		
		if(a.isLeaf() && pares >= min) {
			cumple.setC(true);
		}
		
		if(!cumple.isC() && a.hasLeftChild()) {
			buscarCamino(a.getLeftChild(), min, camino, pares, cumple);
		}
		
		if (!cumple.isC() && a.hasRightChild()) {
				buscarCamino(a.getRightChild(), min, camino, pares, cumple);
		}
		//BackTracking
		if (!cumple.isC()) {
			camino.removeLast();
		}

		
	}
	
}
