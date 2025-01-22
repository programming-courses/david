/*     */ package es.upm.aedlib.fifo;
/*     */ 
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import java.util.Arrays;
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
/*     */ public class FIFOArray<E>
/*     */   implements FIFO<E>
/*     */ {
/*     */   private E[] arr;
/*     */   private int size;
/*     */   private int first;
/*     */   private int last;
/*     */   private static final int DEFAULT_CAPACITY = 1024;
/*     */   
/*     */   public FIFOArray() {
/*  44 */     this(1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FIFOArray(int paramInt) {
/*  53 */     this.arr = (E[])new Object[Math.max(paramInt, 1024)];
/*     */ 
/*     */     
/*  56 */     this.size = this.first = this.last = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FIFOArray(E[] paramArrayOfE) {
/*  63 */     this(paramArrayOfE.length);
/*  64 */     for (E e : paramArrayOfE) enqueue(e);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FIFOArray(FIFO<E> paramFIFO) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokeinterface size : ()I
/*     */     //   7: invokespecial <init> : (I)V
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   16: astore_2
/*     */     //   17: aload_2
/*     */     //   18: invokeinterface hasNext : ()Z
/*     */     //   23: ifeq -> 41
/*     */     //   26: aload_2
/*     */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   32: astore_3
/*     */     //   33: aload_0
/*     */     //   34: aload_3
/*     */     //   35: invokevirtual enqueue : (Ljava/lang/Object;)V
/*     */     //   38: goto -> 17
/*     */     //   41: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #72	-> 0
/*     */     //   #73	-> 10
/*     */     //   #74	-> 33
/*     */     //   #76	-> 41
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  79 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  83 */     return (size() == 0);
/*     */   }
/*     */   
/*     */   public E first() throws EmptyFIFOException {
/*  87 */     if (isEmpty()) throw new EmptyFIFOException(); 
/*  88 */     return this.arr[this.first];
/*     */   }
/*     */   
/*     */   private int incMod(int paramInt) {
/*  92 */     return (paramInt + 1) % this.arr.length;
/*     */   }
/*     */   
/*     */   public E dequeue() throws EmptyFIFOException {
/*  96 */     if (isEmpty()) throw new EmptyFIFOException();
/*     */     
/*  98 */     E e = this.arr[this.first];
/*  99 */     this.arr[this.first] = null;
/* 100 */     this.first = incMod(this.first);
/* 101 */     this.size--;
/* 102 */     return e;
/*     */   }
/*     */   
/*     */   public void enqueue(E paramE) {
/* 106 */     if (size() == this.arr.length) {
/*     */       
/* 108 */       Object[] arrayOfObject = new Object[this.arr.length * 2]; int i;
/* 109 */       for (byte b = 0; b < size(); b++, i = incMod(i)) {
/* 110 */         arrayOfObject[b] = this.arr[i];
/*     */       }
/* 112 */       this.arr = (E[])arrayOfObject;
/* 113 */       this.first = 0;
/* 114 */       this.last = size();
/*     */     } 
/* 116 */     this.arr[this.last] = paramE;
/* 117 */     this.last = incMod(this.last);
/* 118 */     this.size++;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     String str = "["; byte b; int i;
/* 123 */     for (b = 0, i = this.first; b < size(); b++, i = incMod(i)) {
/* 124 */       if (this.arr[i] == null) {
/* 125 */         str = str + "null";
/*     */       } else {
/*     */         
/* 128 */         str = str + this.arr[i].toString();
/*     */       } 
/* 130 */       if (b != size() - 1) str = str + ", "; 
/*     */     } 
/* 132 */     str = str + "]";
/* 133 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 138 */     if (paramObject == this) return true; 
/* 139 */     if (paramObject instanceof FIFO) {
/*     */       
/* 141 */       FIFO fIFO = (FIFO)paramObject;
/* 142 */       if (fIFO.size() != size()) return false; 
/* 143 */       Iterator<E> iterator1 = fIFO.iterator();
/* 144 */       Iterator<E> iterator2 = iterator();
/* 145 */       boolean bool = true;
/* 146 */       while (iterator1.hasNext() && iterator2.hasNext() && (bool = iterator1.next().equals(iterator2.next())));
/*     */       
/* 148 */       return (iterator1.hasNext() == iterator2.hasNext() && bool);
/* 149 */     }  return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 153 */     int i = 0;
/*     */     
/* 155 */     Iterator<E> iterator = iterator();
/*     */     
/* 157 */     while (iterator.hasNext()) {
/* 158 */       E e = iterator.next();
/* 159 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*     */     } 
/* 161 */     return i;
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 165 */     Object[] arrayOfObject = new Object[size()]; byte b; int i;
/* 166 */     for (b = 0, i = this.first; b < size(); b++, i = incMod(i)) {
/* 167 */       arrayOfObject[b] = this.arr[i];
/*     */     }
/* 169 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/* 173 */     if (size() > paramArrayOfE.length)
/* 174 */       paramArrayOfE = (E[])Arrays.<Object>copyOf((Object[])paramArrayOfE, size());  byte b; int i;
/* 175 */     for (b = 0, i = this.first; b < size(); b++, i = incMod(i)) {
/* 176 */       paramArrayOfE[b] = this.arr[i];
/*     */     }
/* 178 */     if (size() < paramArrayOfE.length)
/* 179 */       paramArrayOfE[size()] = null; 
/* 180 */     return paramArrayOfE;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 184 */     NodePositionList nodePositionList = new NodePositionList(); byte b; int i;
/* 185 */     for (b = 0, i = this.first; b < size(); b++, i = incMod(i)) {
/* 186 */       nodePositionList.addLast(this.arr[i]);
/*     */     }
/* 188 */     return nodePositionList.iterator();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\fifo\FIFOArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */