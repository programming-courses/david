package es.upm.aedlib.positionlist;

import es.upm.aedlib.Position;

public interface PositionList<E> extends Iterable<E> {
  int size();
  
  boolean isEmpty();
  
  Position<E> first();
  
  Position<E> last();
  
  Position<E> next(Position<E> paramPosition) throws IllegalArgumentException;
  
  Position<E> prev(Position<E> paramPosition) throws IllegalArgumentException;
  
  void addFirst(E paramE);
  
  void addLast(E paramE);
  
  void addBefore(Position<E> paramPosition, E paramE) throws IllegalArgumentException;
  
  void addAfter(Position<E> paramPosition, E paramE) throws IllegalArgumentException;
  
  E remove(Position<E> paramPosition) throws IllegalArgumentException;
  
  E set(Position<E> paramPosition, E paramE) throws IllegalArgumentException;
  
  Object[] toArray();
  
  E[] toArray(E[] paramArrayOfE);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\positionlist\PositionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */