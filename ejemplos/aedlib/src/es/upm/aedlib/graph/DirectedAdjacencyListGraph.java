/*     */ package es.upm.aedlib.graph;
/*     */ 
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
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
/*     */ public class DirectedAdjacencyListGraph<V, E>
/*     */   extends AdjacencyListGraph<V, E>
/*     */   implements DirectedGraph<V, E>
/*     */ {
/*     */   public Vertex<V> startVertex(Edge<E> paramEdge) throws IllegalArgumentException {
/*  20 */     Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(paramEdge);
/*  21 */     return arrayOfVertex[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public Vertex<V> endVertex(Edge<E> paramEdge) throws IllegalArgumentException {
/*  26 */     Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(paramEdge);
/*  27 */     return arrayOfVertex[1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Edge<E> insertDirectedEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2, E paramE) throws IllegalArgumentException {
/*  35 */     AdjacencyListGraph<V, E>.MyVertex<V> myVertex1 = checkVertex(paramVertex1);
/*  36 */     AdjacencyListGraph<V, E>.MyVertex<V> myVertex2 = checkVertex(paramVertex2);
/*  37 */     AdjacencyListGraph.MyEdge<E> myEdge = new AdjacencyListGraph.MyEdge<E>(paramVertex1, paramVertex2, paramE);
/*  38 */     if (paramVertex1.equals(paramVertex2)) {
/*  39 */       Position<Edge<E>> position1 = myVertex1.insertIncidence(myEdge);
/*  40 */       myEdge.setIncidences(position1, position1);
/*     */     } else {
/*  42 */       Position<Edge<E>> position1 = myVertex1.insertIncidence(myEdge);
/*  43 */       Position<Edge<E>> position2 = myVertex2.insertIncidence(myEdge);
/*  44 */       myEdge.setIncidences(position1, position2);
/*     */     } 
/*  46 */     this.EList.addLast(myEdge);
/*  47 */     Position<Edge<E>> position = this.EList.last();
/*  48 */     myEdge.setLocation(position);
/*  49 */     return myEdge;
/*     */   }
/*     */   
/*     */   public Iterable<Edge<E>> outgoingEdges(Vertex<V> paramVertex) {
/*  53 */     NodePositionList nodePositionList = new NodePositionList();
/*  54 */     for (Edge<E> edge : edges(paramVertex)) {
/*  55 */       Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(edge);
/*  56 */       if (arrayOfVertex[0].equals(paramVertex))
/*  57 */         nodePositionList.addLast(edge); 
/*     */     } 
/*  59 */     return (Iterable<Edge<E>>)nodePositionList;
/*     */   }
/*     */   
/*     */   public Iterable<Edge<E>> incomingEdges(Vertex<V> paramVertex) {
/*  63 */     NodePositionList nodePositionList = new NodePositionList();
/*  64 */     for (Edge<E> edge : edges(paramVertex)) {
/*  65 */       Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(edge);
/*  66 */       if (arrayOfVertex[1].equals(paramVertex))
/*  67 */         nodePositionList.addLast(edge); 
/*     */     } 
/*  69 */     return (Iterable<Edge<E>>)nodePositionList;
/*     */   }
/*     */   
/*     */   public int inDegree(Vertex<V> paramVertex) {
/*  73 */     byte b = 0;
/*  74 */     for (Edge<E> edge : incomingEdges(paramVertex)) {
/*  75 */       b++;
/*     */     }
/*  77 */     return b;
/*     */   }
/*     */   
/*     */   public int outDegree(Vertex<V> paramVertex) {
/*  81 */     byte b = 0;
/*  82 */     for (Edge<E> edge : outgoingEdges(paramVertex)) {
/*  83 */       b++;
/*     */     }
/*  85 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int degree(Vertex<V> paramVertex) {
/*  92 */     return inDegree(paramVertex) + outDegree(paramVertex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toDot() {
/*  98 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 100 */     stringBuilder.append("digraph {\n");
/* 101 */     for (Vertex<V> vertex : (Iterable<Vertex<V>>)vertices()) {
/* 102 */       String str = "";
/* 103 */       boolean bool = false;
/* 104 */       Object object = vertex.get("dotFillcolor");
/* 105 */       if (object instanceof String) {
/* 106 */         String str1 = (String)object;
/* 107 */         str = "style=filled,fillcolor=" + str1;
/*     */       } 
/* 109 */       for (Edge<E> edge : outgoingEdges(vertex)) {
/* 110 */         String str1 = "";
/* 111 */         Object object1 = edge.element();
/* 112 */         if (object1 != null)
/* 113 */           str1 = "label=\"" + edge.element() + "\""; 
/* 114 */         stringBuilder.append("\"" + vertex.element() + "\" -> \"" + endVertex(edge).element() + "\"" + dot_attributes(new String[] { str1 }) + ";\n");
/*     */         
/* 116 */         bool = true;
/*     */       } 
/* 118 */       stringBuilder.append("\"" + vertex.element() + "\"" + dot_attributes(new String[] { str }) + "\n");
/*     */     } 
/* 120 */     stringBuilder.append("}");
/* 121 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String dot_attributes(String... paramVarArgs) {
/* 125 */     StringBuffer stringBuffer = new StringBuffer();
/* 126 */     for (String str : paramVarArgs) {
/* 127 */       if (stringBuffer.length() != 0) {
/* 128 */         stringBuffer.append("," + str);
/*     */       } else {
/* 130 */         stringBuffer.append(str);
/*     */       } 
/* 132 */     }  if (stringBuffer.length() != 0) {
/* 133 */       stringBuffer.insert(0, "[");
/* 134 */       stringBuffer.append("]");
/*     */     } 
/* 136 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\DirectedAdjacencyListGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */