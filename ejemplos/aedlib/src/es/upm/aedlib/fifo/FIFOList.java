/*     */ package es.upm.aedlib.fifo;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FIFOList<E>
/*     */   implements FIFO<E>
/*     */ {
/*  23 */   private PositionList<E> list = (PositionList<E>)new NodePositionList();
/*     */ 
/*     */   
/*     */   public FIFOList() {}
/*     */ 
/*     */   
/*     */   public FIFOList(E[] paramArrayOfE) {
/*  30 */     this();
/*  31 */     for (E e : paramArrayOfE) enqueue(e);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FIFOList(PositionList<E> paramPositionList) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_1
/*     */     //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   10: astore_2
/*     */     //   11: aload_2
/*     */     //   12: invokeinterface hasNext : ()Z
/*     */     //   17: ifeq -> 35
/*     */     //   20: aload_2
/*     */     //   21: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   26: astore_3
/*     */     //   27: aload_0
/*     */     //   28: aload_3
/*     */     //   29: invokevirtual enqueue : (Ljava/lang/Object;)V
/*     */     //   32: goto -> 11
/*     */     //   35: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #39	-> 0
/*     */     //   #40	-> 4
/*     */     //   #41	-> 35
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FIFOList(FIFO<E> paramFIFO) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_1
/*     */     //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   10: astore_2
/*     */     //   11: aload_2
/*     */     //   12: invokeinterface hasNext : ()Z
/*     */     //   17: ifeq -> 35
/*     */     //   20: aload_2
/*     */     //   21: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   26: astore_3
/*     */     //   27: aload_0
/*     */     //   28: aload_3
/*     */     //   29: invokevirtual enqueue : (Ljava/lang/Object;)V
/*     */     //   32: goto -> 11
/*     */     //   35: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #48	-> 0
/*     */     //   #49	-> 4
/*     */     //   #50	-> 35
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  53 */     return this.list.size();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  57 */     return this.list.isEmpty();
/*     */   }
/*     */   
/*     */   public E first() throws EmptyFIFOException {
/*  61 */     if (isEmpty()) throw new EmptyFIFOException(); 
/*  62 */     return (E)this.list.first().element();
/*     */   }
/*     */   
/*     */   public void enqueue(E paramE) {
/*  66 */     this.list.addLast(paramE);
/*     */   }
/*     */   
/*     */   public E dequeue() throws EmptyFIFOException {
/*  70 */     if (isEmpty()) throw new EmptyFIFOException(); 
/*  71 */     Object object = this.list.first().element();
/*  72 */     this.list.remove(this.list.first());
/*  73 */     return (E)object;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  77 */     return this.list.iterator();
/*     */   }
/*     */   public String toString() {
/*  80 */     return this.list.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  84 */     if (paramObject == this) return true; 
/*  85 */     if (paramObject instanceof FIFO) {
/*  86 */       FIFO fIFO = (FIFO)paramObject;
/*  87 */       if (fIFO.size() != size()) return false; 
/*  88 */       Iterator<E> iterator1 = fIFO.iterator();
/*  89 */       Iterator<E> iterator2 = iterator();
/*  90 */       boolean bool = true;
/*  91 */       while (iterator1.hasNext() && iterator2.hasNext() && (bool = iterator1.next().equals(iterator2.next())));
/*     */       
/*  93 */       return (iterator1.hasNext() == iterator2.hasNext() && bool);
/*  94 */     }  return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int i = 0;
/*     */     
/* 100 */     Iterator<E> iterator = iterator();
/*     */     
/* 102 */     while (iterator.hasNext()) {
/* 103 */       E e = iterator.next();
/* 104 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*     */     } 
/* 106 */     return i;
/*     */   }
/*     */   public Object[] toArray() {
/* 109 */     return this.list.toArray();
/*     */   } public E[] toArray(E[] paramArrayOfE) {
/* 111 */     return (E[])this.list.toArray((Object[])paramArrayOfE);
/*     */   }
/*     */   public NodePositionList<E> toPositionList() {
/* 114 */     return new NodePositionList(this.list);
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\fifo\FIFOList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */