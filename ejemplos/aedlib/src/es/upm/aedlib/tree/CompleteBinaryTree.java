package es.upm.aedlib.tree;

import es.upm.aedlib.Position;

public interface CompleteBinaryTree<E> extends Tree<E> {
  boolean isLast(Position<E> paramPosition);
  
  Position<E> add(E paramE);
  
  E remove();
  
  boolean hasLeft(Position<E> paramPosition);
  
  boolean hasRight(Position<E> paramPosition);
  
  Position<E> left(Position<E> paramPosition);
  
  Position<E> right(Position<E> paramPosition);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\CompleteBinaryTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */