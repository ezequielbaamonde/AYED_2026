package tp3;
import java.util.*;
public class Caminos {
	private GeneralTree<Integer> arbol;
	
	
	public List<Integer> caminoAHojaMasLejana(){
		if (arbol != null && !arbol.isEmpty()) {
			return obtenerMax(arbol);
		}
		return null;
	}
	
	private List<Integer> obtenerMax(GeneralTree<Integer> a){
		//Recorrido preOrden
		//Caso Base: Si es hoja, creo una lista con el dato y la "mando para arriba" en la recursión
		if (a.isLeaf()) {
			List<Integer> hoja = new LinkedList<>();
			hoja.add(a.getData());
			return hoja;
		}
		//Caso recursivo
		List<Integer> caminoMax = null;
		int maxCam = -1;
		for (GeneralTree<Integer> hijo : a.getChildren()) {
			List<Integer> caminoHijo = obtenerMax(hijo);
			if (caminoHijo.size() > maxCam) {
				maxCam = caminoHijo.size();
				caminoMax = caminoHijo;
			}
		}
		// Antes de devolver la lista ganadora a mi padre, me agrego yo al principio
		if (caminoMax != null) {
				caminoMax.add(0, a.getData());
		}
		return caminoMax;
	}
}
