package es.upm.aedlib.map;

import es.upm.aedlib.Entry;
import es.upm.aedlib.InvalidKeyException;
import java.util.Iterator;

public interface Map<K, V> {
  int size();
  
  boolean isEmpty();
  
  boolean containsKey(Object paramObject) throws InvalidKeyException;
  
  V put(K paramK, V paramV) throws InvalidKeyException;
  
  V get(K paramK) throws InvalidKeyException;
  
  V remove(K paramK) throws InvalidKeyException;
  
  Iterator<K> keys();
  
  Iterator<Entry<K, V>> entries();
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\map\Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */