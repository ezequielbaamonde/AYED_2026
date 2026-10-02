package ejercicio5;
import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import ejercicio2.Queue;

public class MirrorBank {
	
	public List<Persona> carteraJubilados(
	        Graph<Persona> grafo,
	        Persona empleado,
	        int distanciaMaxima) {
		
		//Lista de jubilados
	    List<Persona> jubilados = new LinkedList<>();

	    if (grafo == null || grafo.isEmpty()) {
	        return jubilados;
	    }
	    
	    //Buscamos al empleado
	    Vertex<Persona> origen = grafo.search(empleado);

	    if (origen == null) {
	        return jubilados;
	    }

	    boolean[] visitados = new boolean[grafo.getSize()];
	    
	    //BFS porque determinamos grados de separación.
	    //Inicializamos cola en 0 de distancia <Estado>
	    Queue<Estado> cola = new Queue<>();

	    cola.enqueue(new Estado(origen, 0));

	    visitados[origen.getPosition()] = true;
	    
	    //Nuestro corte de control sera si la cola está vacia o llegamos a 40 jubilados
	    while (!cola.isEmpty() && jubilados.size() < 40) {

	        Estado actual = cola.dequeue();

	        Persona persona = actual.vertice.getData();

	        if (persona.esJubilado() && !persona.haCobrado()) {
	            jubilados.add(persona); //Añadimos jubilado a la lista
	        }
	        
	        //Si se cumple, analizamos sus adyacencias
	        if (actual.distancia < distanciaMaxima) {

	            for (Edge<Persona> ady : grafo.getEdges(actual.vertice)) {

	                Vertex<Persona> vecino = ady.getTarget();

	                if (!visitados[vecino.getPosition()]) {
	                	//Primero marcamos el vecino como visitado
	                    visitados[vecino.getPosition()] = true;
	                    
	                    cola.enqueue(new Estado(vecino, actual.distancia + 1));
	                }
	            }
	        }
	    }
	    return jubilados;
	}
}
