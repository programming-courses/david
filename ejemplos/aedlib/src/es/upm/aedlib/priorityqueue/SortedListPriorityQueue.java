/*     */ package es.upm.aedlib.priorityqueue;
/*     */ 
/*     */ import es.upm.aedlib.DefaultComparator;
/*     */ import es.upm.aedlib.Entry;
/*     */ import es.upm.aedlib.InvalidKeyException;
/*     */ import es.upm.aedlib.LocationAwareEntry;
/*     */ import es.upm.aedlib.LocationAwareEntryImpl;
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import es.upm.aedlib.positionlist.PositionList;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SortedListPriorityQueue<K, V>
/*     */   implements PriorityQueue<K, V>
/*     */ {
/*     */   protected PositionList<LocationAwareEntry<K, V>> entries;
/*     */   protected Comparator<K> c;
/*     */   protected Position<LocationAwareEntry<K, V>> actionPos;
/*     */   
/*     */   public SortedListPriorityQueue() {
/*  28 */     this.entries = (PositionList<LocationAwareEntry<K, V>>)new NodePositionList();
/*  29 */     this.c = (Comparator<K>)new DefaultComparator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedListPriorityQueue(Comparator<K> paramComparator) {
/*  37 */     this.entries = (PositionList<LocationAwareEntry<K, V>>)new NodePositionList();
/*  38 */     this.c = paramComparator;
/*     */   }
/*     */   public int size() {
/*  41 */     return this.entries.size();
/*     */   } public boolean isEmpty() {
/*  43 */     return this.entries.isEmpty();
/*     */   }
/*     */   public Entry<K, V> first() throws EmptyPriorityQueueException {
/*  46 */     if (this.entries.isEmpty()) {
/*  47 */       throw new EmptyPriorityQueueException("priority queue is empty");
/*     */     }
/*  49 */     return (Entry<K, V>)this.entries.first().element();
/*     */   }
/*     */   
/*     */   public Entry<K, V> enqueue(K paramK, V paramV) throws InvalidKeyException {
/*  53 */     checkKey(paramK);
/*  54 */     LocationAwareEntryImpl locationAwareEntryImpl = new LocationAwareEntryImpl(paramK, paramV);
/*  55 */     insertEntry((LocationAwareEntry<K, V>)locationAwareEntryImpl);
/*  56 */     return (Entry<K, V>)locationAwareEntryImpl;
/*     */   }
/*     */   
/*     */   protected void insertEntry(LocationAwareEntry<K, V> paramLocationAwareEntry) {
/*  60 */     if (this.entries.isEmpty()) {
/*  61 */       this.entries.addFirst(paramLocationAwareEntry);
/*  62 */       this.actionPos = this.entries.first();
/*     */     }
/*  64 */     else if (this.c.compare((K)paramLocationAwareEntry.getKey(), (K)((LocationAwareEntry)this.entries.last().element()).getKey()) > 0) {
/*  65 */       this.entries.addLast(paramLocationAwareEntry);
/*  66 */       this.actionPos = this.entries.last();
/*     */     } else {
/*     */       
/*  69 */       Position position = this.entries.first();
/*  70 */       while (this.c.compare((K)paramLocationAwareEntry.getKey(), (K)((LocationAwareEntry)position.element()).getKey()) > 0) {
/*  71 */         position = this.entries.next(position);
/*     */       }
/*  73 */       this.entries.addBefore(position, paramLocationAwareEntry);
/*  74 */       this.actionPos = this.entries.prev(position);
/*     */     } 
/*  76 */     setLocation(this.actionPos);
/*     */   }
/*     */   
/*     */   public Entry<K, V> dequeue() throws EmptyPriorityQueueException {
/*  80 */     if (this.entries.isEmpty()) {
/*  81 */       throw new EmptyPriorityQueueException("priority queue is empty");
/*     */     }
/*  83 */     return (Entry<K, V>)this.entries.remove(this.entries.first());
/*     */   }
/*     */   
/*     */   public void remove(Entry<K, V> paramEntry) {
/*  87 */     LocationAwareEntry<K, V> locationAwareEntry = checkEntry(paramEntry);
/*  88 */     this.entries.remove(locationAwareEntry.getLocation());
/*     */   }
/*     */   
/*     */   public void replaceKey(Entry<K, V> paramEntry, K paramK) {
/*  92 */     LocationAwareEntry<K, V> locationAwareEntry1 = checkEntry(paramEntry);
/*  93 */     remove((Entry<K, V>)locationAwareEntry1);
/*  94 */     Entry<K, V> entry = enqueue(paramK, (V)paramEntry.getValue());
/*  95 */     LocationAwareEntry<K, V> locationAwareEntry2 = checkEntry(entry);
/*  96 */     locationAwareEntry1.setKey(paramK);
/*  97 */     locationAwareEntry1.setLocation(locationAwareEntry2.getLocation());
/*     */   }
/*     */   
/*     */   public void replaceValue(Entry<K, V> paramEntry, V paramV) {
/* 101 */     LocationAwareEntry<K, V> locationAwareEntry = checkEntry(paramEntry);
/* 102 */     locationAwareEntry.setValue(paramV);
/*     */   }
/*     */   
/*     */   protected LocationAwareEntry<K, V> checkEntry(Entry<K, V> paramEntry) throws InvalidKeyException {
/* 106 */     if (paramEntry instanceof LocationAwareEntry) {
/* 107 */       return (LocationAwareEntry)paramEntry;
/*     */     }
/* 109 */     throw new InvalidKeyException();
/*     */   }
/*     */   
/*     */   protected boolean checkKey(K paramK) throws InvalidKeyException {
/*     */     boolean bool;
/*     */     try {
/* 115 */       bool = (this.c.compare(paramK, paramK) == 0) ? true : false;
/* 116 */     } catch (ClassCastException classCastException) {
/* 117 */       throw new InvalidKeyException("key cannot be compared");
/* 118 */     }  return bool;
/*     */   }
/*     */   
/*     */   protected void setLocation(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 122 */     ((LocationAwareEntry)paramPosition.element()).setLocation(paramPosition);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 126 */     return this.entries.toString();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\priorityqueue\SortedListPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */