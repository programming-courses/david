/*     */ package es.upm.aedlib.tree;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LinkedBinaryTree<E>
/*     */   implements BinaryTree<E>
/*     */ {
/*  25 */   private BinaryTreeNode<E> root = null;
/*  26 */   private int size = 0;
/*     */   
/*     */   public int size() {
/*  29 */     return this.size;
/*     */   } public boolean isEmpty() {
/*  31 */     return (this.size == 0);
/*     */   }
/*     */   public Position<E> root() {
/*  34 */     return this.root;
/*     */   }
/*     */   
/*     */   public boolean isRoot(Position<E> paramPosition) throws IllegalArgumentException {
/*  38 */     checkPosition(paramPosition);
/*  39 */     return (paramPosition == root());
/*     */   }
/*     */   
/*     */   public Position<E> parent(Position<E> paramPosition) throws IllegalArgumentException {
/*  43 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/*  44 */     return binaryTreeNode.getParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<Position<E>> children(Position<E> paramPosition) {
/*  49 */     NodePositionList nodePositionList = new NodePositionList();
/*  50 */     if (hasRight(paramPosition)) nodePositionList.addFirst(right(paramPosition)); 
/*  51 */     if (hasLeft(paramPosition)) nodePositionList.addFirst(left(paramPosition)); 
/*  52 */     return (Iterable<Position<E>>)nodePositionList;
/*     */   }
/*     */   
/*     */   public boolean isInternal(Position<E> paramPosition) throws IllegalArgumentException {
/*  56 */     return (hasLeft(paramPosition) || hasRight(paramPosition));
/*     */   }
/*     */   
/*     */   public boolean isExternal(Position<E> paramPosition) throws IllegalArgumentException {
/*  60 */     return !isInternal(paramPosition);
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  64 */     NodePositionList nodePositionList = new NodePositionList();
/*  65 */     if (root() != null) preorderAdd(this.root, (PositionList<E>)nodePositionList);
/*     */     
/*  67 */     return nodePositionList.iterator();
/*     */   }
/*     */   
/*     */   void preorderAdd(Position<E> paramPosition, PositionList<E> paramPositionList) {
/*  71 */     paramPositionList.addLast(paramPosition.element());
/*  72 */     for (Position<E> position : children(paramPosition))
/*  73 */       preorderAdd(position, paramPositionList); 
/*     */   }
/*     */   
/*     */   public E set(Position<E> paramPosition, E paramE) {
/*  77 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/*  78 */     Object object = binaryTreeNode.element();
/*  79 */     binaryTreeNode.setElement(paramE);
/*  80 */     return (E)object;
/*     */   }
/*     */   
/*     */   public void removeSubTree(Position<E> paramPosition) {
/*  84 */     if (isRoot(paramPosition)) {
/*  85 */       this.root = null;
/*  86 */       this.size = 0;
/*     */     } else {
/*  88 */       Position<E> position = parent(paramPosition);
/*  89 */       BinaryTreeNode<E> binaryTreeNode = checkPosition(position);
/*  90 */       int i = countDescendants(paramPosition);
/*     */       
/*  92 */       if (hasLeft(position) && left(position) == paramPosition)
/*  93 */         binaryTreeNode.setLeft((Position<E>)null); 
/*  94 */       if (hasRight(position) && right(position) == paramPosition) {
/*  95 */         binaryTreeNode.setRight((Position<E>)null);
/*     */       }
/*  97 */       this.size -= i;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int countDescendants(Position<E> paramPosition) {
/* 102 */     int i = 1;
/* 103 */     for (Position<E> position : children(paramPosition)) {
/* 104 */       i += countDescendants(position);
/*     */     }
/* 106 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> addRoot(E paramE) throws NonEmptyTreeException {
/* 111 */     if (!isEmpty())
/* 112 */       throw new NonEmptyTreeException("Tree already has a root"); 
/* 113 */     this.size = 1;
/* 114 */     this.root = createNode(paramE, null, null, null);
/* 115 */     return this.root;
/*     */   }
/*     */   
/*     */   public boolean hasLeft(Position<E> paramPosition) throws IllegalArgumentException {
/* 119 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/* 120 */     return (binaryTreeNode.getLeft() != null);
/*     */   }
/*     */   
/*     */   public boolean hasRight(Position<E> paramPosition) {
/* 124 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/* 125 */     return (binaryTreeNode.getRight() != null);
/*     */   }
/*     */   
/*     */   public Position<E> left(Position<E> paramPosition) {
/* 129 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/* 130 */     return binaryTreeNode.getLeft();
/*     */   }
/*     */   
/*     */   public Position<E> right(Position<E> paramPosition) {
/* 134 */     BinaryTreeNode<E> binaryTreeNode = checkPosition(paramPosition);
/* 135 */     return binaryTreeNode.getRight();
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> insertLeft(Position<E> paramPosition, E paramE) throws NodeAlreadyExistsException {
/* 140 */     if (hasLeft(paramPosition)) throw new NodeAlreadyExistsException(); 
/* 141 */     BinaryTreeNode<E> binaryTreeNode1 = checkPosition(paramPosition);
/* 142 */     BinaryTreeNode<E> binaryTreeNode2 = createNode(paramE, paramPosition, null, null);
/* 143 */     binaryTreeNode1.setLeft(binaryTreeNode2);
/* 144 */     this.size++;
/* 145 */     return binaryTreeNode2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> insertRight(Position<E> paramPosition, E paramE) throws NodeAlreadyExistsException {
/* 150 */     if (hasRight(paramPosition)) throw new NodeAlreadyExistsException(); 
/* 151 */     BinaryTreeNode<E> binaryTreeNode1 = checkPosition(paramPosition);
/* 152 */     BinaryTreeNode<E> binaryTreeNode2 = createNode(paramE, paramPosition, null, null);
/* 153 */     binaryTreeNode1.setRight(binaryTreeNode2);
/* 154 */     this.size++;
/* 155 */     return binaryTreeNode2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BinaryTreeNode<E> createNode(E paramE, Position<E> paramPosition1, Position<E> paramPosition2, Position<E> paramPosition3) {
/* 164 */     return new BinaryTreeNode<E>(this, paramE, paramPosition1, paramPosition2, paramPosition3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BinaryTreeNode<E> checkPosition(Position<E> paramPosition) throws IllegalArgumentException {
/* 171 */     if (this.size == 0) {
/* 172 */       throw new IllegalArgumentException("The tree is empty");
/*     */     }
/* 174 */     return this.root.checkNode(paramPosition);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 178 */     if (isEmpty()) return "<emptyTree>"; 
/* 179 */     return printTree(this, root());
/*     */   }
/*     */ 
/*     */   
/*     */   private String printTree(LinkedBinaryTree<E> paramLinkedBinaryTree, Position<E> paramPosition) {
/* 184 */     String str = "";
/*     */     
/* 186 */     if (paramLinkedBinaryTree.hasRight(paramPosition)) {
/* 187 */       str = str + printTree(paramLinkedBinaryTree, paramLinkedBinaryTree.right(paramPosition), false, "");
/*     */     }
/*     */     
/* 190 */     str = str + printNodeValue(paramLinkedBinaryTree, paramPosition);
/*     */     
/* 192 */     if (paramLinkedBinaryTree.hasLeft(paramPosition)) {
/* 193 */       str = str + printTree(paramLinkedBinaryTree, paramLinkedBinaryTree.left(paramPosition), true, "");
/*     */     }
/*     */     
/* 196 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private String printNodeValue(BinaryTree<E> paramBinaryTree, Position<E> paramPosition) {
/* 201 */     return paramPosition.element() + "\n";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String printTree(BinaryTree<E> paramBinaryTree, Position<E> paramPosition, boolean paramBoolean, String paramString) {
/* 208 */     String str = "";
/*     */     
/* 210 */     if (paramBinaryTree.hasRight(paramPosition)) {
/* 211 */       str = str + printTree(paramBinaryTree, paramBinaryTree.right(paramPosition), false, paramString + (paramBoolean ? " |      " : "        "));
/*     */     }
/*     */     
/* 214 */     str = str + paramString;
/* 215 */     if (paramBoolean) {
/* 216 */       str = str + " \\";
/*     */     } else {
/* 218 */       str = str + " /";
/*     */     } 
/*     */     
/* 221 */     str = str + "----- ";
/*     */     
/* 223 */     str = str + printNodeValue(paramBinaryTree, paramPosition);
/* 224 */     if (paramBinaryTree.hasLeft(paramPosition)) {
/* 225 */       str = str + printTree(paramBinaryTree, paramBinaryTree.left(paramPosition), true, paramString + (paramBoolean ? "        " : " |      "));
/*     */     }
/*     */     
/* 228 */     return str;
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\LinkedBinaryTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */