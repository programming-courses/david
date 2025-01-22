/*    */ package es.upm.aedlib;
/*    */ 
/*    */ 
/*    */ public class IndexNode<E>
/*    */   implements Position<E>
/*    */ {
/*    */   E element;
/*    */   int index;
/*    */   
/*    */   public IndexNode(E paramE, int paramInt) {
/* 11 */     this.element = paramE;
/* 12 */     this.index = paramInt;
/*    */   }
/*    */   public E element() {
/* 15 */     return this.element;
/*    */   } public int index() {
/* 17 */     return this.index;
/*    */   }
/*    */   public E setElement(E paramE) {
/* 20 */     E e = this.element;
/* 21 */     this.element = paramE;
/* 22 */     return e;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 26 */     return "[" + this.element + "," + this.index + "]";
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\IndexNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */