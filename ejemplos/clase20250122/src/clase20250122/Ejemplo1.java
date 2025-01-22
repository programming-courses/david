package clase20250122;

import es.upm.aedlib.Position;
import es.upm.aedlib.tree.BinaryTree;
import es.upm.aedlib.tree.LinkedBinaryTree;

public class Ejemplo1 {
	
	public void creacionArbol() {
		
		BinaryTree<String> t = new LinkedBinaryTree<String>();
		t.addRoot("un");
		t.insertLeft(t.root(), "En");
		
		Position<String> lastPos = t.insertRight(t.root(), "de");
		t.insertLeft(lastPos, "lugar");
		lastPos = t.insertRight(lastPos, "la");
		t.insertRight(lastPos, "Mancha");
		
		System.out.println(t);
	}
	
	public static void main(String[] args) {
		Ejemplo1 e = new Ejemplo1();
		e.creacionArbol();
	}
}
