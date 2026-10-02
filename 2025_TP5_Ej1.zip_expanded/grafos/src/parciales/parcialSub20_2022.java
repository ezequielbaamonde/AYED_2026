package parciales;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class parcialSub20_2022 {
	
	public List<Informacion> resolver(Graph<String> sitios, String origen,
											String destino, List<String> evitarPasarPor){
		List<Informacion> caminos = new LinkedList<>();
		if (sitios == null || sitios.isEmpty()) {
			return caminos;
		}
		Vertex<String> ini = sitios.search(origen);
		Vertex<String> fin = sitios.search(destino);
		if (ini == null || fin == null) {
			return caminos;
		}
		boolean[] visitados = new boolean[sitios.getSize()];
		List<String> camino = new LinkedList<>();
		dfsResolver(sitios, ini, fin, evitarPasarPor, caminos, camino, visitados, 0);
		return caminos;
	}
	public void dfsResolver(Graph<String> sitios, Vertex<String> actual, Vertex<String> destino,
							List<String> evitarPasarPor, List<Informacion> caminos, List<String>
							caminoAct, boolean[] visitados, int cuadras) {
		if(!evitarPasarPor.contains(actual.getData())) {
			visitados[actual.getPosition()] = true;
			caminoAct.add(actual.getData());
			if(actual == destino) {
				List<String> caminoValido = new LinkedList<>(caminoAct);
				caminos.add(new Informacion(caminoValido, cuadras));
			}else{
				for(Edge<String> ady : sitios.getEdges(actual)) {
					Vertex<String> vecino = ady.getTarget();
					if(!visitados[vecino.getPosition()]) {
						dfsResolver(sitios, vecino, destino, evitarPasarPor, caminos, caminoAct,
									visitados, (cuadras + ady.getWeight()));
					}
				}
			}
			visitados[actual.getPosition()] = false;
			caminoAct.remove(caminoAct.size() - 1);
		}
	}
}
