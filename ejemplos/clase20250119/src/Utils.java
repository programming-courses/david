//package aed.individual6;
//
//
import es.upm.aedlib.positionlist.*;
import es.upm.aedlib.set.*;

import java.util.Iterator;

import es.upm.aedlib.graph.*;


public class Utils {

	/**
	 * Devuelve un conjunto con todos los vertices alcanzables desde AMBOS
	 * v1 y v2.
	 */
	public static <V> Set<Vertex<V>>
	reachableFromBoth(DirectedGraph<V,Boolean> g, Vertex<V> v1, Vertex<V> v2) {
		// conjunto con los vertices alcanzables desde v1
		Set<Vertex<V>> res1 = new HashTableMapSet<Vertex<V>>();
		
		// conjunto con los vertices alcanzables desde v2
		Set<Vertex<V>> res2 = new HashTableMapSet<Vertex<V>>();
		
		// calculamos el conjunto de vertices alcanzables desde v1 y v2
		reacheableFromVertex(g, v1, res1);
		reacheableFromVertex(g, v2, res2);
		
		// recorremos el conjunto de vertices alcanzables desde v1
		for(Vertex<V> v: res1) {
			// si no es alcanzable desde v2 (NO esta en res2), le sacamos del conjunto res1 (FINAL)
			// ya que no es alcanzable desde ambos vertices
			if(!res2.contains(v))
				res1.remove(v);
		}
		
		return res1;
	}
	
	private static <V> void reacheableFromVertex(DirectedGraph<V,Boolean> g, Vertex<V> v, Set<Vertex<V>> set) {
		if(!set.contains(v)) { // si el conjunto no contiene el vertice que estamos estudiando
			set.add(v); // anadimos el vertice al conjunto (es alcanzable)
			
			// recorro el conjunto de aristas que salen desde el vertice v
			for(Edge<Boolean> edge: g.outgoingEdges(v)) {
				if(edge.element()) {	// si es una arista valida, llamo al metodo de manera recursiva 
										// con el otro extremo
					reacheableFromVertex(g, g.endVertex(edge), set);	
				}
			}
		}
	}

	/**
	 * Devuelve un camino (una lista de aristas) que llevan desde from y to,
	 * donde la suma de los elementos de las aristas del camino < limit.
	 * Si no existe ningun camino que cumple con esta restriccion se devuelve
	 * el valor null. 
	 */

	public static <V> PositionList<Edge<Integer>> existsPathLess(UndirectedGraph<V,Integer> g,
	Vertex<V> from, Vertex<V> to, int limit) {
		PositionList<Edge<Integer>> aristas = new NodePositionList<Edge<Integer>>();
		
		if(from==null || to==null || !existsPath(g,from,to,limit,aristas)) 
			aristas = null;
		
		return aristas;
	}
	
	private static <V> boolean existsPath(UndirectedGraph<V,Integer> g, Vertex<V> from, Vertex<V> to,
	int limit, PositionList<Edge<Integer>> list) {
		
		// CASOS BASES: 
		// El camino supera el limite permitido -> NO EXISTE
		if(limit <= 0)
			return false;
		
		// Hemos encontrado un camino valido (hemos llegado al otro extremo)
		if(from == to) 
			return true;
		
		// CASO RECURSIVO: 
		boolean exists = false; // booleana para parar en cuanto encuentre un camino valido
		
		// Recorro las aristas que salen de FROM
		Iterator<Edge<Integer>> it = g.edges(from).iterator();
		
		// Mientras que no exista un camino valido y haya posibilidad de encontrar un camino valido
		while(!exists && it.hasNext()) {
			Edge<Integer> edge = it.next(); // me quedo con la arista 
			
			// llamo de manera recursiva con el otro extremo
			exists = existsPath(g,g.opposite(from, edge),to,limit-edge.element(), list);
			
			if(exists) { // cuando encontramos un camino valido, comenzamos a anadir las aristas a la lista
				list.addFirst(edge);
			}
		}
		
		return exists; // devuelvo si existe o no un camino al final del todo
	}
}

