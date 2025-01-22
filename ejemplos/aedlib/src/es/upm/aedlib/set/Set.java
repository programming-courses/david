package es.upm.aedlib.set;

public interface Set<E> extends Iterable<E> {
  boolean isEmpty();
  
  int size();
  
  boolean add(E paramE);
  
  boolean remove(E paramE);
  
  boolean contains(Object paramObject);
  
  Object[] toArray();
  
  E[] toArray(E[] paramArrayOfE);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\set\Set.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */