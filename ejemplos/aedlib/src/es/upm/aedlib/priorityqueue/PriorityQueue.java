package es.upm.aedlib.priorityqueue;

import es.upm.aedlib.Entry;
import es.upm.aedlib.InvalidKeyException;

public interface PriorityQueue<K, V> {
  int size();
  
  boolean isEmpty();
  
  Entry<K, V> first() throws EmptyPriorityQueueException;
  
  Entry<K, V> enqueue(K paramK, V paramV) throws InvalidKeyException;
  
  Entry<K, V> dequeue() throws EmptyPriorityQueueException;
  
  void remove(Entry<K, V> paramEntry) throws InvalidKeyException;
  
  void replaceKey(Entry<K, V> paramEntry, K paramK) throws InvalidKeyException;
  
  void replaceValue(Entry<K, V> paramEntry, V paramV) throws InvalidKeyException;
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\priorityqueue\PriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */