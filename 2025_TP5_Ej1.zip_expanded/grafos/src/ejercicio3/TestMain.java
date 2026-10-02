package ejercicio3;

import java.util.*;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.matrizAdy.AdjMatrixGraph;

public class TestMain {

    public static void main(String[] args) {
        Graph<String> grafo = new AdjMatrixGraph<>(10);

        Vertex<String> v1 = grafo.createVertex("Buenos Aires");
        Vertex<String> v2 = grafo.createVertex("Santa Fe");
        Vertex<String> v3 = grafo.createVertex("Cordoba");
        Vertex<String> v4 = grafo.createVertex("Santiago del Estero");

        // 1 → 2
        grafo.connect(v1, v2, 1);

        // 1 → 3
        grafo.connect(v1, v3, 50);

        // 2 → 4
        grafo.connect(v2, v4, 1);
        // 3 -> 4
        grafo.connect(v3, v4, 1);
        // 4 -> 3
        grafo.connect(v4, v3, 1);
        
        /*
         * v1 -500-> v2 -10-> v4
         * |                 /
         * 50               / 
         * |               /
         * v              /
         * v3<-----------/
         */
        
        Mapa map = new Mapa(grafo);
        
        //DevolverCamino
        List<String> resultado = map.devolverCamino("Buenos Aires", "Santiago del Estero");
        System.out.println("Camino hasta " + v4.getData());
        //Recorro la lista obtenida del DFS
        for (String dato : resultado) {
            System.out.print(dato + "=>");
        }
        
        //DevolverCaminoExceptuando
        List<String> ciudades = new LinkedList<>();
        ciudades.add("Santa Fe");
        resultado = map.devolverCaminoExceptuando("Buenos Aires", "Santiago del Estero", ciudades);
        
        System.out.println("\nCamino exceptuando{ ");
        for (String c : ciudades) {
        	System.out.println(c + " ");
        }
        System.out.println("}");
        
        for(String dato : resultado) {
        	System.out.print(dato + "=>");
        }
        
        //DevolverCaminoMasCorto
        System.out.println("\nCamino más corto hasta Santiago del Estero");
        resultado = map.caminoMasCorto("Buenos Aires", "Santiago del Estero");
        for(String dato : resultado) {
        	System.out.print(dato + "=>");
        }
        
        //DevolverCaminoSinCargarCombustible
        System.out.println("\nCamino con menos combustible hasta Cordoba");
        resultado = map.caminoSinCargarCombustible("Buenos Aires", "Cordoba", 30);
        for(String dato : resultado) {
        	System.out.print(dato + "=>"); //Devuelve [] ya que el único camino hacia cordoba es de BS a CBA
        }
        
        
    }
}