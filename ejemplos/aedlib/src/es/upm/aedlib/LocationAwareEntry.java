package es.upm.aedlib;

public interface LocationAwareEntry<K, V> extends Entry<K, V> {
  K getKey();
  
  V getValue();
  
  Position<LocationAwareEntry<K, V>> getLocation();
  
  void setLocation(Position<LocationAwareEntry<K, V>> paramPosition);
  
  void setKey(K paramK);
  
  void setValue(V paramV);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\LocationAwareEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */