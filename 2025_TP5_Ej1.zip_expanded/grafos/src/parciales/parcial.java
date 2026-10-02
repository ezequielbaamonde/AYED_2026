package parciales;
import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class parcial {
	
	public List<String> resolver(Graph<String> ciudades, String origen, String destino,
								 List<String> pasandoPor){
		List<String> camino = new LinkedList<>();
		if (ciudades == null || ciudades.isEmpty()) {
			return camino;
		}
		Vertex<String> inicio = ciudades.search(origen);
		Vertex<String> fin = ciudades.search(destino);
		if(inicio == null || fin == null) {
			return camino;
		}
			
		boolean[] visitados = new boolean[ciudades.getSize()];
		dfsResolver(ciudades, inicio, fin, pasandoPor, visitados, camino, 0);
		return camino;
	}
	
	private boolean dfsResolver(Graph<String> ciudades, Vertex<String> actual,
								Vertex<String> destino, List<String> pasandoPor,
								boolean[] visitados, List<String> caminoAct, int pasePor) {
		caminoAct.add(actual.getData());
		visitados[actual.getPosition()] = true;
		
		//Corroboro si el vertice actual es obligatorio pasar por el
		//Si es así, lo contabilizo
	    if (pasandoPor.contains(actual.getData())) {
	        pasePor++;
	    }
		
		if (actual == destino) {
			if (pasePor == pasandoPor.size()) {
				return true;
			}
		}else{
			for(Edge<String> ady : ciudades.getEdges(actual)) {
				Vertex<String> vecino = ady.getTarget();
				if(!visitados[vecino.getPosition()]) { //Si no visite esa ciudad
					if(dfsResolver(ciudades, vecino, destino, pasandoPor, visitados, caminoAct, pasePor)) {
						return true;
					}
				}
			}
		}
		visitados[actual.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
		return false; 
	}
}
