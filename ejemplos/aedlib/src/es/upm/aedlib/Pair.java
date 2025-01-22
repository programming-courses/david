/*    */ package es.upm.aedlib;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Pair<X, Y>
/*    */ {
/*    */   private X left;
/*    */   private Y right;
/*    */   
/*    */   public Pair(X paramX, Y paramY) {
/* 16 */     this.left = paramX;
/* 17 */     this.right = paramY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public X getLeft() {
/* 25 */     return this.left;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Y getRight() {
/* 33 */     return this.right;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLeft(X paramX) {
/* 40 */     this.left = paramX;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRight(Y paramY) {
/* 47 */     this.right = paramY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 55 */     if (paramObject instanceof Pair) {
/* 56 */       Pair pair = (Pair)paramObject;
/* 57 */       boolean bool = true;
/*    */       
/* 59 */       if (this.left == null) { bool = (pair.getLeft() == null); }
/* 60 */       else { bool = this.left.equals(pair.getLeft()); }
/*    */       
/* 62 */       if (bool) {
/* 63 */         if (this.right == null) { bool = (pair.getRight() == null); }
/* 64 */         else { bool = this.right.equals(pair.getRight()); }
/*    */       
/*    */       }
/* 67 */       return bool;
/* 68 */     }  return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     return this.left.hashCode() + 37 * this.right.hashCode();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     return "Pair(" + this.left + "," + this.right + ")";
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */