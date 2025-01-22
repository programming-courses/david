/*     */ package es.upm.aedlib.positionlist;
/*     */ 
/*     */ import es.upm.aedlib.Position;
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
/*     */ public class NodePositionList<E>
/*     */   implements PositionList<E>
/*     */ {
/*     */   private int size;
/*     */   private ListNode<E> header;
/*     */   private ListNode<E> trailer;
/*     */   protected long changeCounter;
/*     */   
/*     */   public NodePositionList() {
/*  33 */     this.size = 0;
/*  34 */     this.header = new ListNode<E>(this, null, null, null);
/*  35 */     this.trailer = new ListNode<E>(this, this.header, null, null);
/*  36 */     this.header.setNext(this.trailer);
/*  37 */     this.changeCounter = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodePositionList(E[] paramArrayOfE) {
/*  45 */     this();
/*  46 */     for (E e : paramArrayOfE) {
/*  47 */       addLast(e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodePositionList(PositionList<E> paramPositionList) {
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
/*     */     //   29: invokevirtual addLast : (Ljava/lang/Object;)V
/*     */     //   32: goto -> 11
/*     */     //   35: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #56	-> 0
/*     */     //   #57	-> 4
/*     */     //   #58	-> 27
/*     */     //   #60	-> 35
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  63 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  67 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public Position<E> first() {
/*  71 */     return isEmpty() ? null : this.header.getNext();
/*     */   }
/*     */   
/*     */   public Position<E> last() {
/*  75 */     return isEmpty() ? null : this.trailer.getPrev();
/*     */   }
/*     */   
/*     */   public Position<E> next(Position<E> paramPosition) throws IllegalArgumentException {
/*  79 */     ListNode<E> listNode = checkPosition(paramPosition);
/*  80 */     return (listNode.getNext() == this.trailer) ? null : listNode.getNext();
/*     */   }
/*     */   
/*     */   public Position<E> prev(Position<E> paramPosition) throws IllegalArgumentException {
/*  84 */     ListNode<E> listNode = checkPosition(paramPosition);
/*  85 */     return (listNode.getPrev() == this.header) ? null : listNode.getPrev();
/*     */   }
/*     */   
/*     */   public void addFirst(E paramE) {
/*  89 */     ListNode<E> listNode = new ListNode<E>(this, this.header, paramE, this.header.getNext());
/*  90 */     this.header.getNext().setPrev(listNode);
/*  91 */     this.header.setNext(listNode);
/*  92 */     this.size++;
/*  93 */     this.changeCounter++;
/*     */   }
/*     */   
/*     */   public void addLast(E paramE) {
/*  97 */     ListNode<E> listNode = new ListNode<E>(this, this.trailer.getPrev(), paramE, this.trailer);
/*  98 */     this.trailer.getPrev().setNext(listNode);
/*  99 */     this.trailer.setPrev(listNode);
/* 100 */     this.size++;
/* 101 */     this.changeCounter++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBefore(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 106 */     ListNode<E> listNode1 = checkPosition(paramPosition);
/* 107 */     ListNode<E> listNode2 = new ListNode<E>(this, listNode1.getPrev(), paramE, listNode1);
/* 108 */     listNode1.getPrev().setNext(listNode2);
/* 109 */     listNode1.setPrev(listNode2);
/* 110 */     this.changeCounter++;
/* 111 */     this.size++;
/*     */   }
/*     */   
/*     */   public void addAfter(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 115 */     ListNode<E> listNode1 = checkPosition(paramPosition);
/* 116 */     ListNode<E> listNode2 = new ListNode<E>(this, listNode1, paramE, listNode1.getNext());
/* 117 */     listNode1.getNext().setPrev(listNode2);
/* 118 */     listNode1.setNext(listNode2);
/* 119 */     this.changeCounter++;
/* 120 */     this.size++;
/*     */   }
/*     */   
/*     */   public E remove(Position<E> paramPosition) throws IllegalArgumentException {
/* 124 */     ListNode<E> listNode = checkPosition(paramPosition);
/* 125 */     Object object = listNode.element();
/* 126 */     listNode.getPrev().setNext(listNode.getNext());
/* 127 */     listNode.getNext().setPrev(listNode.getPrev());
/* 128 */     listNode.setNext((ListNode<E>)null);
/* 129 */     listNode.setPrev((ListNode<E>)null);
/* 130 */     listNode.setElement(null);
/* 131 */     this.size--;
/* 132 */     this.changeCounter++;
/* 133 */     return (E)object;
/*     */   }
/*     */   
/*     */   public E set(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 137 */     ListNode<E> listNode = checkPosition(paramPosition);
/* 138 */     Object object = listNode.element();
/* 139 */     listNode.setElement(paramE);
/* 140 */     return (E)object;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 144 */     return new PositionListIterator<E>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     String str = "[";
/* 152 */     for (Position<E> position = first(); position != null; position = next(position)) {
/* 153 */       if (position.element() == null) {
/* 154 */         str = str + "null";
/*     */       } else {
/* 156 */         str = str + position.element().toString();
/* 157 */       }  if (position != last()) str = str + ", "; 
/*     */     } 
/* 159 */     str = str + "]";
/* 160 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 166 */     if (paramObject == this) return true; 
/* 167 */     if (paramObject instanceof PositionList) {
/* 168 */       Iterator<E> iterator = iterator();
/*     */       
/* 170 */       Iterator iterator1 = ((PositionList)paramObject).iterator();
/* 171 */       boolean bool = true;
/* 172 */       while (iterator.hasNext() && iterator1.hasNext() && (bool = iterator.next().equals(iterator1.next())));
/*     */       
/* 174 */       return (iterator.hasNext() == iterator1.hasNext() && bool);
/* 175 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     int i = 0;
/*     */     
/* 183 */     Position<E> position = first();
/* 184 */     while (position != null) {
/* 185 */       Object object = position.element();
/* 186 */       i = 31 * i + ((object == null) ? 0 : object.hashCode());
/* 187 */       position = next(position);
/*     */     } 
/* 189 */     return i;
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/* 193 */     Object[] arrayOfObject = new Object[size()];
/* 194 */     byte b = 0;
/* 195 */     Iterator<E> iterator = iterator();
/* 196 */     while (iterator.hasNext()) {
/* 197 */       arrayOfObject[b++] = iterator.next();
/*     */     }
/* 199 */     return arrayOfObject;
/*     */   }
/*     */   
/*     */   public E[] toArray(E[] paramArrayOfE) {
/* 203 */     if (size() > paramArrayOfE.length)
/* 204 */       paramArrayOfE = (E[])Arrays.<Object>copyOf((Object[])paramArrayOfE, size()); 
/* 205 */     Iterator<E> iterator = iterator();
/* 206 */     byte b = 0;
/* 207 */     while (iterator.hasNext()) {
/* 208 */       paramArrayOfE[b++] = iterator.next();
/*     */     }
/* 210 */     if (b < paramArrayOfE.length)
/* 211 */       paramArrayOfE[b] = null; 
/* 212 */     return paramArrayOfE;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ListNode<E> checkPosition(Position<E> paramPosition) throws IllegalArgumentException {
/* 217 */     return this.header.checkNode(paramPosition);
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\positionlist\NodePositionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */