/*     */ package es.upm.aedlib.lifo;
/*     */ 
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import java.util.Arrays;
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
/*     */ public class LIFOArray<E>
/*     */   implements LIFO<E>
/*     */ {
/*     */   private E[] arr;
/*     */   private int size;
/*     */   private static final int DEFAULT_CAPACITY = 1024;
/*     */   
/*     */   public LIFOArray() {
/*  26 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOArray(int paramInt) {
/*  35 */     this.arr = (E[])new Object[Math.max(paramInt, 1024)];
/*     */ 
/*     */     
/*  38 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOArray(E[] paramArrayOfE) {
/*  46 */     this(paramArrayOfE.length);
/*  47 */     for (E e : paramArrayOfE) push(e);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIFOArray(LIFO<E> paramLIFO) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokeinterface size : ()I
/*     */     //   7: invokespecial <init> : (I)V
/*     */     //   10: aload_0
/*     */     //   11: aload_1
/*     */     //   12: invokeinterface size : ()I
/*     */     //   17: putfield size : I
/*     */     //   20: iconst_0
/*     */     //   21: istore_2
/*     */     //   22: aload_1
/*     */     //   23: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   28: astore_3
/*     */     //   29: aload_3
/*     */     //   30: invokeinterface hasNext : ()Z
/*     */     //   35: ifeq -> 60
/*     */     //   38: aload_3
/*     */     //   39: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   44: astore #4
/*     */     //   46: aload_0
/*     */     //   47: getfield arr : [Ljava/lang/Object;
/*     */     //   50: iload_2
/*     */     //   51: iinc #2, 1
/*     */     //   54: aload #4
/*     */     //   56: aastore
/*     */     //   57: goto -> 29
/*     */     //   60: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #55	-> 0
/*     */     //   #56	-> 10
/*     */     //   #57	-> 20
/*     */     //   #58	-> 22
/*     */     //   #59	-> 46
/*     */     //   #60	-> 60
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  62 */     return this.size;
/*     */   } public boolean isEmpty() {
/*  64 */     return (this.size == 0);
/*     */   }
/*     */   public E top() throws EmptyStackException {
/*  67 */     if (isEmpty()) throw new EmptyStackException(); 
/*  68 */     return this.arr[this.size - 1];
/*     */   }
/*     */   
/*     */   public E pop() throws EmptyStackException {
/*  72 */     if (isEmpty()) throw new EmptyStackException(); 
/*  73 */     E e = this.arr[this.size - 1];
/*  74 */     this.arr[this.size - 1] = null;
/*  75 */     this.size--;
/*  76 */     return e;
/*     */   }
/*     */   
/*     */   public void push(E paramE) {
/*  80 */     if (this.size == this.arr.length) {
/*     */       
/*  82 */       Object[] arrayOfObject = new Object[this.arr.length * 2];
/*  83 */       for (byte b = 0; b < this.size; b++)
/*  84 */         arrayOfObject[b] = this.arr[b]; 
/*  85 */       this.arr = (E[])arrayOfObject;
/*     */     } 
/*  87 */     this.arr[this.size] = paramE;
/*  88 */     this.size++;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     String str = "[";
/*  93 */     for (int i = this.size - 1; i >= 0; i--) {
/*  94 */       if (this.arr[i] == null) {
/*  95 */         str = str + "null";
/*     */       } else {
/*  97 */         str = str + this.arr[i].toString();
/*  98 */       }  if (i != 0) str = str + ", "; 
/*     */     } 
/* 100 */     str = str + "]";
/* 101 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (paramObject == this) return true; 
/* 107 */     if (paramObject instanceof LIFO) {
/*     */       
/* 109 */       LIFO lIFO = (LIFO)paramObject;
/* 110 */       if (lIFO.size() != size()) return false; 
/* 111 */       Iterator<E> iterator1 = lIFO.iterator();
/* 112 */       Iterator<E> iterator2 = iterator();
/* 113 */       boolean bool = true;
/* 114 */       while (iterator1.hasNext() && iterator2.hasNext() && (bool = iterator1.next().equals(iterator2.next())));
/*     */       
/* 116 */       return (iterator1.hasNext() == iterator2.hasNext() && bool);
/* 117 */     }  return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 121 */     int i = 0;
/*     */     
/* 123 */     Iterator<E> iterator = iterator();
/*     */     
/* 125 */     while (iterator.hasNext()) {
/* 126 */       E e = iterator.next();
/* 127 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*     */     } 
/* 129 */     return i;
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 133 */     int i = size();
/* 134 */     Object[] arrayOfObject = new Object[i];
/* 135 */     for (byte b = 0; b < i; b++)
/* 136 */       arrayOfObject[b] = this.arr[i - 1 - b]; 
/* 137 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/* 141 */     int i = size();
/* 142 */     if (i > paramArrayOfE.length) paramArrayOfE = (E[])Arrays.<Object>copyOf((Object[])paramArrayOfE, i); 
/* 143 */     for (byte b = 0; b < i; b++)
/* 144 */       paramArrayOfE[b] = this.arr[i - 1 - b]; 
/* 145 */     if (i < paramArrayOfE.length)
/* 146 */       paramArrayOfE[i] = null; 
/* 147 */     return paramArrayOfE;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 151 */     NodePositionList nodePositionList = new NodePositionList();
/* 152 */     for (byte b = 0; b < this.size; b++)
/* 153 */       nodePositionList.addLast(this.arr[this.size - 1 - b]); 
/* 154 */     return nodePositionList.iterator();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\lifo\LIFOArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */