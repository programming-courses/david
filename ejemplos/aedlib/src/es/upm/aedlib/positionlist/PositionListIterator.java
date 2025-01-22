/*    */ package es.upm.aedlib.positionlist;
/*    */ 
/*    */ import es.upm.aedlib.Position;
/*    */ import java.util.ConcurrentModificationException;
/*    */ import java.util.Iterator;
/*    */ import java.util.NoSuchElementException;
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
/*    */ public class PositionListIterator<E>
/*    */   implements Iterator<E>
/*    */ {
/*    */   private PositionList<E> list;
/*    */   private Position<E> cursor;
/*    */   private NodePositionList<?> nlist;
/*    */   final long changeCounter;
/*    */   
/*    */   public PositionListIterator(PositionList<E> paramPositionList) {
/* 26 */     if (paramPositionList == null) {
/* 27 */       throw new IllegalArgumentException("The list cannot be null");
/*    */     }
/* 29 */     this.list = paramPositionList;
/* 30 */     this.cursor = paramPositionList.first();
/*    */     
/* 32 */     if (paramPositionList instanceof NodePositionList) {
/* 33 */       this.nlist = (NodePositionList)paramPositionList;
/* 34 */       this.changeCounter = this.nlist.changeCounter;
/*    */     } else {
/*    */       
/* 37 */       this.nlist = null;
/* 38 */       this.changeCounter = 0L;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean hasNext() {
/* 43 */     return (this.cursor != null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public E next() throws NoSuchElementException, ConcurrentModificationException {
/* 49 */     if (this.nlist != null && this.changeCounter != this.nlist.changeCounter) {
/* 50 */       throw new ConcurrentModificationException();
/*    */     }
/* 52 */     if (this.cursor == null) {
/* 53 */       throw new NoSuchElementException();
/*    */     }
/* 55 */     Object object = this.cursor.element();
/* 56 */     this.cursor = this.list.next(this.cursor);
/* 57 */     return (E)object;
/*    */   }
/*    */   
/*    */   public void remove() {
/* 61 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\positionlist\PositionListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */