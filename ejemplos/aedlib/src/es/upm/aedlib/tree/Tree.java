package es.upm.aedlib.tree;

import es.upm.aedlib.Position;
import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
  int size();
  
  boolean isEmpty();
  
  E set(Position<E> paramPosition, E paramE) throws IllegalArgumentException;
  
  Position<E> root();
  
  Position<E> parent(Position<E> paramPosition) throws IllegalArgumentException;
  
  boolean isInternal(Position<E> paramPosition);
  
  boolean isExternal(Position<E> paramPosition);
  
  boolean isRoot(Position<E> paramPosition);
  
  Position<E> addRoot(E paramE) throws NonEmptyTreeException;
  
  Iterator<E> iterator();
  
  Iterable<Position<E>> children(Position<E> paramPosition);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\Tree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */