package clase20250120;

import es.upm.aedlib.Position;
import es.upm.aedlib.tree.GeneralTree;
import es.upm.aedlib.tree.LinkedBinaryTree;
import es.upm.aedlib.tree.LinkedGeneralTree;

/*
public interface Tree <E> extends Iterable <E> {
	public int size();
	public boolean isEmpty();
	public Position<E> addRoot(E e) throws NonEmptyTreeException;
	public Position<E> root();
	public Position<E> parent(Position<E> p) throws IllegalArgumentException;
	public boolean isInternal(Position<E> p);
	public boolean isExternal(Position<E> p); // nodo hoja
	public boolean isRoot(Position<E> p);
	public E set(Position<E> p, E e) throws IllegalArgumentException;
	public Iterable<Position<E>> children(Position<E> p);
}

Profundidad: preorder-inorder-postorden  (Recursivo)
Anchura: Utiliza una cola

*
*/

class Tree {
	public int element;
	public Tree left;
	public Tree right;
	

	public static void preorder(Tree t) {
		if (t == null)
			return;

		procesa(t, 0);		
		preorder(t.left);
		preorder(t.right);
	}

	
	public static void inorder(Tree t) {
		if (t == null)
			return;
		
		inorder(t.left);
		procesa(t, 0);
		inorder(t.right);
	}
	
	public static int postorder(Tree t, int resultado) {
		if (t == null)
			return resultado;
		
		resultado = postorder(t.left, resultado);
		resultado = postorder(t.right, resultado);
		resultado = procesa(t, resultado);		
		
		return resultado;
	}

	private static int procesa(Tree t, int resultado) {
//		System.out.println(t.element);
		return resultado + t.element;
	}
}

public class Arboles1 {

	public static void main(String[] args) {
		Tree t = new Tree();
		t.element = 10;
		t.left = new Tree();
		t.right = new Tree();
		
		t.left.element = 8;
		t.left.left = new Tree();
		t.left.left.element = 4;
		
		t.right.element = 24;
		
//		Tree.inorder(t);
		
		System.out.println(Tree.postorder(t, 0));
		
		
		

	}

	private static void inorder(Tree t) {
		// TODO Auto-generated method stub
		
	}

}
