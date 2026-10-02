package ejercicio4;
import java.util.Arrays;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.matrizAdy.AdjMatrixGraph;

public class TestMainVisitaOslo {

	public static void main(String[] args) {
		Graph<String> grafo = new AdjMatrixGraph<>(20);

        // Crear vértices
        Vertex<String> holmenkollen = grafo.createVertex("Holmenkollen");
        Vertex<String> vigeland = grafo.createVertex("Parque Vigeland");
        Vertex<String> folkMuseum = grafo.createVertex("FolkMuseum");
        Vertex<String> museoFram = grafo.createVertex("Museo Fram");
        Vertex<String> barcoPolar = grafo.createVertex("Museo del Barco Polar");
        Vertex<String> museoVikingo = grafo.createVertex("Museo Vikingo");
        Vertex<String> galeria = grafo.createVertex("Galeria Nacional");
        Vertex<String> palacio = grafo.createVertex("Palacio Real");
        Vertex<String> ayuntamiento = grafo.createVertex("Ayuntamiento");
        Vertex<String> parqueBotanico = grafo.createVertex("Parque Botanico");
        Vertex<String> munch = grafo.createVertex("Museo Munch");
        Vertex<String> tigre = grafo.createVertex("El Tigre");
        Vertex<String> opera = grafo.createVertex("La Opera");
        Vertex<String> fortaleza = grafo.createVertex("Fortaleza Akershus");
        Vertex<String> akker = grafo.createVertex("Akker Brigge");
        
     // Conexiones (bidireccionales)

        conectarBidireccional(grafo, holmenkollen, vigeland, 30);

        conectarBidireccional(grafo, vigeland, folkMuseum, 20);
        conectarBidireccional(grafo, vigeland, galeria, 10);

        conectarBidireccional(grafo, folkMuseum, museoFram, 5);
        conectarBidireccional(grafo, folkMuseum, palacio, 5);
        conectarBidireccional(grafo, folkMuseum, akker, 30);

        conectarBidireccional(grafo, museoFram, barcoPolar, 5);

        conectarBidireccional(grafo, barcoPolar, museoVikingo, 5);

        conectarBidireccional(grafo, museoVikingo, akker, 30);

        conectarBidireccional(grafo, galeria, parqueBotanico, 15);

        conectarBidireccional(grafo, parqueBotanico, ayuntamiento, 10);
        conectarBidireccional(grafo, parqueBotanico, munch, 1);

        conectarBidireccional(grafo, palacio, ayuntamiento, 5);

        conectarBidireccional(grafo, ayuntamiento, akker, 20);
        conectarBidireccional(grafo, ayuntamiento, tigre, 15);

        conectarBidireccional(grafo, munch, tigre, 15);

        conectarBidireccional(grafo, tigre, opera, 5);

        conectarBidireccional(grafo, opera, fortaleza, 10);
        
        // Lugares restringidos (los que aparecen resaltados en negro)
        List<String> restringidos = Arrays.asList(
                "Akker Brigge",
                "Palacio Real"
        );
        
        VisitaOslo visita = new VisitaOslo();
        List<String> resultado = visita.paseoEnBici(
                grafo,
                "Museo Vikingo",
                120,
                restringidos
        );
        
        System.out.println("Recorrido:");
        if (resultado.isEmpty()) {
            System.out.println("No existe un camino válido.");
        } else {
        	for (String lugar : resultado) {
                System.out.print(lugar);

                if (!lugar.equals(resultado.get(resultado.size() - 1))) {
                    System.out.print(" -> ");
                }
            }
        }
        
	}
	
    private static void conectarBidireccional(
            Graph<String> grafo,
             Vertex<String> v1,
             Vertex<String> v2,
             int peso) {

         grafo.connect(v1, v2, peso);
         grafo.connect(v2, v1, peso);
     }

}
