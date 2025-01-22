/*     */ package es.upm.aedlib.set;
/*     */ 
/*     */ import es.upm.aedlib.map.HashTableMap;
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
/*     */ public class HashTableMapSet<E>
/*     */   implements Set<E>
/*     */ {
/*  19 */   private HashTableMap<E, Boolean> elements = new HashTableMap();
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  23 */     return this.elements.isEmpty();
/*     */   }
/*     */   
/*     */   public int size() {
/*  27 */     return this.elements.size();
/*     */   }
/*     */   
/*     */   public boolean add(E paramE) {
/*  31 */     if (!contains(paramE)) {
/*  32 */       this.elements.put(paramE, Boolean.valueOf(true));
/*  33 */       return false;
/*  34 */     }  return true;
/*     */   }
/*     */   
/*     */   public boolean remove(E paramE) {
/*  38 */     Boolean bool = (Boolean)this.elements.remove(paramE);
/*  39 */     return (bool != null);
/*     */   }
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  43 */     return this.elements.containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  47 */     return this.elements.keys();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/*  51 */     Object[] arrayOfObject = new Object[size()];
/*  52 */     Iterator iterator = this.elements.keys();
/*  53 */     byte b = 0;
/*  54 */     while (iterator.hasNext()) {
/*  55 */       arrayOfObject[b++] = iterator.next();
/*     */     }
/*  57 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/*  61 */     if (size() > paramArrayOfE.length)
/*  62 */       paramArrayOfE = (E[])Arrays.<Object>copyOf((Object[])paramArrayOfE, size()); 
/*  63 */     Iterator<E> iterator = iterator();
/*  64 */     byte b = 0;
/*  65 */     while (iterator.hasNext()) {
/*  66 */       paramArrayOfE[b++] = iterator.next();
/*     */     }
/*  68 */     if (b < paramArrayOfE.length)
/*  69 */       paramArrayOfE[b] = null; 
/*  70 */     return paramArrayOfE;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  74 */     StringBuilder stringBuilder = new StringBuilder();
/*  75 */     stringBuilder.append("{");
/*  76 */     Iterator<Object> iterator = this.elements.keys();
/*     */     
/*  78 */     while (iterator.hasNext()) {
/*  79 */       Object object = iterator.next();
/*  80 */       stringBuilder.append(object.toString());
/*  81 */       if (iterator.hasNext()) stringBuilder.append(","); 
/*     */     } 
/*  83 */     stringBuilder.append("}");
/*  84 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int i = 0;
/*     */     
/*  90 */     Iterator<E> iterator = iterator();
/*     */     
/*  92 */     while (iterator.hasNext()) {
/*  93 */       E e = iterator.next();
/*  94 */       i += (e == null) ? 0 : e.hashCode();
/*     */     } 
/*  96 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 100 */     if (this == paramObject) return true;
/*     */     
/* 102 */     if (paramObject instanceof Set) {
/* 103 */       Set set = (Set)paramObject;
/* 104 */       if (size() != set.size()) {
/* 105 */         return false;
/*     */       }
/* 107 */       Iterator<E> iterator = iterator();
/* 108 */       boolean bool = true;
/*     */       
/* 110 */       while (iterator.hasNext() && bool) {
/* 111 */         if (!set.contains(iterator.next())) {
/* 112 */           bool = false;
/*     */         }
/*     */       } 
/* 115 */       return bool;
/*     */     } 
/* 117 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\set\HashTableMapSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */