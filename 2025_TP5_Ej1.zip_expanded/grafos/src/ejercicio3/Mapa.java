package ejercicio3;
import java.util.*;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	private Graph<String> mapaCiudades;
	public Mapa(Graph<String> map) {
		this.mapaCiudades = map;
		
	}

	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<>();
		if (this.mapaCiudades == null || this.mapaCiudades.isEmpty()) {
			return camino;
		}
		//Almaceno los vértices a buscar
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen == null || destino == null) {
			return camino;
		}
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		dfsCamino(origen, destino, visitados, camino);
		return camino;
	}
	
	private boolean dfsCamino(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> camino) {
		visitados[origen.getPosition()] = true; //Marco true como visitado el origen
		camino.add(origen.getData()); //Añado el dato del vértice al camino
		if (origen == destino) { //Encontre mi destino
			return true;
		}
		//Analizo adyacencias
		for (Edge<String> ady : this.mapaCiudades.getEdges(origen)) {
			 Vertex<String> ver = ady.getTarget();
			 if (!visitados[ver.getPosition()]) {
				 if (dfsCamino(ver, destino, visitados, camino)){
					 return true;
				 }
			 }
		}
		camino.remove(camino.size()-1);
		return false;
	}
}
