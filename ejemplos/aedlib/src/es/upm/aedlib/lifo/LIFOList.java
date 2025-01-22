/*     */ package es.upm.aedlib.lifo;
/*     */ 
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import es.upm.aedlib.positionlist.PositionList;
/*     */ import java.util.EmptyStackException;
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
/*     */ public class LIFOList<E>
/*     */   implements LIFO<E>
/*     */ {
/*  22 */   private PositionList<E> list = (PositionList<E>)new NodePositionList();
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOList() {}
/*     */ 
/*     */   
/*     */   public LIFOList(E[] paramArrayOfE) {
/*  30 */     this();
/*  31 */     for (E e : paramArrayOfE) push(e);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOList(PositionList<E> paramPositionList) {
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
/*     */     //   29: invokevirtual push : (Ljava/lang/Object;)V
/*     */     //   32: goto -> 11
/*     */     //   35: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #38	-> 0
/*     */     //   #39	-> 4
/*     */     //   #40	-> 35
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOList(LIFO<E> paramLIFO) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_1
/*     */     //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   10: astore_2
/*     */     //   11: aload_2
/*     */     //   12: invokeinterface hasNext : ()Z
/*     */     //   17: ifeq -> 40
/*     */     //   20: aload_2
/*     */     //   21: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   26: astore_3
/*     */     //   27: aload_0
/*     */     //   28: getfield list : Les/upm/aedlib/positionlist/PositionList;
/*     */     //   31: aload_3
/*     */     //   32: invokeinterface addLast : (Ljava/lang/Object;)V
/*     */     //   37: goto -> 11
/*     */     //   40: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #47	-> 0
/*     */     //   #48	-> 4
/*     */     //   #49	-> 40
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  51 */     return this.list.size();
/*     */   } public boolean isEmpty() {
/*  53 */     return this.list.isEmpty();
/*     */   }
/*     */   public E top() throws EmptyStackException {
/*  56 */     if (isEmpty()) {
/*  57 */       throw new EmptyStackException();
/*     */     }
/*  59 */     return (E)this.list.first().element();
/*     */   }
/*     */   
/*     */   public E pop() throws EmptyStackException {
/*  63 */     if (isEmpty()) {
/*  64 */       throw new EmptyStackException();
/*     */     }
/*  66 */     Object object = this.list.first().element();
/*  67 */     this.list.remove(this.list.first());
/*  68 */     return (E)object;
/*     */   }
/*     */   
/*     */   public void push(E paramE) {
/*  72 */     this.list.addFirst(paramE);
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  76 */     return this.list.iterator();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  80 */     return this.list.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  85 */     if (paramObject == this) return true; 
/*  86 */     if (paramObject instanceof LIFO) {
/*  87 */       LIFO lIFO = (LIFO)paramObject;
/*  88 */       if (lIFO.size() != size()) return false; 
/*  89 */       Iterator<E> iterator1 = lIFO.iterator();
/*  90 */       Iterator<E> iterator2 = iterator();
/*  91 */       boolean bool = true;
/*  92 */       while (iterator1.hasNext() && iterator2.hasNext() && (bool = iterator1.next().equals(iterator2.next())));
/*     */       
/*  94 */       return (iterator1.hasNext() == iterator2.hasNext() && bool);
/*  95 */     }  return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int i = 0;
/*     */     
/* 101 */     Iterator<E> iterator = iterator();
/*     */     
/* 103 */     while (iterator.hasNext()) {
/* 104 */       E e = iterator.next();
/* 105 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*     */     } 
/* 107 */     return i;
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 111 */     return this.list.toArray();
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/* 115 */     return (E[])this.list.toArray((Object[])paramArrayOfE);
/*     */   }
/*     */   
/*     */   protected NodePositionList<E> toPositionList() {
/* 119 */     return new NodePositionList(this.list);
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\lifo\LIFOList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */