/*     */ package es.upm.aedlib.graph;
/*     */ 
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.map.HashTableMap;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import es.upm.aedlib.positionlist.PositionList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AdjacencyListGraph<V, E>
/*     */   implements Graph<V, E>
/*     */ {
/*  22 */   protected NodePositionList<Vertex<V>> VList = new NodePositionList();
/*  23 */   protected NodePositionList<Edge<E>> EList = new NodePositionList();
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<Vertex<V>> vertices() {
/*  28 */     return (Iterable<Vertex<V>>)this.VList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Edge<E>> edges() {
/*  33 */     return (Iterable<Edge<E>>)this.EList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterable<Edge<E>> edges(Vertex<V> paramVertex) throws IllegalArgumentException {
/*  51 */     MyVertex<V> myVertex = checkVertex(paramVertex);
/*  52 */     return myVertex.incidentEdges();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Vertex<V>[] endVerticesArray(Edge<E> paramEdge) throws IllegalArgumentException {
/*  59 */     MyEdge<E> myEdge = checkEdge(paramEdge);
/*  60 */     return (Vertex<V>[])myEdge.endVertices();
/*     */   }
/*     */ 
/*     */   
/*     */   public Vertex<V> insertVertex(V paramV) {
/*  65 */     MyVertex<V> myVertex = new MyVertex<V>(paramV);
/*  66 */     this.VList.addLast(myVertex);
/*  67 */     Position<Vertex<V>> position = this.VList.last();
/*  68 */     myVertex.setLocation(position);
/*  69 */     return myVertex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V removeVertex(Vertex<V> paramVertex) throws IllegalArgumentException {
/*  76 */     MyVertex<V> myVertex = checkVertex(paramVertex);
/*  77 */     Iterator<Edge<E>> iterator = edges(paramVertex).iterator();
/*  78 */     NodePositionList nodePositionList = new NodePositionList();
/*     */     
/*  80 */     while (iterator.hasNext()) {
/*  81 */       MyEdge<E> myEdge = checkEdge(iterator.next());
/*  82 */       if (myEdge.location() != null)
/*  83 */         nodePositionList.addLast(myEdge); 
/*     */     } 
/*  85 */     for (Edge<E> edge : (Iterable<Edge<E>>)nodePositionList) {
/*  86 */       removeEdge(edge);
/*     */     }
/*  88 */     this.VList.remove(myVertex.location());
/*  89 */     return (V)paramVertex.element();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E removeEdge(Edge<E> paramEdge) throws IllegalArgumentException {
/*  95 */     MyEdge<E> myEdge = checkEdge(paramEdge);
/*  96 */     MyVertex[] arrayOfMyVertex = (MyVertex[])myEdge.endVertices();
/*  97 */     Position[] arrayOfPosition = (Position[])myEdge.incidences();
/*  98 */     arrayOfMyVertex[0].removeIncidence(arrayOfPosition[0]);
/*  99 */     if (arrayOfPosition[0] != arrayOfPosition[1]) arrayOfMyVertex[1].removeIncidence(arrayOfPosition[1]); 
/* 100 */     this.EList.remove(myEdge.location());
/* 101 */     myEdge.setLocation((Position<Edge<E>>)null);
/* 102 */     return (E)paramEdge.element();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int degree(Vertex<V> paramVertex) {
/* 109 */     MyVertex<V> myVertex = checkVertex(paramVertex);
/* 110 */     return myVertex.degree();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected MyPosition<?> checkPosition(Position paramPosition) throws IllegalArgumentException {
/* 116 */     if (paramPosition == null || !(paramPosition instanceof MyPosition)) {
/* 117 */       throw new IllegalArgumentException("Node/Vertex is invalid");
/*     */     }
/*     */     
/* 120 */     return (MyPosition)paramPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MyVertex<V> checkVertex(Vertex<V> paramVertex) throws IllegalArgumentException {
/* 127 */     if (paramVertex == null || !(paramVertex instanceof MyVertex)) {
/* 128 */       throw new IllegalArgumentException("Vertex is invalid");
/*     */     }
/*     */     
/* 131 */     return (MyVertex)paramVertex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MyEdge<E> checkEdge(Edge<E> paramEdge) throws IllegalArgumentException {
/* 138 */     if (paramEdge == null || !(paramEdge instanceof MyEdge)) {
/* 139 */       throw new IllegalArgumentException("Edge is invalid");
/*     */     }
/*     */     
/* 142 */     return (MyEdge)paramEdge;
/*     */   }
/*     */   
/*     */   protected static class MyPosition<T>
/*     */     extends HashTableMap<Object, Object>
/*     */     implements DecorablePosition<T> {
/*     */     protected T elem;
/*     */     
/*     */     public MyPosition() {
/* 151 */       super(1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T element() {
/* 158 */       return this.elem;
/*     */     }
/*     */     
/*     */     public void setElement(T param1T) {
/* 162 */       this.elem = param1T;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 169 */     StringBuffer stringBuffer = new StringBuffer();
/* 170 */     HashTableMap hashTableMap = new HashTableMap();
/*     */     
/* 172 */     byte b = 0;
/*     */     
/* 174 */     for (Vertex<V> vertex : vertices()) {
/* 175 */       hashTableMap.put(vertex, "v" + b++);
/*     */     }
/*     */     
/* 178 */     for (Vertex<V> vertex : vertices()) {
/* 179 */       stringBuffer.append((String)hashTableMap.get(vertex) + "(" + vertex.element() + "): ");
/* 180 */       boolean bool = false;
/* 181 */       for (Edge<E> edge : edges(vertex)) {
/* 182 */         String str1; Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(edge);
/* 183 */         Vertex vertex1 = arrayOfVertex[1];
/* 184 */         if (arrayOfVertex[0] != vertex)
/*     */           continue; 
/* 186 */         if (this instanceof DirectedAdjacencyListGraph) {
/* 187 */           str1 = "->";
/*     */         } else {
/* 189 */           str1 = "--";
/* 190 */         }  String str2 = "";
/* 191 */         if (edge.element() != null)
/* 192 */           str2 = edge.element().toString(); 
/* 193 */         if (bool) stringBuffer.append(","); 
/* 194 */         stringBuffer.append("-" + str2 + str1 + (String)hashTableMap.get(vertex1));
/* 195 */         bool = true;
/*     */       } 
/* 197 */       stringBuffer.append("\n");
/*     */     } 
/* 199 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public int numVertices() {
/* 203 */     return this.VList.size();
/*     */   }
/*     */   
/*     */   public int numEdges() {
/* 207 */     return this.EList.size();
/*     */   }
/*     */   
/*     */   public int size() {
/* 211 */     return numVertices();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 215 */     return (numVertices() == 0);
/*     */   }
/*     */   
/*     */   public V set(Vertex<V> paramVertex, V paramV) throws IllegalArgumentException {
/* 219 */     Object object = paramVertex.element();
/* 220 */     MyVertex<V> myVertex = checkVertex(paramVertex);
/* 221 */     myVertex.setElement(paramV);
/* 222 */     return (V)object;
/*     */   }
/*     */   
/*     */   public E set(Edge<E> paramEdge, E paramE) throws IllegalArgumentException {
/* 226 */     Object object = paramEdge.element();
/* 227 */     MyEdge<E> myEdge = checkEdge(paramEdge);
/* 228 */     myEdge.setElement(paramE);
/* 229 */     return (E)object;
/*     */   }
/*     */   
/*     */   public String toDot() {
/* 233 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected class MyVertex<V>
/*     */     extends MyPosition<V>
/*     */     implements Vertex<V>
/*     */   {
/*     */     protected PositionList<Edge<E>> incEdges;
/*     */     
/*     */     protected Position<Vertex<V>> loc;
/*     */ 
/*     */     
/*     */     MyVertex(V param1V) {
/* 247 */       this.elem = param1V;
/* 248 */       this.incEdges = (PositionList<Edge<E>>)new NodePositionList();
/*     */     }
/*     */     
/*     */     public int degree() {
/* 252 */       return this.incEdges.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterable<Edge<E>> incidentEdges() {
/* 257 */       return (Iterable<Edge<E>>)this.incEdges;
/*     */     }
/*     */ 
/*     */     
/*     */     public Position<Edge<E>> insertIncidence(Edge<E> param1Edge) {
/* 262 */       this.incEdges.addLast(param1Edge);
/* 263 */       return this.incEdges.last();
/*     */     }
/*     */ 
/*     */     
/*     */     public void removeIncidence(Position<Edge<E>> param1Position) {
/* 268 */       this.incEdges.remove(param1Position);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Position<Vertex<V>> location() {
/* 274 */       return this.loc;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setLocation(Position<Vertex<V>> param1Position) {
/* 280 */       this.loc = param1Position;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 286 */       return this.elem.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected class MyEdge<E>
/*     */     extends MyPosition<E>
/*     */     implements Edge<E>
/*     */   {
/*     */     protected AdjacencyListGraph<V, E>.MyVertex<V>[] endVertices;
/*     */ 
/*     */     
/*     */     protected Position<Edge<E>>[] Inc;
/*     */ 
/*     */     
/*     */     protected Position<Edge<E>> loc;
/*     */ 
/*     */ 
/*     */     
/*     */     MyEdge(Vertex<V> param1Vertex1, Vertex<V> param1Vertex2, E param1E) {
/* 307 */       this.elem = param1E;
/*     */       
/* 309 */       AdjacencyListGraph.MyVertex[] arrayOfMyVertex = new AdjacencyListGraph.MyVertex[2];
/* 310 */       this.endVertices = (AdjacencyListGraph<V, E>.MyVertex<V>[])arrayOfMyVertex;
/* 311 */       this.endVertices[0] = AdjacencyListGraph.this.checkVertex(param1Vertex1);
/* 312 */       this.endVertices[1] = AdjacencyListGraph.this.checkVertex(param1Vertex2);
/*     */       
/* 314 */       Position[] arrayOfPosition = new Position[2];
/* 315 */       this.Inc = (Position<Edge<E>>[])arrayOfPosition;
/*     */     }
/*     */ 
/*     */     
/*     */     public AdjacencyListGraph<V, E>.MyVertex<V>[] endVertices() {
/* 320 */       return this.endVertices;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Position<Edge<E>>[] incidences() {
/* 326 */       return this.Inc;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setIncidences(Position<Edge<E>> param1Position1, Position<Edge<E>> param1Position2) {
/* 331 */       this.Inc[0] = param1Position1;
/* 332 */       this.Inc[1] = param1Position2;
/*     */     }
/*     */ 
/*     */     
/*     */     public Position<Edge<E>> location() {
/* 337 */       return this.loc;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLocation(Position<Edge<E>> param1Position) {
/* 342 */       this.loc = param1Position;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 347 */       return (new StringBuilder()).append(element()).append("(").append(this.endVertices[0].toString()).append(",").append(this.endVertices[1].toString()).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\AdjacencyListGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */