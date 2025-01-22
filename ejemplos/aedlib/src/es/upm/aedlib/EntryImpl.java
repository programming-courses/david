/*    */ package es.upm.aedlib;
/*    */ 
/*    */ public class EntryImpl<K, V> implements Entry<K, V> {
/*    */   protected K k;
/*    */   protected V v;
/*    */   
/*    */   public EntryImpl(K paramK, V paramV) {
/*  8 */     this.k = paramK;
/*  9 */     this.v = paramV;
/*    */   }
/*    */   
/* 12 */   public K getKey() { return this.k; }
/* 13 */   public V getValue() { return this.v; } public String toString() {
/* 14 */     return "(" + this.k + "," + this.v + ")";
/*    */   }
/*    */   public boolean equals(Object paramObject) {
/* 17 */     if (this == paramObject) return true; 
/* 18 */     if (paramObject instanceof EntryImpl) {
/* 19 */       EntryImpl entryImpl = (EntryImpl)paramObject;
/* 20 */       boolean bool = true;
/*    */       
/* 22 */       if (this.k == null) { bool = (entryImpl.getKey() == null); }
/* 23 */       else { bool = this.k.equals(entryImpl.getKey()); }
/*    */       
/* 25 */       if (bool) {
/* 26 */         if (this.v == null) { bool = (entryImpl.getValue() == null); }
/* 27 */         else { bool = this.v.equals(entryImpl.getValue()); }
/*    */       
/*    */       }
/* 30 */       return bool;
/* 31 */     }  return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 35 */     return this.k.hashCode() + 37 * this.v.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\EntryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */