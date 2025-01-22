/*    */ package es.upm.aedlib;
/*    */ 
/*    */ 
/*    */ public class LocationAwareEntryImpl<K, V>
/*    */   implements LocationAwareEntry<K, V>
/*    */ {
/*    */   protected K k;
/*    */   protected V v;
/*    */   protected Position<LocationAwareEntry<K, V>> location;
/*    */   
/*    */   public LocationAwareEntryImpl(K paramK, V paramV) {
/* 12 */     this.k = paramK;
/* 13 */     this.v = paramV;
/* 14 */     this.location = null;
/*    */   }
/*    */   
/*    */   public LocationAwareEntryImpl(K paramK, V paramV, Position<LocationAwareEntry<K, V>> paramPosition) {
/* 18 */     this.k = paramK;
/* 19 */     this.v = paramV;
/* 20 */     paramPosition = null;
/*    */   }
/*    */   
/* 23 */   public K getKey() { return this.k; }
/* 24 */   public V getValue() { return this.v; } public Position<LocationAwareEntry<K, V>> getLocation() {
/* 25 */     return this.location;
/*    */   }
/*    */   public void setLocation(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 28 */     this.location = paramPosition;
/*    */   }
/*    */   
/*    */   public void setKey(K paramK) {
/* 32 */     this.k = paramK;
/*    */   }
/*    */   
/*    */   public void setValue(V paramV) {
/* 36 */     this.v = paramV;
/*    */   }
/*    */   public String toString() {
/* 39 */     return "(" + this.k + "," + this.v + ")";
/*    */   }
/*    */   public boolean equals(Object paramObject) {
/* 42 */     if (this == paramObject) return true; 
/* 43 */     if (paramObject instanceof LocationAwareEntryImpl) {
/* 44 */       LocationAwareEntryImpl locationAwareEntryImpl = (LocationAwareEntryImpl)paramObject;
/* 45 */       boolean bool = true;
/*    */       
/* 47 */       if (this.k == null) { bool = (locationAwareEntryImpl.getKey() == null); }
/* 48 */       else { bool = this.k.equals(locationAwareEntryImpl.getKey()); }
/*    */       
/* 50 */       if (bool) {
/* 51 */         if (this.v == null) { bool = (locationAwareEntryImpl.getValue() == null); }
/* 52 */         else { bool = this.v.equals(locationAwareEntryImpl.getValue()); }
/*    */       
/*    */       }
/* 55 */       return bool;
/* 56 */     }  return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     return this.k.hashCode() + 37 * this.v.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\LocationAwareEntryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */