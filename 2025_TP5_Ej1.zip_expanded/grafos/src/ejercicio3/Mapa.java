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
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<>();
		if (this.mapaCiudades == null || this.mapaCiudades.isEmpty()) {
			return camino;
		}
		//Almaceno los vértices a buscar
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen == null || ciudades.contains(origen.getData()) || destino == null || ciudades.contains(destino.getData())) {
			return camino;
		}
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		
		dfsCaminoExcepto(origen, destino, visitados, camino, ciudades);
		
		return camino;
	}
	
	private boolean dfsCaminoExcepto(Vertex<String> origen, Vertex<String> destino, boolean[] visitados,
			List<String> camino, List<String> ciudades) {
		visitados[origen.getPosition()] = true; //Marco true como visitado el origen
		camino.add(origen.getData()); //Añado el dato del vértice al camino
		if (origen == destino) { //Encontre mi destino
			return true;
		}
		//Analizo adyacencias
		for (Edge<String> ady : this.mapaCiudades.getEdges(origen)) {
			 Vertex<String> ver = ady.getTarget();
			 //Evaluo que no se haya visitado el vértice y que no esté contenido en la lista
			 //de ciudades prohibidas
			 if (!visitados[ver.getPosition()] && !ciudades.contains(ver.getData())) {
				 if (dfsCaminoExcepto(ver, destino, visitados, camino, ciudades)){
					 return true;
				 }
			 }
		}
		camino.remove(camino.size()-1);
		return false;
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> mejorCamino = new LinkedList<>();
		if (this.mapaCiudades == null || this.mapaCiudades.isEmpty()) {
			return mejorCamino;
		}
		//Almaceno los vértices a buscar
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		
		if (origen == null || destino == null) {
			return mejorCamino;
		}
		
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		
		List<String> caminoActual = new LinkedList<>();
		Minimo distMin = new Minimo(Integer.MAX_VALUE);
		
		dfsMasCorto(origen, destino, visitados, caminoActual, mejorCamino, 0, distMin);
		
		return mejorCamino;
	}
	
	private void dfsMasCorto(Vertex<String> origen, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> mejorCamino, Integer distActual, Minimo distMin){
		
		visitados[origen.getPosition()] = true; //Marco true como visitado el origen
		caminoActual.add(origen.getData()); //Añado el dato del vértice al camino
		
		if (origen == destino) { //Encontre mi destino
			if (distActual < distMin.getMin()) {
				distMin.setMin(distActual);
				mejorCamino.clear();
				mejorCamino.addAll(caminoActual);
			}
		}else {
			//Analizo adyacencias
			for (Edge<String> ady : this.mapaCiudades.getEdges(origen)) {
				 Vertex<String> ver = ady.getTarget();
				 //Evaluo que no se haya visitado el vértice y que no esté contenido en la lista
				 //de ciudades prohibidas
				 if (!visitados[ver.getPosition()]) {
					 dfsMasCorto(ver, destino, visitados, caminoActual, mejorCamino, (distActual + ady.getWeight()), distMin);		 
				 }
			}
		}
		visitados[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> lisCiudades = new LinkedList<>();
		if (this.mapaCiudades == null || this.mapaCiudades.isEmpty()) {
			return lisCiudades;
		}
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if (origen == null || destino == null) {
			return lisCiudades;
		}
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		dfsCaminoSinCombustible(origen, destino, tanqueAuto, visitados, lisCiudades);
		return lisCiudades;
	}
	
	private boolean dfsCaminoSinCombustible(Vertex<String> origen, Vertex<String> destino,
											int tanqueAuto, boolean[] visitados, List<String> ciudades){
		visitados[origen.getPosition()] = true; //Marco true como visitado el origen
		ciudades.add(origen.getData());
		if(origen == destino) {
			return true;
		}else{
			//Analizo adyacencias
			for (Edge<String> ady : this.mapaCiudades.getEdges(origen)) {
				 Vertex<String> ver = ady.getTarget(); //guardo arista
				 if (!visitados[ver.getPosition()] && (ady.getWeight() <= tanqueAuto)) {
					 if (dfsCaminoSinCombustible(ver, destino, (tanqueAuto - ady.getWeight()), visitados, ciudades)){
						 return true;
					 }
				 }
			}
		}
		visitados[origen.getPosition()] = false;
		ciudades.remove(ciudades.size()-1);
		return false;
	}
	
	public List<String> caminoConMenorCargasDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> mejorCamino = new LinkedList<>();
		if (this.mapaCiudades == null || this.mapaCiudades.isEmpty()) {
			return mejorCamino;
		}
		//Almaceno los vértices a buscar
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		
		if (origen == null || destino == null) {
			return mejorCamino;
		}
		
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		
		List<String> caminoActual = new LinkedList<>();
		Minimo minCargas = new Minimo(Integer.MAX_VALUE);
		//tanqueAuto(1) es la capacidadMax del tanque, el (2) es el combustibleActual
		dfsConMenosCargas(origen, destino, tanqueAuto, tanqueAuto,
						  visitados, caminoActual, mejorCamino, 0, 
						  minCargas);
		
		return mejorCamino;
	}
	
	private void dfsConMenosCargas(Vertex<String> origen, Vertex<String> destino, int tanqueAuto, int combustibleActual,
									boolean[] visitados, List<String> caminoAct, List<String> mejorCamino,
									int cantCargas, Minimo minCargas) {
		
		visitados[origen.getPosition()] = true; //Marco true como visitado el origen
		caminoAct.add(origen.getData()); //Añado el dato del vértice al camino
		
		if (cantCargas < minCargas.getMin()) { //Si aún es menor, exploro esta rama. Sino, la ignoro
			if (origen == destino) {
				minCargas.setMin(cantCargas);
				mejorCamino.clear();
				mejorCamino.addAll(caminoAct);
			}else{ //Si no es destino
				//Analizo adyacencias
				for (Edge<String> ady : this.mapaCiudades.getEdges(origen)) {
					Vertex<String> ver = ady.getTarget();
					//Si no visitamos esa ciudad y la distancia es menor a mi tanque de auto (no me quedo sin nafta en la ruta)
					if (!visitados[ver.getPosition()] && (ady.getWeight() <= tanqueAuto)) {
						if (combustibleActual >= ady.getWeight()) { //Llego al prox destino con mi nafta
							dfsConMenosCargas(ver, destino, tanqueAuto, (combustibleActual - ady.getWeight()),visitados, caminoAct,
									mejorCamino, cantCargas, minCargas);	
						}else { //Debo cargar antes de salir al prox destino (combustibleActual ahora carga lo necesario para recorrer la ruta)
							dfsConMenosCargas(ver, destino, tanqueAuto, (tanqueAuto - ady.getWeight()),visitados, caminoAct,
						 		   mejorCamino, (cantCargas+1), minCargas);	
						}
					 	 
					}
				}
			}
		}
		visitados[origen.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
	}
}
