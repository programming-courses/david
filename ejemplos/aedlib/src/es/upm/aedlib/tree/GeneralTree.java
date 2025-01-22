package es.upm.aedlib.tree;

import es.upm.aedlib.Position;

public interface GeneralTree<E> extends Tree<E> {
  Position<E> addChildFirst(Position<E> paramPosition, E paramE);
  
  Position<E> addChildLast(Position<E> paramPosition, E paramE);
  
  Position<E> insertSiblingBefore(Position<E> paramPosition, E paramE);
  
  Position<E> insertSiblingAfter(Position<E> paramPosition, E paramE);
  
  void removeSubTree(Position<E> paramPosition);
}


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\GeneralTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */