package clase20250123;

import java.util.Iterator;

import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.set.HashTableMapSet;
import es.upm.aedlib.set.Set;

public class recursividad2 {
	// dado un grafo determinar si todos sus nodos tienen al menos 2 hijos
	public static <E> boolean tienen2Hijos(DirectedGraph<Integer, E> g) {
	
		Iterator<Vertex<Integer>> it = g.vertices().iterator();
		Set<Vertex<Integer>> visited = new HashTableMapSet<Vertex<Integer>>();
		
		while (it.hasNext()) {
			Vertex<Integer> vertex = it.next();
			
			boolean tiene2Hijos = tienen2Hijos(g, visited, vertex);
		}
		
		return false;
	}
	
	public static <E> boolean tienen2Hijos(DirectedGraph<Integer, E> g, Set<Vertex<Integer>> visited, Vertex<Integer> vertex) {
		
		if (visited.contains(vertex)) 
			return true;
		
		visited.add(vertex);
		
		boolean res = (g.outDegree(vertex) >= 2); 
		
		Iterator<Edge<E>> it = (Iterator<Edge<E>>) g.outgoingEdges(vertex);   // Revisar
		while (it.hasNext() && res) {
			Edge<E> aristaAlHijo = it.next();
			res = res && tienen2Hijos(g, visited, g.endVertex(aristaAlHijo));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
