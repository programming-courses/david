/*     */ package es.upm.aedlib.graph;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Transition<V, E>
/*     */ {
/*     */   private Vertex<V> v1;
/*     */   private Edge<E> e;
/*     */   private Vertex<V> v2;
/*     */   
/*     */   public Transition(Vertex<V> paramVertex1, Edge<E> paramEdge, Vertex<V> paramVertex2) {
/* 163 */     this.v1 = paramVertex1;
/* 164 */     this.e = paramEdge;
/* 165 */     this.v2 = paramVertex2;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 169 */     if (paramObject instanceof Transition) {
/* 170 */       Transition transition = (Transition)paramObject;
/* 171 */       return (this.v1.equals(transition.v1) && this.e.equals(transition.e) && this.v2.equals(transition.v2));
/* 172 */     }  return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 176 */     return this.v1.hashCode() + this.e.hashCode() + this.v2.hashCode();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\graph\Transition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */