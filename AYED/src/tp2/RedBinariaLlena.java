package tp2;

 /*a) Estrategia:
		Utilizaría un recorrido en profundidad (DFS), específicamente PreOrden.
		Necesitamos ir acumulando la suma desde la raíz hacia las hojas.
		A medida que bajamos, "llevamos" la suma actual con nosotros. Al llegar a una hoja,
		esa suma representa el retardo de ese camino específico
 */
public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public int retardoReenvio() {
		if (this.arbol.isEmpty() || this.arbol == null) return 0;
		return calcularMax(this.arbol, 0);
	}
	
	private int calcularMax(BinaryTree<Integer> nodo, int sumaAcumulada) {
		// Sumamos el retardo del nodo actual a lo que veníamos trayendo
        int sumaActual = sumaAcumulada + nodo.getData();
        
        // CASO BASE: Si es hoja, ya tenemos el valor total de este camino
        if (nodo.isLeaf()) {
            return sumaActual;
        }
        
        //Explorar ambos hijos
        int retardoIzquierdo = 0;
        int retardoDerecho = 0;
        
        if (nodo.hasLeftChild()) {
            retardoIzquierdo = calcularMax(nodo.getLeftChild(), sumaActual);
        }
        
        if (nodo.hasRightChild()) {
            retardoDerecho = calcularMax(nodo.getRightChild(), sumaActual);
        }
        
        // Retornamos el mayor de los dos (el enunciado pide el último hallado si son iguales)
        // Usamos >= para asegurar que si el derecho es igual al izquierdo, retorne el valor del derecho
        return (retardoDerecho >= retardoIzquierdo) ? retardoDerecho : retardoIzquierdo;
	}
}
