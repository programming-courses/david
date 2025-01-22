package clase20250122;

public class Ejemplo5 {
	static <V,E> Set<Vertex<V>> getVerticesAlcanzables (UndirectedGraph<V, E> g,
			2 Vertex<V> n) {
			3 Set<Vertex<V>> visited = new HashTableMapSet<V>();
			4 getVerticesAlcanzablesRec(g,n,visited);
			5 return visited;
			6 }
			7 static <V,E> void getVerticesAlcanzablesRec (UndirectedGraph<V, E> g,
			8 Vertex<V> n,
			9 Set<Vertex<V>> visited ) {
			10
			11 // COMPLETAR ESTE METODO
			12 }
	public static void main(String[] args) {
		

	}

}
