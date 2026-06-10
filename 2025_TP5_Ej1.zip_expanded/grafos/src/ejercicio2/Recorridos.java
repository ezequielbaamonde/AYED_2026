package ejercicio2;
import java.util.*;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Recorridos{
	
	public <T> List<T> dfs(Graph<T> grafo){
		List<T> lista= new LinkedList<>();
		if (grafo == null || grafo.isEmpty()){
			return lista;
		}
		boolean[] visitados = new boolean[grafo.getSize()];
		
		for (Vertex<T> v: grafo.getVertices()) {
			if (!visitados[v.getPosition()]) {
				dfs(v, grafo, visitados, lista);
			}
		}
		
		
		return lista;
	}
	
	private <T> void dfs(Vertex<T> v, Graph<T> grafo, boolean[] visitados, List<T> lista) {
		visitados[v.getPosition()] = true; //Marcamos vértice visitado
		lista.add(v.getData()); //Añadimos valor del vértice
		//recorremos adyacentes del vértice
		for (Edge<T> ady : grafo.getEdges(v)) {
			Vertex<T> destino = ady.getTarget(); //Obtengo el vértice destino de mi vértice inicial
			if (!visitados[destino.getPosition()]) { //Si el vértice no fue visitado
				dfs(destino, grafo, visitados, lista); //Llamo recursivamente al método
			}
		}
	}
	
	public <T> List<T> bfs(Graph<T> grafo){
		List<T> lista = new LinkedList<>();
		if (grafo == null || grafo.isEmpty()){
			return lista;
		}
		
		boolean[] visitados = new boolean[grafo.getSize()];
		
		for (Vertex<T> v: grafo.getVertices()) {
			if (!visitados[v.getPosition()]) {
				bfs(v, grafo, visitados, lista);
			}
		}
		return lista;
	}
	
	private <T> void bfs(Vertex<T> origen, Graph<T> grafo, boolean[] visitados, List<T> lista){
		Queue<Vertex<T>> cola = new Queue<>();
		visitados[origen.getPosition()] = true;
		cola.enqueue(origen);
		
		while (!cola.isEmpty()) {
			Vertex<T> vActual = cola.dequeue(); //Desencolamos vértice a procesar
			lista.add(vActual.getData()); //Armamos el camino BFS
			
			//Encolamos adyacentes de vActual
			for (Edge<T> ady : grafo.getEdges(vActual)) {
				Vertex<T> destino = ady.getTarget(); //Obtiene los vertices destinos al que apunta
				if (!visitados[destino.getPosition()]) { //Si el vértice no fue visitado
					/*La idea es evitar que el mismo vértice sea encolado varias veces si dos
					vértices distintos apuntan a él.*/
					visitados[destino.getPosition()] = true; //Marcamos el destino adyacente como visitado
					cola.enqueue(destino);
				}
			}
		}
	}


}
