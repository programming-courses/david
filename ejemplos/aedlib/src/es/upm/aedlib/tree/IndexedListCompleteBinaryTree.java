/*     */ package es.upm.aedlib.tree;
/*     */ 
/*     */ import es.upm.aedlib.IndexNode;
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.indexedlist.ArrayIndexedList;
/*     */ import es.upm.aedlib.indexedlist.IndexedList;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
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
/*     */ public class IndexedListCompleteBinaryTree<E>
/*     */   implements CompleteBinaryTree<E>
/*     */ {
/*     */   protected IndexedList<IndexNode<E>> T;
/*     */   
/*     */   public IndexedListCompleteBinaryTree() {
/*  33 */     this.T = (IndexedList<IndexNode<E>>)new ArrayIndexedList();
/*  34 */     this.T.add(0, null);
/*     */   }
/*     */   
/*     */   public int size() {
/*  38 */     return this.T.size() - 1;
/*     */   } public boolean isEmpty() {
/*  40 */     return (size() == 0);
/*     */   }
/*     */   
/*     */   public boolean isInternal(Position<E> paramPosition) throws IllegalArgumentException {
/*  44 */     return hasLeft(paramPosition);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isExternal(Position<E> paramPosition) throws IllegalArgumentException {
/*  49 */     return !isInternal(paramPosition);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRoot(Position<E> paramPosition) throws IllegalArgumentException {
/*  54 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  55 */     return (indexNode.index() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLast(Position<E> paramPosition) throws IllegalArgumentException {
/*  60 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  61 */     return (indexNode == this.T.get(size()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasLeft(Position<E> paramPosition) throws IllegalArgumentException {
/*  66 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  67 */     return (2 * indexNode.index() <= size());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRight(Position<E> paramPosition) throws IllegalArgumentException {
/*  72 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  73 */     return (2 * indexNode.index() + 1 <= size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> root() {
/*  78 */     if (isEmpty()) return null; 
/*  79 */     return (Position<E>)this.T.get(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Position<E> left(Position<E> paramPosition) throws IllegalArgumentException {
/*  85 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  86 */     if (!hasLeft(paramPosition)) return null; 
/*  87 */     return (Position<E>)this.T.get(2 * indexNode.index());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Position<E> right(Position<E> paramPosition) throws IllegalArgumentException {
/*  93 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/*  94 */     if (!hasRight(paramPosition)) return null; 
/*  95 */     return (Position<E>)this.T.get(2 * indexNode.index() + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Position<E> parent(Position<E> paramPosition) throws IllegalArgumentException {
/* 101 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/* 102 */     if (isRoot(paramPosition)) return null; 
/* 103 */     return (Position<E>)this.T.get(indexNode.index() / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Position<E>> children(Position<E> paramPosition) throws IllegalArgumentException {
/* 108 */     NodePositionList nodePositionList = new NodePositionList();
/* 109 */     if (hasLeft(paramPosition))
/* 110 */       nodePositionList.addLast(left(paramPosition)); 
/* 111 */     if (hasRight(paramPosition))
/* 112 */       nodePositionList.addLast(right(paramPosition)); 
/* 113 */     return (Iterable<Position<E>>)nodePositionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Position<E>> positions() {
/* 118 */     ArrayIndexedList arrayIndexedList = new ArrayIndexedList();
/* 119 */     Iterator iterator = this.T.iterator();
/* 120 */     iterator.next();
/* 121 */     while (iterator.hasNext())
/* 122 */       arrayIndexedList.add(arrayIndexedList.size(), iterator.next()); 
/* 123 */     return (Iterable<Position<E>>)arrayIndexedList;
/*     */   }
/*     */ 
/*     */   
/*     */   public E replace(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 128 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/* 129 */     return (E)indexNode.setElement(paramE);
/*     */   }
/*     */   
/*     */   public Position<E> addRoot(E paramE) throws NonEmptyTreeException {
/* 133 */     if (!isEmpty())
/* 134 */       throw new NonEmptyTreeException("Tree already has a root"); 
/* 135 */     return add(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Position<E> add(E paramE) {
/* 141 */     int i = size() + 1;
/* 142 */     IndexNode indexNode = new IndexNode(paramE, i);
/* 143 */     this.T.add(i, indexNode);
/* 144 */     return (Position<E>)indexNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove() throws EmptyTreeException {
/* 149 */     if (isEmpty()) throw new EmptyTreeException("Tree is empty"); 
/* 150 */     return (E)((IndexNode)this.T.removeElementAt(size())).element();
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 155 */     IndexNode<E> indexNode = checkPosition(paramPosition);
/* 156 */     Object object = paramPosition.element();
/* 157 */     indexNode.setElement(paramE);
/* 158 */     return (E)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IndexNode<E> checkPosition(Position<E> paramPosition) throws IllegalArgumentException {
/* 165 */     if (paramPosition == null || !(paramPosition instanceof IndexNode))
/* 166 */       throw new IllegalArgumentException("Position is invalid"); 
/* 167 */     return (IndexNode<E>)paramPosition;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 172 */     ArrayIndexedList arrayIndexedList = new ArrayIndexedList();
/* 173 */     Iterator<IndexNode> iterator = this.T.iterator();
/* 174 */     iterator.next();
/* 175 */     while (iterator.hasNext())
/* 176 */       arrayIndexedList.add(arrayIndexedList.size(), ((IndexNode)iterator.next()).element()); 
/* 177 */     return arrayIndexedList.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 182 */     if (isEmpty()) return "<emptyTree>"; 
/* 183 */     return printTree(this, root());
/*     */   }
/*     */ 
/*     */   
/*     */   private String printTree(CompleteBinaryTree<E> paramCompleteBinaryTree, Position<E> paramPosition) {
/* 188 */     String str = "";
/*     */     
/* 190 */     if (paramCompleteBinaryTree.hasRight(paramPosition)) {
/* 191 */       str = str + printTree(paramCompleteBinaryTree, paramCompleteBinaryTree.right(paramPosition), false, "");
/*     */     }
/*     */     
/* 194 */     str = str + printNodeValue(paramCompleteBinaryTree, paramPosition);
/*     */     
/* 196 */     if (paramCompleteBinaryTree.hasLeft(paramPosition)) {
/* 197 */       str = str + printTree(paramCompleteBinaryTree, paramCompleteBinaryTree.left(paramPosition), true, "");
/*     */     }
/*     */     
/* 200 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private String printNodeValue(CompleteBinaryTree<E> paramCompleteBinaryTree, Position<E> paramPosition) {
/* 205 */     return paramPosition.element() + "\n";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String printTree(CompleteBinaryTree<E> paramCompleteBinaryTree, Position<E> paramPosition, boolean paramBoolean, String paramString) {
/* 212 */     String str = "";
/*     */     
/* 214 */     if (paramCompleteBinaryTree.hasRight(paramPosition)) {
/* 215 */       str = str + printTree(paramCompleteBinaryTree, paramCompleteBinaryTree.right(paramPosition), false, paramString + (paramBoolean ? " |      " : "        "));
/*     */     }
/*     */     
/* 218 */     str = str + paramString;
/* 219 */     if (paramBoolean) {
/* 220 */       str = str + " \\";
/*     */     } else {
/* 222 */       str = str + " /";
/*     */     } 
/*     */     
/* 225 */     str = str + "----- ";
/*     */     
/* 227 */     str = str + printNodeValue(paramCompleteBinaryTree, paramPosition);
/* 228 */     if (paramCompleteBinaryTree.hasLeft(paramPosition)) {
/* 229 */       str = str + printTree(paramCompleteBinaryTree, paramCompleteBinaryTree.left(paramPosition), true, paramString + (paramBoolean ? "        " : " |      "));
/*     */     }
/*     */     
/* 232 */     return str;
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\IndexedListCompleteBinaryTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */