package es.upm.aedlib.fifo;

public interface FIFO<E> extends Iterable<E> {
  int size();
  
  boolean isEmpty();
  
  E first() throws EmptyFIFOException;
  
  void enqueue(E paramE);
  
  E dequeue() throws EmptyFIFOException;
  
  Object[] toArray();
  
  E[] toArray(E[] paramArrayOfE);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\fifo\FIFO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */