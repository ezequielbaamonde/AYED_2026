package ejercicio2;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.matrizAdy.AdjMatrixGraph;

public class TestMain {

    public static void main(String[] args) {
        Graph<Integer> grafo = new AdjMatrixGraph<>(10);

        Vertex<Integer> v1 = grafo.createVertex(1);
        Vertex<Integer> v2 = grafo.createVertex(2);
        Vertex<Integer> v3 = grafo.createVertex(3);
        Vertex<Integer> v4 = grafo.createVertex(4);

        // 1 → 2
        grafo.connect(v1, v2);

        // 1 → 3
        grafo.connect(v1, v3);

        // 2 → 4
        grafo.connect(v2, v4);

        Recorridos recorridos = new Recorridos(); //Instancio el objeto recorridos

        List<Integer> resultado = recorridos.dfs(grafo);
        List<Integer> resultado2 = recorridos.bfs(grafo);
        System.out.println("Recorrido DFS:");
        //Recorro la lista obtenida del DFS
        for (Integer dato : resultado) {
            System.out.print(dato + " ");
        }
        
        System.out.println("\nRecorrido BFS:");
        //Recorro la lista obtenida del DFS
        for (Integer dato : resultado2) {
            System.out.print(dato + " ");
        }
    }
}