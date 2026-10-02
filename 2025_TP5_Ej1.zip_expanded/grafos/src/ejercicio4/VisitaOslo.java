package ejercicio4;
import java.util.*;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
									List<String> lugaresRestringidos){
		List<String> paseo = new LinkedList<>();
		if (lugares == null || lugares.isEmpty()) {
			return paseo;
		}
		
		//Asumo que existe el origen y destino
		Vertex<String> origen = lugares.search("Ayuntamiento"); //Buscamos el origen
		Vertex<String> fin = lugares.search(destino); 
		boolean visitado[] = new boolean[lugares.getSize()];
		dfsPaseoEnBici(origen, fin, paseo, maxTiempo, 0, lugaresRestringidos, visitado, lugares);
		return paseo;
	}
	
	public Boolean dfsPaseoEnBici(Vertex<String> actual, Vertex<String> destino, List<String> camino,
								  int max, int tiempoAct, List<String> lugaresRestringidos, boolean[] visitado,
								  Graph<String> lugares) {
		
		visitado[actual.getPosition()]=true;
		camino.add(actual.getData());
		
		if (tiempoAct <= max) {
			if (actual == destino) {
				return true;
			}
			else {
				for (Edge<String> ady : lugares.getEdges(actual)) {
					Vertex<String> vecino = ady.getTarget();
					
					if(!visitado[vecino.getPosition()] && !lugaresRestringidos.contains(vecino.getData())){
						
						if ((tiempoAct + ady.getWeight()) < max) {
							
							if(dfsPaseoEnBici(vecino, destino, camino, max, (tiempoAct + ady.getWeight()),
											lugaresRestringidos, visitado, lugares)) {
								return true;
							}
						}
					}
				}
			}
		}
		visitado[actual.getPosition()] = false;
		camino.remove(camino.size()-1);
		return false;
	}
}
