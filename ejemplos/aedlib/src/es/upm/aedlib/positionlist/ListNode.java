/*    */ package es.upm.aedlib.positionlist;
/*    */ 
/*    */ import es.upm.aedlib.Node;
/*    */ import es.upm.aedlib.Position;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ListNode<E>
/*    */   extends Node<E, PositionList<E>>
/*    */   implements Position<E>
/*    */ {
/*    */   private ListNode<E> prev;
/*    */   private ListNode<E> next;
/*    */   
/*    */   public ListNode(PositionList<E> paramPositionList, ListNode<E> paramListNode1, E paramE, ListNode<E> paramListNode2) {
/* 20 */     super(paramPositionList, paramE);
/* 21 */     this.prev = paramListNode1;
/* 22 */     this.next = paramListNode2;
/*    */   }
/*    */   
/*    */   public ListNode<E> getPrev() {
/* 26 */     return this.prev;
/*    */   }
/*    */   
/*    */   public ListNode<E> getNext() {
/* 30 */     return this.next;
/*    */   }
/*    */   
/*    */   public void setPrev(ListNode<E> paramListNode) throws IllegalArgumentException {
/* 34 */     if (paramListNode == null || kinOf(paramListNode)) {
/* 35 */       this.prev = paramListNode;
/*    */     } else {
/* 37 */       throw new IllegalArgumentException();
/*    */     } 
/*    */   }
/*    */   public void setNext(ListNode<E> paramListNode) throws IllegalArgumentException {
/* 41 */     if (paramListNode == null || kinOf(paramListNode)) {
/* 42 */       this.next = paramListNode;
/*    */     } else {
/* 44 */       throw new IllegalArgumentException();
/*    */     } 
/*    */   }
/*    */   public ListNode<E> checkNode(Position<E> paramPosition) {
/* 48 */     Node node = super.checkNode(paramPosition);
/*    */     
/* 50 */     if (!(node instanceof ListNode)) {
/* 51 */       throw new IllegalArgumentException("no a list node: " + node);
/*    */     }
/*    */     
/* 54 */     ListNode<E> listNode = (ListNode)node;
/*    */     
/* 56 */     if (listNode.getPrev() == null || listNode.getNext() == null)
/*    */     {
/* 58 */       throw new IllegalArgumentException("unlinked position");
/*    */     }
/* 60 */     return listNode;
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\positionlist\ListNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */