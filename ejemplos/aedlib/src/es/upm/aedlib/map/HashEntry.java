/*    */ package es.upm.aedlib.map;
/*    */ 
/*    */ import es.upm.aedlib.Entry;
/*    */ 
/*    */ class HashEntry<K, V> implements Entry<K, V> {
/*    */   protected K key;
/*    */   protected V value;
/*    */   
/*  9 */   public HashEntry(K paramK, V paramV) { this.key = paramK; this.value = paramV; }
/* 10 */   public V getValue() { return this.value; } public K getKey() {
/* 11 */     return this.key;
/*    */   } public V setValue(V paramV) {
/* 13 */     V v = this.value;
/* 14 */     this.value = paramV;
/* 15 */     return v;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 19 */     if (paramObject instanceof HashEntry) {
/* 20 */       HashEntry hashEntry = (HashEntry)paramObject;
/* 21 */       return (hashEntry.getKey().equals(this.key) && hashEntry.getValue().equals(this.value));
/* 22 */     }  return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 27 */     return "(" + this.key + "," + this.value + ")";
/*    */   }
/*    */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\map\HashEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */