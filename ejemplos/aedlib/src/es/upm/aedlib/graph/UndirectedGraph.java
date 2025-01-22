package es.upm.aedlib.graph;

public interface UndirectedGraph<V, E> extends Graph<V, E> {
  Iterable<Vertex<V>> endVertices(Edge<E> paramEdge) throws IllegalArgumentException;
  
  Edge<E> insertUndirectedEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2, E paramE) throws IllegalArgumentException;
  
  Vertex<V> opposite(Vertex<V> paramVertex, Edge<E> paramEdge) throws IllegalArgumentException;
  
  boolean areAdjacent(Vertex<V> paramVertex1, Vertex<V> paramVertex2) throws IllegalArgumentException;
  
  Iterable<Edge<E>> edges(Vertex<V> paramVertex) throws IllegalArgumentException;
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\UndirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */