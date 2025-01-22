/*     */ package es.upm.aedlib.set;
/*     */ 
/*     */ import es.upm.aedlib.Position;
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
/*     */ public class PositionListSet<E>
/*     */   implements Set<E>
/*     */ {
/*  19 */   private PositionList<E> elements = (PositionList<E>)new NodePositionList();
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
/*  32 */       this.elements.addLast(paramE);
/*  33 */       return false;
/*  34 */     }  return true;
/*     */   }
/*     */   
/*     */   public boolean remove(E paramE) {
/*  38 */     Position<E> position = findElement(paramE);
/*  39 */     if (position != null) {
/*  40 */       this.elements.remove(position);
/*  41 */       return true;
/*  42 */     }  return false;
/*     */   }
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  46 */     Position<E> position = findElement(paramObject);
/*     */     
/*  48 */     return (position != null);
/*     */   }
/*     */   
/*     */   private Position<E> findElement(Object paramObject) {
/*  52 */     Position<E> position = this.elements.first();
/*  53 */     boolean bool = false;
/*     */     
/*  55 */     while (position != null && !bool) {
/*  56 */       Object object = position.element();
/*  57 */       if (object == paramObject || (object != null && object.equals(paramObject))) {
/*     */         
/*  59 */         bool = true; continue;
/*     */       } 
/*  61 */       position = this.elements.next(position);
/*     */     } 
/*  63 */     return bool ? position : null;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  67 */     return this.elements.iterator();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/*  71 */     return this.elements.toArray();
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/*  75 */     return (E[])this.elements.toArray((Object[])paramArrayOfE);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuilder stringBuilder = new StringBuilder();
/*  80 */     stringBuilder.append("{");
/*  81 */     Iterator<E> iterator = iterator();
/*     */     
/*  83 */     while (iterator.hasNext()) {
/*  84 */       E e = iterator.next();
/*  85 */       if (e == null) { stringBuilder.append("null"); }
/*  86 */       else { stringBuilder.append(e.toString()); }
/*  87 */        if (iterator.hasNext()) stringBuilder.append(","); 
/*     */     } 
/*  89 */     stringBuilder.append("}");
/*  90 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int i = 0;
/*     */     
/*  96 */     Iterator<E> iterator = iterator();
/*     */     
/*  98 */     while (iterator.hasNext()) {
/*  99 */       E e = iterator.next();
/* 100 */       i += (e == null) ? 0 : e.hashCode();
/*     */     } 
/* 102 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (this == paramObject) return true;
/*     */     
/* 108 */     if (paramObject instanceof Set) {
/* 109 */       Set set = (Set)paramObject;
/* 110 */       if (size() != set.size()) {
/* 111 */         return false;
/*     */       }
/* 113 */       Position position = this.elements.first();
/* 114 */       boolean bool = true;
/*     */       
/* 116 */       while (position != null && bool) {
/* 117 */         if (!set.contains(position.element())) {
/* 118 */           bool = false; continue;
/*     */         } 
/* 120 */         position = this.elements.next(position);
/*     */       } 
/*     */       
/* 123 */       return bool;
/*     */     } 
/* 125 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\set\PositionListSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */