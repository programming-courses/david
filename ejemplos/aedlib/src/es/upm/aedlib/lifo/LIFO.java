package es.upm.aedlib.lifo;

import java.util.EmptyStackException;

public interface LIFO<E> extends Iterable<E> {
  int size();
  
  boolean isEmpty();
  
  E top() throws EmptyStackException;
  
  E pop();
  
  void push(E paramE);
  
  Object[] toArray();
  
  E[] toArray(E[] paramArrayOfE);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\lifo\LIFO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */