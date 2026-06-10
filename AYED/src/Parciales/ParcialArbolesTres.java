package Parciales;
import java.util.List;
import java.util.LinkedList;
public class ParcialArbolesTres {
	private GeneralTree<Integer> arbol;

	public ParcialArbolesTres(GeneralTree<Integer> a) {
		this.arbol = a;
	}
	
	public static List<Integer> caminoSignoAlternate(GeneralTree<Integer> a){
		List<Integer> camino = new LinkedList<>();
		if (a != null && !a.isEmpty()) {
			Maximo max = new Maximo(Integer.MIN_VALUE);
			List<Integer> caminoAct = new LinkedList<>();
			evaluarCamino(a, camino, caminoAct, max, 0);
		}
		return camino;
	}
	
	//Recorrido PRE-ORDEN
	private static void evaluarCamino(GeneralTree<Integer> a, List<Integer> res, List<Integer> act, Maximo m, int suma) {
		boolean alterna = true;
		//Si la lista no está vacia, evaluo la alternancia
		if (!act.isEmpty()) {
			if ((act.get(act.size()-1)>= 0 && a.getData() >= 0) || (act.get(act.size()-1) < 0 && a.getData() < 0)) {
	            alterna = false;
	        }
		}
		
		//Solo si es raíz o alterna, procesamos hijos
		if (alterna){
			act.add(a.getData());
			suma+= a.getData();	
			//Si llegué a la hoja evaluo max
			if (a.isLeaf()) {
				if(suma > m.getMax()) {
					m.setMax(suma);
					res.clear(); //Elimino resultado anterior
					for(int i=0; i<act.size(); i++) {
						res.add(act.get(i));
					}
				}
			}else{
				for(GeneralTree<Integer> hijo : a.getChildren()) {
				evaluarCamino(hijo, res, act, m, suma);
				}
			}
			act.remove(act.size()-1); //BackTracking
		}
	}
}
