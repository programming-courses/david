/*    */ package es.upm.aedlib;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Node<E, O>
/*    */   implements Position<E>
/*    */ {
/*    */   private final O owner;
/*    */   private E elem;
/*    */   
/*    */   public Node(O paramO, E paramE) {
/* 20 */     this.owner = paramO;
/* 21 */     this.elem = paramE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E element() {
/* 32 */     return this.elem;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public O owner() {
/* 41 */     return this.owner;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean kinOf(Object paramObject) {
/* 51 */     if (paramObject == null)
/* 52 */       return false; 
/* 53 */     if (!(paramObject instanceof Node)) {
/* 54 */       return false;
/*    */     }
/* 56 */     Node node = (Node)paramObject;
/* 57 */     return this.owner.equals(node.owner());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setElement(E paramE) {
/* 65 */     this.elem = paramE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Node<E, ?> checkNode(Position<E> paramPosition) {
/* 77 */     if (paramPosition == null || !(paramPosition instanceof Node)) {
/* 78 */       throw new IllegalArgumentException("not a node: " + paramPosition);
/*    */     }
/*    */     
/* 81 */     Node<E, ?> node = (Node)paramPosition;
/*    */     
/* 83 */     if (!kinOf(node)) {
/* 84 */       throw new IllegalArgumentException("foreign position " + node);
/*    */     }
/* 86 */     return node;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 91 */     if (this.elem == null) return "null"; 
/* 92 */     return this.elem.toString();
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */