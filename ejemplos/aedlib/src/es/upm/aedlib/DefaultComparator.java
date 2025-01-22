/*    */ package es.upm.aedlib;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultComparator<E>
/*    */   implements Comparator<E>
/*    */ {
/*    */   public int compare(E paramE1, E paramE2) throws ClassCastException {
/* 24 */     return ((Comparable<E>)paramE1).compareTo(paramE2);
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\DefaultComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */