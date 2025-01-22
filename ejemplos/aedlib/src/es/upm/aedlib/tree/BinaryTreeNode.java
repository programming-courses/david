/*    */ package es.upm.aedlib.tree;
/*    */ 
/*    */ import es.upm.aedlib.Node;
/*    */ import es.upm.aedlib.Position;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BinaryTreeNode<E>
/*    */   extends Node<E, Tree<E>>
/*    */   implements Position<E>
/*    */ {
/*    */   private Position<E> left;
/*    */   private Position<E> right;
/*    */   private Position<E> parent;
/*    */   
/*    */   public BinaryTreeNode(BinaryTree<E> paramBinaryTree, E paramE, Position<E> paramPosition1, Position<E> paramPosition2, Position<E> paramPosition3) {
/* 18 */     super(paramBinaryTree, paramE);
/* 19 */     this.parent = paramPosition1;
/* 20 */     setLeft(paramPosition2);
/* 21 */     setRight(paramPosition3);
/*    */   }
/*    */   
/*    */   public Position<E> getLeft() {
/* 25 */     return this.left;
/*    */   }
/*    */   public void setLeft(Position<E> paramPosition) {
/* 28 */     this.left = paramPosition;
/*    */   }
/*    */   public Position<E> getRight() {
/* 31 */     return this.right;
/*    */   }
/*    */   public void setRight(Position<E> paramPosition) {
/* 34 */     this.right = paramPosition;
/*    */   }
/*    */   public Position<E> getParent() {
/* 37 */     return this.parent;
/*    */   }
/*    */   public void setParent(Position<E> paramPosition) {
/* 40 */     this.parent = paramPosition;
/*    */   }
/*    */   public BinaryTreeNode<E> checkNode(Position<E> paramPosition) {
/* 43 */     Node node = super.checkNode(paramPosition);
/*    */     
/* 45 */     if (!(node instanceof BinaryTreeNode)) {
/* 46 */       throw new IllegalArgumentException("not a tree node: " + node);
/*    */     }
/*    */     
/* 49 */     return (BinaryTreeNode)node;
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\BinaryTreeNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */