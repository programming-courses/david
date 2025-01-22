/*     */ package es.upm.aedlib.map;
/*     */ 
/*     */ import es.upm.aedlib.Entry;
/*     */ import es.upm.aedlib.InvalidKeyException;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
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
/*     */ public class HashTableMap<K, V>
/*     */   implements Map<K, V>
/*     */ {
/*  22 */   protected Entry<K, V> AVAILABLE = new HashEntry<K, V>(null, null); protected int prime; protected int capacity; protected Entry<K, V>[] bucket;
/*  23 */   protected int n = 0;
/*     */   
/*     */   protected long scale;
/*     */   protected long shift;
/*     */   
/*     */   public HashTableMap() {
/*  29 */     this(109345121, 1000);
/*     */   }
/*     */   public HashTableMap(int paramInt) {
/*  32 */     this(109345121, paramInt);
/*     */   }
/*     */   
/*     */   public HashTableMap(int paramInt1, int paramInt2) {
/*  36 */     this.prime = paramInt1;
/*  37 */     this.capacity = paramInt2;
/*  38 */     this.bucket = newEntry(this.capacity);
/*  39 */     Random random = new Random();
/*  40 */     this.scale = (random.nextInt(this.prime - 1) + 1);
/*  41 */     this.shift = random.nextInt(this.prime);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkKey(Object paramObject) {
/*  46 */     if (paramObject == null) throw new InvalidKeyException("Invalid key: null.");
/*     */   
/*     */   }
/*     */   
/*     */   protected int hashValue(Object paramObject) {
/*  51 */     return (int)(Math.abs(paramObject.hashCode() * this.scale + this.shift) % this.prime % this.capacity);
/*     */   }
/*     */   
/*     */   public int size() {
/*  55 */     return this.n;
/*     */   } public boolean isEmpty() {
/*  57 */     return (this.n == 0);
/*     */   }
/*     */   public Iterator<K> keys() {
/*  60 */     NodePositionList nodePositionList = new NodePositionList();
/*  61 */     for (byte b = 0; b < this.capacity; b++) {
/*  62 */       if (this.bucket[b] != null && this.bucket[b] != this.AVAILABLE)
/*  63 */         nodePositionList.addLast(this.bucket[b].getKey()); 
/*  64 */     }  return nodePositionList.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int findEntry(Object paramObject) throws InvalidKeyException {
/*  70 */     int i = -1;
/*  71 */     checkKey(paramObject);
/*  72 */     int j = hashValue(paramObject);
/*  73 */     int k = j;
/*     */     do {
/*  75 */       Entry<K, V> entry = this.bucket[j];
/*  76 */       if (entry == null) {
/*  77 */         if (i < 0)
/*  78 */           i = j; 
/*     */         break;
/*     */       } 
/*  81 */       if (paramObject.equals(entry.getKey()))
/*  82 */         return j; 
/*  83 */       if (entry == this.AVAILABLE && 
/*  84 */         i < 0) {
/*  85 */         i = j;
/*     */       }
/*  87 */       j = (j + 1) % this.capacity;
/*  88 */     } while (j != k);
/*  89 */     return -(i + 1);
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) throws InvalidKeyException {
/*  93 */     return (findEntry(paramObject) >= 0);
/*     */   }
/*     */   
/*     */   public V get(K paramK) throws InvalidKeyException {
/*  97 */     int i = findEntry(paramK);
/*  98 */     if (i < 0) return null; 
/*  99 */     return (V)this.bucket[i].getValue();
/*     */   }
/*     */   
/*     */   public V put(K paramK, V paramV) throws InvalidKeyException {
/* 103 */     int i = findEntry(paramK);
/* 104 */     if (i >= 0)
/* 105 */       return ((HashEntry<?, V>)this.bucket[i]).setValue(paramV); 
/* 106 */     if (this.n >= this.capacity / 2) {
/* 107 */       rehash();
/* 108 */       i = findEntry(paramK);
/*     */     } 
/* 110 */     this.bucket[-i - 1] = new HashEntry<K, V>(paramK, paramV);
/* 111 */     this.n++;
/* 112 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void rehash() {
/* 117 */     this.capacity = 2 * this.capacity;
/* 118 */     Entry<K, V>[] arrayOfEntry = this.bucket;
/* 119 */     this.bucket = newEntry(this.capacity);
/* 120 */     Random random = new Random();
/* 121 */     this.scale = (random.nextInt(this.prime - 1) + 1);
/* 122 */     this.shift = random.nextInt(this.prime);
/* 123 */     for (byte b = 0; b < arrayOfEntry.length; b++) {
/* 124 */       Entry<K, V> entry = arrayOfEntry[b];
/* 125 */       if (entry != null && entry != this.AVAILABLE) {
/* 126 */         int i = -1 - findEntry(entry.getKey());
/* 127 */         this.bucket[i] = entry;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Entry<K, V>[] newEntry(int paramInt) {
/* 134 */     return (Entry<K, V>[])new Entry[paramInt];
/*     */   }
/*     */   
/*     */   public V remove(K paramK) throws InvalidKeyException {
/* 138 */     int i = findEntry(paramK);
/* 139 */     if (i < 0) return null; 
/* 140 */     Object object = this.bucket[i].getValue();
/* 141 */     this.bucket[i] = this.AVAILABLE;
/* 142 */     this.n--;
/* 143 */     return (V)object;
/*     */   }
/*     */   
/*     */   public Iterator<Entry<K, V>> entries() {
/* 147 */     NodePositionList nodePositionList = new NodePositionList();
/* 148 */     for (byte b = 0; b < this.capacity; b++) {
/* 149 */       if (this.bucket[b] != null && this.bucket[b] != this.AVAILABLE)
/* 150 */         nodePositionList.addLast(this.bucket[b]); 
/* 151 */     }  return nodePositionList.iterator();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 155 */     StringBuilder stringBuilder = new StringBuilder();
/* 156 */     stringBuilder.append("[");
/* 157 */     Iterator<Entry<K, V>> iterator = entries();
/* 158 */     while (iterator.hasNext()) {
/* 159 */       if (stringBuilder.length() != 1)
/* 160 */         stringBuilder.append(","); 
/* 161 */       stringBuilder.append(iterator.next());
/*     */     } 
/* 163 */     stringBuilder.append("]");
/* 164 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\map\HashTableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */