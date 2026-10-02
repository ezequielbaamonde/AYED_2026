package ejercicio5;
import tp5.ejercicio1.Vertex;

public class Estado {
    Vertex<Persona> vertice;
    int distancia;

    Estado(Vertex<Persona> v, int d){
        vertice = v;
        distancia = d;
    }
}
