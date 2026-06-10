package Parciales;
import java.util.*;
public class ParcialArbolesDos {
	private GeneralTree<Integer> arbol;
	
	public ParcialArbolesDos(GeneralTree<Integer> ag){
		this.arbol = ag;
	}
	
	public List<Integer> nivel(int num){
		List<Integer> resultados = new LinkedList<Integer>();
		if(this.arbol != null && !this.arbol.isEmpty()) {
			buscarNivel(this.arbol, num, resultados);
		}
		return resultados;
	}
	
	private void buscarNivel(GeneralTree<Integer> a, int num, List<Integer> res) {
		GeneralTree<Integer> visito; //Nodo aux para almacenar valores a la lista
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>(); //Cola
		cola.enqueue(a); //Encolo raíz
		cola.enqueue(null); //Marco fin de nivel
		
		boolean cumple = true;
		boolean termine = false;
		while (!cola.isEmpty() && !termine){
			visito = cola.dequeue();
			if (visito != null) {
				if(cumple) {
					res.add(visito.getData());
					//Corte: Si este nodo no cumple, el nivel se invalida y cortamos el add de la lista
					if(visito.getChildren().size() < num) {
						cumple = false; //El nivel no es valido
					}
				}
				//Encoló hijos para poder analizar siguiente nivel
				for(GeneralTree<Integer> hijo: visito.getChildren()) {
					cola.enqueue(hijo);
				}
			}else{
				if (cumple) {
					termine=true; //Salgo del bucle porque cumplí la condición
				}else {
					res.clear();
					cumple = true;
					if(!cola.isEmpty()){
						cola.enqueue(null);
					}	
				}

			}
		}
		res.clear(); //Si salimos del while es porque no cumplió la condición
	}
}
