/*    */ package es.upm.aedlib.tree;
/*    */ 
/*    */ import es.upm.aedlib.Node;
/*    */ import es.upm.aedlib.Position;
/*    */ import es.upm.aedlib.positionlist.PositionList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TreeNode<E>
/*    */   extends Node<E, Tree<E>>
/*    */   implements Position<E>
/*    */ {
/*    */   private Position<E> parent;
/*    */   private PositionList<Position<E>> children;
/*    */   
/*    */   public TreeNode(Tree<E> paramTree, E paramE, Position<E> paramPosition, PositionList<Position<E>> paramPositionList) {
/* 21 */     super(paramTree, paramE);
/* 22 */     setParent(paramPosition);
/* 23 */     setChildren(paramPositionList);
/*    */   }
/*    */   
/*    */   public PositionList<Position<E>> getChildren() {
/* 27 */     return this.children;
/*    */   }
/*    */   public void setChildren(PositionList<Position<E>> paramPositionList) {
/* 30 */     this.children = paramPositionList;
/*    */   }
/*    */   public Position<E> getParent() {
/* 33 */     return this.parent;
/*    */   }
/*    */   public void setParent(Position<E> paramPosition) {
/* 36 */     this.parent = paramPosition;
/*    */   }
/*    */   
/*    */   public void removeChild(Position<E> paramPosition) throws IllegalArgumentException {
/* 40 */     Position position = this.children.first();
/* 41 */     boolean bool = false;
/*    */     
/* 43 */     while (position != null && !bool) {
/* 44 */       if (((Position)position.element()).equals(paramPosition)) { bool = true; continue; }
/* 45 */        position = this.children.next(position);
/*    */     } 
/*    */     
/* 48 */     if (bool) { this.children.remove(position); }
/* 49 */     else { throw new IllegalArgumentException("no such child"); }
/*    */   
/*    */   }
/*    */   public TreeNode<E> checkNode(Position<E> paramPosition) {
/* 53 */     Node node = super.checkNode(paramPosition);
/*    */     
/* 55 */     if (!(node instanceof TreeNode)) {
/* 56 */       throw new IllegalArgumentException("not a tree node: " + node);
/*    */     }
/*    */     
/* 59 */     return (TreeNode)node;
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\TreeNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */