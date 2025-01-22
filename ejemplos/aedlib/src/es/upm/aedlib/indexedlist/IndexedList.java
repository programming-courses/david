package es.upm.aedlib.indexedlist;

public interface IndexedList<E> extends Iterable<E> {
  void add(int paramInt, E paramE) throws IndexOutOfBoundsException;
  
  E get(int paramInt) throws IndexOutOfBoundsException;
  
  boolean isEmpty();
  
  int size();
  
  E set(int paramInt, E paramE) throws IndexOutOfBoundsException;
  
  int indexOf(E paramE);
  
  E removeElementAt(int paramInt) throws IndexOutOfBoundsException;
  
  boolean remove(E paramE);
  
  Object[] toArray();
  
  E[] toArray(E[] paramArrayOfE);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\indexedlist\IndexedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */