package es.upm.aedlib.graph;

public interface Graph<V, E> {
  int size();
  
  boolean isEmpty();
  
  int numVertices();
  
  int numEdges();
  
  Iterable<Vertex<V>> vertices();
  
  Iterable<Edge<E>> edges();
  
  V set(Vertex<V> paramVertex, V paramV) throws IllegalArgumentException;
  
  E set(Edge<E> paramEdge, E paramE) throws IllegalArgumentException;
  
  Vertex<V> insertVertex(V paramV);
  
  V removeVertex(Vertex<V> paramVertex) throws IllegalArgumentException;
  
  E removeEdge(Edge<E> paramEdge) throws IllegalArgumentException;
  
  int degree(Vertex<V> paramVertex) throws IllegalArgumentException;
  
  String toDot();
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\Graph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */