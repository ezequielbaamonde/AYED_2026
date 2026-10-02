package ejercicio6;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.*;
public class BuscadorDeCaminos {
	Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> grafo) {
		this.bosque = grafo;
	}
	
	public List<List<String>> recorridoMasSeguro(){
		List<List<String>> recorridos = new LinkedList<>();
		if (this.bosque == null || this.bosque.isEmpty()) {
			return recorridos;
		}
		Vertex<String> casaCaperucita = this.bosque.search("Casa Caperucita");
		Vertex<String> casaAbuelita = this.bosque.search("Casa Abuelita");
		boolean [] visitados = new boolean[this.bosque.getSize()];
		List<String> caminoActual = new LinkedList<>();
		//Lista de caminos, origen, destino
		dfsMasSeguro(recorridos, casaCaperucita, casaAbuelita,
					 visitados, caminoActual);
		return recorridos;
	}
	
	private void dfsMasSeguro(List<List<String>> recorridos, Vertex<String> actual,
							  Vertex<String> destino, boolean[] visitados, List<String> caminoAct) {
		visitados[actual.getPosition()] = true;
		caminoAct.add(actual.getData());
		if (actual == destino) {
			recorridos.add(new LinkedList<>(caminoAct));
		}else{
		//Analizamos adyacencias
		for(Edge<String> ady : this.bosque.getEdges(actual)) {
			Vertex<String> vecino = ady.getTarget();
			/*Si el nodo Vecino no está visitado y además es seguro su sendero */
			if (!visitados[vecino.getPosition()] && ady.getWeight() < 5) {
				dfsMasSeguro(recorridos, vecino, destino, visitados,caminoAct);
			}
		}
		}//Fin else
		visitados[actual.getPosition()] = false;
		caminoAct.remove(caminoAct.size() - 1);
	}
}
