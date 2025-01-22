/*     */ package es.upm.aedlib.indexedlist;
/*     */ 
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
/*     */ public class ArrayIndexedList<E>
/*     */   implements IndexedList<E>
/*     */ {
/*     */   private static final int INITIAL_CAPACITY = 3;
/*     */   private static final int GROW_SHRINK_INCREMENT = 10;
/*     */   private E[] data;
/*     */   private int nElems;
/*     */   protected long changeCounter;
/*     */   
/*     */   public ArrayIndexedList() {
/*  43 */     this.data = (E[])new Object[3];
/*  44 */     this.nElems = 0;
/*  45 */     this.changeCounter = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayIndexedList(ArrayIndexedList<E> paramArrayIndexedList) {
/*  53 */     this.nElems = paramArrayIndexedList.nElems;
/*  54 */     this.data = Arrays.copyOf(paramArrayIndexedList.data, this.nElems);
/*  55 */     this.changeCounter = 0L;
/*     */   }
/*     */   
/*     */   public void add(int paramInt, E paramE) throws IndexOutOfBoundsException {
/*  59 */     if (paramInt < 0 || paramInt > size()) {
/*  60 */       throw new IndexOutOfBoundsException("" + paramInt);
/*     */     }
/*     */     
/*  63 */     if (size() == this.data.length)
/*     */     {
/*     */       
/*  66 */       this.data = Arrays.copyOf(this.data, this.nElems + 10);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  71 */     for (int i = size(); i > paramInt; i--) {
/*  72 */       this.data[i] = this.data[i - 1];
/*     */     }
/*  74 */     this.data[paramInt] = paramE;
/*  75 */     this.nElems++;
/*  76 */     this.changeCounter++;
/*     */   }
/*     */ 
/*     */   
/*     */   public E get(int paramInt) throws IndexOutOfBoundsException {
/*  81 */     if (paramInt < 0 || paramInt >= size())
/*  82 */       throw new IndexOutOfBoundsException("" + paramInt); 
/*  83 */     return this.data[paramInt];
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  87 */     return (size() == 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  91 */     return this.nElems;
/*     */   }
/*     */   
/*     */   public E set(int paramInt, E paramE) throws IndexOutOfBoundsException {
/*  95 */     if (paramInt < 0 || paramInt >= size())
/*  96 */       throw new IndexOutOfBoundsException("" + paramInt); 
/*  97 */     E e = this.data[paramInt];
/*  98 */     this.data[paramInt] = paramE;
/*  99 */     this.changeCounter++;
/* 100 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(E paramE) {
/*     */     byte b;
/* 106 */     for (b = 0; b < this.nElems && !this.data[b].equals(paramE); b++);
/*     */     
/* 108 */     if (b < this.nElems) {
/* 109 */       return b;
/*     */     }
/* 111 */     return -1;
/*     */   }
/*     */   
/*     */   public E removeElementAt(int paramInt) throws IndexOutOfBoundsException {
/* 115 */     if (paramInt < 0 || paramInt >= size())
/* 116 */       throw new IndexOutOfBoundsException("" + paramInt); 
/* 117 */     E e = this.data[paramInt];
/* 118 */     this.nElems--;
/* 119 */     for (int i = paramInt; i < this.nElems; i++) {
/* 120 */       this.data[i] = this.data[i + 1];
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (this.data.length - this.nElems >= 20)
/*     */     {
/*     */       
/* 127 */       this.data = Arrays.copyOf(this.data, this.nElems + 10);
/*     */     }
/* 129 */     this.changeCounter++;
/* 130 */     return e;
/*     */   }
/*     */   
/*     */   public boolean remove(E paramE) {
/* 134 */     int i = indexOf(paramE);
/* 135 */     if (i == -1) {
/* 136 */       return false;
/*     */     }
/* 138 */     removeElementAt(i);
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 144 */     return new IndexedListIterator<E>(this);
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 148 */     Object[] arrayOfObject = new Object[size()];
/* 149 */     byte b = 0;
/* 150 */     Iterator<E> iterator = iterator();
/* 151 */     while (iterator.hasNext()) {
/* 152 */       arrayOfObject[b++] = iterator.next();
/*     */     }
/* 154 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/* 158 */     if (size() > paramArrayOfE.length)
/* 159 */       paramArrayOfE = (E[])Arrays.<Object>copyOf((Object[])paramArrayOfE, size()); 
/* 160 */     Iterator<E> iterator = iterator();
/* 161 */     byte b = 0;
/* 162 */     while (iterator.hasNext()) {
/* 163 */       paramArrayOfE[b++] = iterator.next();
/*     */     }
/* 165 */     if (b < paramArrayOfE.length)
/* 166 */       paramArrayOfE[b] = null; 
/* 167 */     return paramArrayOfE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 177 */     if (!(paramObject instanceof ArrayIndexedList)) {
/* 178 */       return false;
/*     */     }
/* 180 */     ArrayIndexedList<Object> arrayIndexedList = (ArrayIndexedList)paramObject;
/*     */     
/* 182 */     if (size() != arrayIndexedList.size()) {
/* 183 */       return false;
/*     */     }
/* 185 */     for (byte b = 0; b < size(); b++) {
/* 186 */       E e1 = get(b);
/* 187 */       E e2 = (E)arrayIndexedList.get(b);
/*     */       
/* 189 */       if (e1 == null && e1 != e2) {
/* 190 */         return false;
/*     */       }
/*     */       
/* 193 */       if (!e1.equals(e2)) {
/* 194 */         return false;
/*     */       }
/*     */     } 
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 204 */     int i = 0;
/*     */     
/* 206 */     for (byte b = 0; b < size(); b++) {
/* 207 */       E e = get(b);
/* 208 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*     */     } 
/* 210 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     String str = "[";
/* 219 */     for (byte b = 0; b < size(); b++) {
/* 220 */       E e = get(b);
/* 221 */       if (e == null) {
/* 222 */         str = str + "null";
/*     */       } else {
/* 224 */         str = str + e.toString();
/* 225 */       }  if (b < size() - 1) str = str + ", "; 
/*     */     } 
/* 227 */     str = str + "]";
/* 228 */     return str;
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\indexedlist\ArrayIndexedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */