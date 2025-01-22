package clase20250122;

import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;

import java.util.Iterator;

import es.upm.aedlib.graph.DirectedAdjacencyListGraph;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.map.HashTableMap;

public class Ejemplo4 {
	public static <E> Map<Vertex<Integer>, Integer> sumVertices(DirectedGraph<Integer, E> g) {

		Map<Vertex<Integer>, Integer> map = new HashTableMap<Vertex<Integer>, Integer>();

		Iterator<Vertex<Integer>> it = g.vertices().iterator();

		while (it.hasNext()) {
			PositionList<Vertex<Integer>> visited = new NodePositionList<Vertex<Integer>>();
			Vertex<Integer> vertex = it.next();
			// visited.addLast(vertex); Aqui esta tu error
			Integer sumMap = sumVerticesAux(g, vertex, visited, vertex.element());

			map.put(vertex, sumMap);

		}

		return map;
	}

	public static <E> Integer sumVerticesAux(DirectedGraph<Integer, E> g, Vertex<Integer> vertex,
			PositionList<Vertex<Integer>> visited, Integer sum) {

		if (find(visited, vertex)) {
			return 0;
		} else {

			visited.addLast(vertex);
			Iterator<Edge<E>> edges = g.outgoingEdges(vertex).iterator();

			while (edges.hasNext()) {

				Edge<E> edge = edges.next();

				sum = sum + sumVerticesAux(g, g.endVertex(edge), visited, /* sum */g.endVertex(edge).element());
				// sum=sum+vertex.element(); Esto no lo necesitas porque nada mas empezar estas
				// llamando a esta funcion con sum = vertex.element() (en el metodo sumVertices)
				// aparte, para que no se te vaya sumando varias veces la suma todo el rato, en
				// vez de pasar
				// la suma en si pasas el siguiente vertice.
			}

			return sum;
		}
	}

	private static boolean find(PositionList<Vertex<Integer>> visited, Vertex<Integer> vertex) {
		boolean found = false;

		Iterator<Vertex<Integer>> it = visited.iterator();

		while (it.hasNext() && !found) {
			if (it.next().equals(vertex))
				found = true;

		}
		return found;
	}

	public static DirectedGraph<Integer, Void> Sumar(Integer[][] graph) {
		DirectedGraph<Integer, Void> g;
		Map<Integer, Vertex<Integer>> vertices;
		Map<Vertex<Integer>, String> verticeNames;

		g = new DirectedAdjacencyListGraph<Integer, Void>();
		vertices = new HashTableMap<Integer, Vertex<Integer>>();
		verticeNames = new HashTableMap<Vertex<Integer>, String>();

		for (int i = 0; i < graph.length; i++) {
			int node = graph[i][0];
			int weight = graph[i][1];
			Vertex<Integer> v = g.insertVertex(weight);
			vertices.put(node, v);
			verticeNames.put(v, "v" + node);
		}

		for (int i = 0; i < graph.length; i++) {
			int node = graph[i][0];
			for (int j = 2; j < graph[i].length; j++) {
				g.insertDirectedEdge(vertices.get(node), vertices.get(graph[i][j]), null);
			}
		}

		return g;
	}

	public static void main(String[] args) {
		Integer[][] matriz = new java.lang.Integer[][] { { 0, 2, 0, 4, 12 }, { 1, 6, 14 }, { 2, 6, 0, 10, 11 },
				{ 3, 2, 13 }, { 4, 4, 12, 14 }, { 5, 2, 2, 13, 14 }, { 6, 5, 9, 10, 11 }, { 7, 5, 1, 8, 8, 12 },
				{ 8, 1, 4, 5, 9, 9 }, { 9, 6, 11 }, { 10, 4, 3, 9, 14 }, { 11, 5, 8, 12 }, { 12, 1, 3, 7, 13 },
				{ 13, 7, 0, 9 }, { 14, 7, 2, 5, 14 } };

		Ejemplo4.Sumar(matriz);
		// System.out.println(Ejemplo4.sumVertices(null));

	}

}
