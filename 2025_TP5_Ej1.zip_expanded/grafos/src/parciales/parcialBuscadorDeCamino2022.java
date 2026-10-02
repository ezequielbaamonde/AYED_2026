package parciales;
import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class parcialBuscadorDeCamino2022 {
	
	public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino,
											 int montoMinimo){
		List<String> camino = new LinkedList<>();
		if (ciudades == null || ciudades.isEmpty()) {
			return camino;
		}
		Vertex<String> ini = ciudades.search(origen);
		Vertex<String> fin = ciudades.search(destino);
		if (ini == null || fin == null) {
			return camino;
		}
		boolean visitados[] = new boolean[ciudades.getSize()];
		dfsCamino(ciudades, ini, fin, visitados, camino, montoMinimo, 0);
		
		return camino;
	}
	private boolean dfsCamino(Graph<String> ciudades, Vertex<String> actual, Vertex<String> destino,
							 boolean[] visitados, List<String> caminoAct, int montoMin, int acumulador){
		visitados[actual.getPosition()] = true;
		caminoAct.add(actual.getData());
		if(actual == destino) {
			if (acumulador > montoMin) {
				return true;
			}
		}else {
			for (Edge<String> ady : ciudades.getEdges(actual)) {
				Vertex<String> w = ady.getTarget();
				if(!visitados[w.getPosition()]) {
					if (dfsCamino(ciudades, w, destino, visitados, caminoAct, montoMin, (acumulador+ady.getWeight()))) {
						return true;
					}
				}
			}
		}
		visitados[actual.getPosition()] = false;
		caminoAct.remove(caminoAct.size() - 1); 
		return false;
	}
		
		
		
	
}
