package clase20250120;

import java.util.LinkedList;
import java.util.Queue;

class Tree1 {
	public int element;
	public Tree1 left;
	public Tree1 right;
	
	
	public static void anchura(Tree1 t) {
		
		if (t == null)
			return;
		
		Queue<Tree1> q = new LinkedList<Tree1>();
		q.add(t);
		
		while (q.size() >0) {
			Tree1 nodo = q.poll();
			
			// Procesar
			System.out.println(nodo.element);
			
			// Ejercicios: contar hojas
			
			if (nodo.left != null)
				q.add(nodo.left);
			
			if (nodo.right != null)
				q.add(nodo.right);
		}
	}
}

public class Arboles2 {

	public static void main(String[] args) {
		Tree1 t = new Tree1();
		t.element = 10;
		t.left = new Tree1();
		t.right = new Tree1();
		
		t.left.element = 8;
		t.left.left = new Tree1();
		t.left.left.element = 4;
		
		t.right.element = 24;
		
		Tree1.anchura(t);

	}

}
