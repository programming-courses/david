package es.upm.aedlib.tree;

import es.upm.aedlib.Position;

public interface BinaryTree<E> extends Tree<E> {
  boolean hasLeft(Position<E> paramPosition);
  
  boolean hasRight(Position<E> paramPosition);
  
  Position<E> left(Position<E> paramPosition);
  
  Position<E> right(Position<E> paramPosition);
  
  Position<E> insertLeft(Position<E> paramPosition, E paramE) throws NodeAlreadyExistsException;
  
  Position<E> insertRight(Position<E> paramPosition, E paramE) throws NodeAlreadyExistsException;
  
  void removeSubTree(Position<E> paramPosition);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\BinaryTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */