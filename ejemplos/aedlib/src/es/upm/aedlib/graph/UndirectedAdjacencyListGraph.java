/*     */ package es.upm.aedlib.graph;
/*     */ 
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import es.upm.aedlib.set.PositionListSet;
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
/*     */ public class UndirectedAdjacencyListGraph<V, E>
/*     */   extends AdjacencyListGraph<V, E>
/*     */   implements UndirectedGraph<V, E>
/*     */ {
/*     */   public Vertex<V> opposite(Vertex<V> paramVertex, Edge<E> paramEdge) throws IllegalArgumentException {
/*  24 */     checkVertex(paramVertex);
/*  25 */     AdjacencyListGraph<V, E>.MyEdge<E> myEdge = checkEdge(paramEdge);
/*  26 */     AdjacencyListGraph<V, E>.MyVertex[] arrayOfMyVertex = (AdjacencyListGraph<V, E>.MyVertex[])myEdge.endVertices();
/*  27 */     if (paramVertex == arrayOfMyVertex[0])
/*  28 */       return arrayOfMyVertex[1]; 
/*  29 */     if (paramVertex == arrayOfMyVertex[1]) {
/*  30 */       return arrayOfMyVertex[0];
/*     */     }
/*  32 */     throw new IllegalArgumentException("No such vertex exists");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Edge<E> insertUndirectedEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2, E paramE) throws IllegalArgumentException {
/*  39 */     AdjacencyListGraph<V, E>.MyVertex<V> myVertex1 = checkVertex(paramVertex1);
/*  40 */     AdjacencyListGraph<V, E>.MyVertex<V> myVertex2 = checkVertex(paramVertex2);
/*  41 */     AdjacencyListGraph.MyEdge<E> myEdge = new AdjacencyListGraph.MyEdge<E>(this, paramVertex1, paramVertex2, paramE);
/*  42 */     if (paramVertex1.equals(paramVertex2)) {
/*  43 */       Position<Edge<E>> position1 = myVertex1.insertIncidence(myEdge);
/*  44 */       myEdge.setIncidences(position1, position1);
/*     */     } else {
/*  46 */       Position<Edge<E>> position1 = myVertex1.insertIncidence(myEdge);
/*  47 */       Position<Edge<E>> position2 = myVertex2.insertIncidence(myEdge);
/*  48 */       myEdge.setIncidences(position1, position2);
/*     */     } 
/*  50 */     this.EList.addLast(myEdge);
/*  51 */     Position<Edge<E>> position = this.EList.last();
/*  52 */     myEdge.setLocation(position);
/*  53 */     return myEdge;
/*     */   }
/*     */   
/*     */   public Iterable<Vertex<V>> endVertices(Edge<E> paramEdge) throws IllegalArgumentException {
/*  57 */     return (Iterable<Vertex<V>>)new NodePositionList((Object[])endVerticesArray(paramEdge));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean areAdjacent(Vertex<V> paramVertex1, Vertex<V> paramVertex2) throws IllegalArgumentException {
/*     */     Iterable<Edge<E>> iterable;
/*  65 */     if (degree(paramVertex1) < degree(paramVertex2)) {
/*  66 */       iterable = edges(paramVertex1);
/*     */     } else {
/*     */       
/*  69 */       iterable = edges(paramVertex2);
/*     */     } 
/*  71 */     for (Edge<E> edge : iterable) {
/*  72 */       Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(edge);
/*     */       
/*  74 */       if ((arrayOfVertex[0] == paramVertex1 && arrayOfVertex[1] == paramVertex2) || (arrayOfVertex[0] == paramVertex2 && arrayOfVertex[1] == paramVertex1))
/*  75 */         return true; 
/*     */     } 
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int degree(Vertex<V> paramVertex) {
/*  83 */     byte b = 0;
/*     */     
/*  85 */     for (Edge<E> edge : edges(paramVertex)) {
/*  86 */       Vertex[] arrayOfVertex = (Vertex[])endVerticesArray(edge);
/*  87 */       if (arrayOfVertex[0].equals(arrayOfVertex[1])) {
/*  88 */         b += true; continue;
/*     */       } 
/*  90 */       b++;
/*     */     } 
/*     */     
/*  93 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Edge<E>> edges(Vertex<V> paramVertex) {
/*  98 */     return super.edges(paramVertex);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toDot() {
/* 103 */     StringBuilder stringBuilder = new StringBuilder();
/* 104 */     PositionListSet positionListSet = new PositionListSet();
/*     */ 
/*     */     
/* 107 */     stringBuilder.append("graph {\n");
/* 108 */     for (Vertex<V> vertex : (Iterable<Vertex<V>>)vertices()) {
/* 109 */       String str = "";
/* 110 */       boolean bool = false;
/* 111 */       Object object = vertex.get("dotFillcolor");
/* 112 */       if (object instanceof String) {
/* 113 */         String str1 = (String)object;
/* 114 */         str = "style=filled,fillcolor=" + str1;
/*     */       } 
/* 116 */       for (Edge<E> edge : edges(vertex)) {
/* 117 */         Vertex<V> vertex1 = opposite(vertex, edge);
/* 118 */         String str1 = "";
/* 119 */         Object object1 = edge.element();
/* 120 */         if (object1 != null)
/* 121 */           str1 = "label=\"" + edge.element() + "\""; 
/* 122 */         Transition<V, E> transition = new Transition<V, E>(vertex1, edge, vertex);
/*     */         
/* 124 */         if (!positionListSet.contains(transition)) {
/* 125 */           Transition<V, E> transition1 = new Transition<V, E>(vertex, edge, vertex1);
/*     */           
/* 127 */           positionListSet.add(transition1);
/* 128 */           stringBuilder.append("\"" + vertex.element() + "\" -- \"" + vertex1.element() + "\"" + dot_attributes(new String[] { str1 }) + ";\n");
/*     */ 
/*     */ 
/*     */           
/* 132 */           bool = true;
/*     */         } 
/*     */       } 
/* 135 */       stringBuilder.append("\"" + vertex.element() + "\"" + dot_attributes(new String[] { str }) + "\n");
/*     */     } 
/* 137 */     stringBuilder.append("}");
/* 138 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String dot_attributes(String... paramVarArgs) {
/* 142 */     StringBuffer stringBuffer = new StringBuffer();
/* 143 */     for (String str : paramVarArgs) {
/* 144 */       if (stringBuffer.length() != 0) {
/* 145 */         stringBuffer.append("," + str);
/*     */       } else {
/* 147 */         stringBuffer.append(str);
/*     */       } 
/* 149 */     }  if (stringBuffer.length() != 0) {
/* 150 */       stringBuffer.insert(0, "[");
/* 151 */       stringBuffer.append("]");
/*     */     } 
/* 153 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\UndirectedAdjacencyListGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */