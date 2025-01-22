package es.upm.aedlib.graph;

public interface DirectedGraph<V, E> extends Graph<V, E> {
  Vertex<V> startVertex(Edge<E> paramEdge) throws IllegalArgumentException;
  
  Vertex<V> endVertex(Edge<E> paramEdge) throws IllegalArgumentException;
  
  Edge<E> insertDirectedEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2, E paramE) throws IllegalArgumentException;
  
  Iterable<Edge<E>> outgoingEdges(Vertex<V> paramVertex) throws IllegalArgumentException;
  
  Iterable<Edge<E>> incomingEdges(Vertex<V> paramVertex) throws IllegalArgumentException;
  
  int inDegree(Vertex<V> paramVertex) throws IllegalArgumentException;
  
  int outDegree(Vertex<V> paramVertex) throws IllegalArgumentException;
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\DirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */