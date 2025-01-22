package clase20250122;

import es.upm.aedlib.Position;
import es.upm.aedlib.tree.BinaryTree;

public class Ejemplo3 {


	public static boolean estanHijoOrdenados(BinaryTree<Integer> tree) {
		// NULL
		
		
		return estanHijoOrdenados(tree, tree.root());
		
	}
	
	public static boolean estanHijoOrdenados(BinaryTree<Integer> tree, Position<Integer> nodo) {
		
		boolean res = true;

		// arbol binario
		if (tree.left(nodo) != null && tree.right(nodo) != null) {
			res = res && (tree.left(nodo).element() <= tree.right(nodo).element());
		}
		
		if (tree.hasLeft(nodo))
			res = res && estanHijoOrdenados(tree, tree.left(nodo));
		
		if (tiene para der)
			res = res && estanHijoOrdenados(tree, tree.rigth(nodo));
		
		// arbol general
		if (nodo.children().size > 0) {
			Position<> prev = nodo.children().get(0); // agarramos el primer nodo
			for(Position<> e : nodo.children) {
				if (prev.element() > e.element()) {
					res = false;
				}
				prev = e;
			}				
		}
		
		if (tree.hasChildren(nodo))
			for(Nodo e : nodo.children())
				res = res && estanHijoOrdenados(tree, e);
		
		return res;
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
