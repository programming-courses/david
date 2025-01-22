package clase20250122;

public class Ejemplo2 {

	// Generar una lista con los nodos q tengan 2 hijos
	
	
	public static PositionList<Integer> generarLista(BinaryTree<Integer> tree) {
		
		// NULL
		
		PositionList<Integer> lista = new NodePositionList<>();
		
		generarLista(tree, tree.root(), lista);
		
		return lista;
		
	}
	
	public static void generarLista(BinaryTree<Integer> tree, Position<Integer> nodo, PositionList<Integer> lista) {
		
		if (node tiene 2 hijos) {
			lista.add(node.element);
		}
		
		if (tiene para izq)
			//generarLista(tree, tree.left(nodo), lista);
			generarLista(tree, nodo.getLeft(), lista);  // -->> SOLO SI el nodo es el de binarytree!!
		
		if (tiene para der)
			generarLista(tree, tree.right(nodo), lista);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
