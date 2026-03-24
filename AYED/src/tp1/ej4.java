package tp1;

public class ej4 {
	public static void swap1 (int x, int y) {
		 if (x < y) {
		 int tmp = x ;
		 x = y ;
		 y = tmp;
		}
	}
	
	public static void swap2 (Integer x, Integer y) {
		 if (x < y) {
		 	int tmp = x ;
		 	x = y ;
		 	y = tmp;
		}
	}
	
	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ; //IMPRIME 1 Y 2, son datos primitivos, no varían tras lo realizado en el método SWAP
		System.out.println("c=" + c + " d=" + d) ; //IMPRIME 4 Y 3, son clases Wrappers, son referenciales y varían según lo realizado en el método SWAP
	}

}
