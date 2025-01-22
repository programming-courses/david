/*    */ package es.upm.aedlib.indexedlist;
/*    */ 
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
/*    */ public class IndexedListIterator<E>
/*    */   implements Iterator<E>
/*    */ {
/*    */   private IndexedList<E> list;
/*    */   private int index;
/*    */   private ArrayIndexedList<?> nlist;
/*    */   final long changeCounter;
/*    */   
/*    */   public IndexedListIterator(IndexedList<E> paramIndexedList) {
/* 25 */     if (paramIndexedList == null) {
/* 26 */       throw new IllegalArgumentException("The list cannot be null");
/*    */     }
/* 28 */     this.list = paramIndexedList;
/* 29 */     this.index = 0;
/*    */     
/* 31 */     if (paramIndexedList instanceof ArrayIndexedList) {
/* 32 */       this.nlist = (ArrayIndexedList)paramIndexedList;
/* 33 */       this.changeCounter = this.nlist.changeCounter;
/*    */     } else {
/*    */       
/* 36 */       this.nlist = null;
/* 37 */       this.changeCounter = 0L;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean hasNext() {
/* 42 */     return (this.index < this.nlist.size());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public E next() throws NoSuchElementException, ConcurrentModificationException {
/* 48 */     if (this.nlist != null && this.changeCounter != this.nlist.changeCounter) {
/* 49 */       throw new ConcurrentModificationException();
/*    */     }
/* 51 */     if (this.index >= this.nlist.size()) {
/* 52 */       throw new NoSuchElementException();
/*    */     }
/* 54 */     E e = this.list.get(this.index);
/* 55 */     this.index++;
/* 56 */     return e;
/*    */   }
/*    */   
/*    */   public void remove() {
/* 60 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\indexedlist\IndexedListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */