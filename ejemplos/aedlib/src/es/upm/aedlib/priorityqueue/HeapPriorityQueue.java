/*     */ package es.upm.aedlib.priorityqueue;
/*     */ 
/*     */ import es.upm.aedlib.DefaultComparator;
/*     */ import es.upm.aedlib.Entry;
/*     */ import es.upm.aedlib.InvalidKeyException;
/*     */ import es.upm.aedlib.LocationAwareEntry;
/*     */ import es.upm.aedlib.LocationAwareEntryImpl;
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.tree.CompleteBinaryTree;
/*     */ import es.upm.aedlib.tree.IndexedListCompleteBinaryTree;
/*     */ import java.util.Comparator;
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
/*     */ 
/*     */ public class HeapPriorityQueue<K, V>
/*     */   implements PriorityQueue<K, V>
/*     */ {
/*     */   protected CompleteBinaryTree<LocationAwareEntry<K, V>> heap;
/*     */   protected Comparator<K> comp;
/*     */   
/*     */   public HeapPriorityQueue() {
/*  31 */     this.heap = (CompleteBinaryTree<LocationAwareEntry<K, V>>)new IndexedListCompleteBinaryTree();
/*  32 */     this.comp = (Comparator<K>)new DefaultComparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public HeapPriorityQueue(Comparator<K> paramComparator) {
/*  37 */     this.heap = (CompleteBinaryTree<LocationAwareEntry<K, V>>)new IndexedListCompleteBinaryTree();
/*  38 */     this.comp = paramComparator;
/*     */   }
/*     */   
/*     */   public int size() {
/*  42 */     return this.heap.size();
/*     */   }
/*     */   public boolean isEmpty() {
/*  45 */     return (this.heap.size() == 0);
/*     */   }
/*     */   
/*     */   public Entry<K, V> first() throws EmptyPriorityQueueException {
/*  49 */     if (isEmpty())
/*  50 */       throw new EmptyPriorityQueueException("Priority queue is empty"); 
/*  51 */     return (Entry<K, V>)this.heap.root().element();
/*     */   }
/*     */ 
/*     */   
/*     */   public Entry<K, V> enqueue(K paramK, V paramV) throws InvalidKeyException {
/*  56 */     checkKey(paramK);
/*  57 */     LocationAwareEntryImpl locationAwareEntryImpl = new LocationAwareEntryImpl(paramK, paramV);
/*  58 */     Position<LocationAwareEntry<K, V>> position = this.heap.add(locationAwareEntryImpl);
/*  59 */     setLocation(position);
/*  60 */     upHeap(position);
/*  61 */     return (Entry<K, V>)locationAwareEntryImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   public Entry<K, V> dequeue() throws EmptyPriorityQueueException {
/*  66 */     if (isEmpty())
/*  67 */       throw new EmptyPriorityQueueException("Priority queue is empty"); 
/*  68 */     LocationAwareEntry locationAwareEntry = (LocationAwareEntry)this.heap.root().element();
/*  69 */     if (size() == 1) {
/*  70 */       this.heap.remove();
/*     */     } else {
/*  72 */       Position<LocationAwareEntry<K, V>> position = this.heap.root();
/*  73 */       this.heap.set(position, this.heap.remove());
/*  74 */       setLocation(position);
/*  75 */       downHeap(position);
/*     */     } 
/*  77 */     return (Entry<K, V>)locationAwareEntry;
/*     */   }
/*     */   
/*     */   public void remove(Entry<K, V> paramEntry) {
/*  81 */     LocationAwareEntry<K, V> locationAwareEntry = checkEntry(paramEntry);
/*     */     
/*  83 */     if (size() == 1 || this.heap.isLast(locationAwareEntry.getLocation())) {
/*  84 */       this.heap.remove();
/*     */     } else {
/*  86 */       Position<LocationAwareEntry<K, V>> position = locationAwareEntry.getLocation();
/*  87 */       LocationAwareEntry locationAwareEntry1 = (LocationAwareEntry)this.heap.remove();
/*  88 */       this.heap.set(position, locationAwareEntry1);
/*  89 */       setLocation(position);
/*  90 */       upOrDownHeap(position);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void replaceKey(Entry<K, V> paramEntry, K paramK) {
/*  95 */     LocationAwareEntry<K, V> locationAwareEntry = checkEntry(paramEntry);
/*     */     
/*  97 */     Position<LocationAwareEntry<K, V>> position = locationAwareEntry.getLocation();
/*  98 */     locationAwareEntry.setKey(paramK);
/*  99 */     upOrDownHeap(position);
/*     */   }
/*     */   
/*     */   public void replaceValue(Entry<K, V> paramEntry, V paramV) {
/* 103 */     LocationAwareEntry<K, V> locationAwareEntry = checkEntry(paramEntry);
/* 104 */     locationAwareEntry.setValue(paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void upOrDownHeap(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 109 */     LocationAwareEntry locationAwareEntry = (LocationAwareEntry)paramPosition.element();
/*     */     
/* 111 */     boolean bool = false;
/* 112 */     if (!this.heap.isRoot(paramPosition)) {
/* 113 */       Position position = this.heap.parent(paramPosition);
/* 114 */       LocationAwareEntry locationAwareEntry1 = (LocationAwareEntry)position.element();
/* 115 */       if (this.comp.compare((K)locationAwareEntry.getKey(), (K)locationAwareEntry1.getKey()) < 0) {
/* 116 */         upHeap(paramPosition);
/* 117 */         bool = true;
/*     */       } 
/*     */     } 
/* 120 */     if (!bool) downHeap(paramPosition); 
/*     */   }
/*     */   
/*     */   protected LocationAwareEntry<K, V> checkEntry(Entry<K, V> paramEntry) throws InvalidKeyException {
/* 124 */     if (paramEntry instanceof LocationAwareEntry) {
/* 125 */       return (LocationAwareEntry)paramEntry;
/*     */     }
/* 127 */     throw new InvalidKeyException();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkKey(K paramK) throws InvalidKeyException {
/*     */     try {
/* 133 */       this.comp.compare(paramK, paramK);
/*     */     }
/* 135 */     catch (Exception exception) {
/* 136 */       throw new InvalidKeyException("Invalid key");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void upHeap(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 143 */     while (!this.heap.isRoot(paramPosition)) {
/* 144 */       Position<LocationAwareEntry<K, V>> position = this.heap.parent(paramPosition);
/* 145 */       if (this.comp.compare((K)((LocationAwareEntry)position.element()).getKey(), (K)((LocationAwareEntry)paramPosition.element()).getKey()) <= 0)
/* 146 */         break;  swap(position, paramPosition);
/* 147 */       paramPosition = position;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void downHeap(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 153 */     while (this.heap.isInternal(paramPosition)) {
/*     */       Position<LocationAwareEntry<K, V>> position;
/* 155 */       if (!this.heap.hasRight(paramPosition)) {
/* 156 */         position = this.heap.left(paramPosition);
/* 157 */       } else if (this.comp.compare((K)((LocationAwareEntry)this.heap.left(paramPosition).element()).getKey(), (K)((LocationAwareEntry)this.heap.right(paramPosition).element()).getKey()) <= 0) {
/*     */         
/* 159 */         position = this.heap.left(paramPosition);
/*     */       } else {
/* 161 */         position = this.heap.right(paramPosition);
/* 162 */       }  if (this.comp.compare((K)((LocationAwareEntry)position.element()).getKey(), (K)((LocationAwareEntry)paramPosition.element()).getKey()) < 0) {
/* 163 */         swap(paramPosition, position);
/* 164 */         paramPosition = position;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void swap(Position<LocationAwareEntry<K, V>> paramPosition1, Position<LocationAwareEntry<K, V>> paramPosition2) {
/* 173 */     LocationAwareEntry locationAwareEntry = (LocationAwareEntry)paramPosition1.element();
/* 174 */     this.heap.set(paramPosition1, paramPosition2.element());
/* 175 */     this.heap.set(paramPosition2, locationAwareEntry);
/* 176 */     setLocation(paramPosition1);
/* 177 */     setLocation(paramPosition2);
/*     */   }
/*     */   
/*     */   protected void setLocation(Position<LocationAwareEntry<K, V>> paramPosition) {
/* 181 */     ((LocationAwareEntry)paramPosition.element()).setLocation(paramPosition);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 186 */     return this.heap.toString();
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\priorityqueue\HeapPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */