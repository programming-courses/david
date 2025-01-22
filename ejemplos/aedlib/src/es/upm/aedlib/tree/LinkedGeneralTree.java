/*     */ package es.upm.aedlib.tree;
/*     */ 
/*     */ import es.upm.aedlib.Position;
/*     */ import es.upm.aedlib.positionlist.NodePositionList;
/*     */ import es.upm.aedlib.positionlist.PositionList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LinkedGeneralTree<E>
/*     */   implements GeneralTree<E>
/*     */ {
/*  22 */   protected TreeNode<E> root = null;
/*  23 */   protected int size = 0;
/*     */ 
/*     */   
/*     */   public Position<E> addRoot(E paramE) throws NonEmptyTreeException {
/*  27 */     if (!isEmpty())
/*  28 */       throw new NonEmptyTreeException("Tree already has a root"); 
/*  29 */     this.size = 1;
/*  30 */     this.root = createNode(paramE, null, null);
/*  31 */     return this.root;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> addChildFirst(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/*  36 */     TreeNode<E> treeNode1 = checkPosition(paramPosition);
/*  37 */     if (treeNode1.getChildren() == null)
/*  38 */       treeNode1.setChildren((PositionList<Position<E>>)new NodePositionList()); 
/*  39 */     PositionList<Position<E>> positionList = treeNode1.getChildren();
/*  40 */     TreeNode<E> treeNode2 = createNode(paramE, paramPosition, null);
/*  41 */     positionList.addFirst(treeNode2);
/*  42 */     this.size++;
/*     */     
/*  44 */     return treeNode2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> addChildLast(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/*  49 */     TreeNode<E> treeNode1 = checkPosition(paramPosition);
/*  50 */     if (treeNode1.getChildren() == null)
/*  51 */       treeNode1.setChildren((PositionList<Position<E>>)new NodePositionList()); 
/*  52 */     PositionList<Position<E>> positionList = treeNode1.getChildren();
/*  53 */     TreeNode<E> treeNode2 = createNode(paramE, paramPosition, null);
/*  54 */     positionList.addLast(treeNode2);
/*  55 */     this.size++;
/*     */     
/*  57 */     return treeNode2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> insertSiblingBefore(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/*  62 */     if (paramPosition == root()) {
/*  63 */       throw new IllegalArgumentException("root cannot have siblings");
/*     */     }
/*  65 */     Position<E> position = parent(paramPosition);
/*  66 */     TreeNode<E> treeNode1 = checkPosition(position);
/*  67 */     PositionList<Position<E>> positionList = treeNode1.getChildren();
/*  68 */     Position position1 = positionList.first();
/*  69 */     boolean bool = false;
/*  70 */     TreeNode<E> treeNode2 = createNode(paramE, parent(paramPosition), null);
/*  71 */     while (position1 != null && !bool) {
/*  72 */       if (position1.element() == paramPosition) {
/*  73 */         positionList.addBefore(position1, treeNode2);
/*  74 */         bool = true; continue;
/*  75 */       }  position1 = positionList.next(position1);
/*     */     } 
/*  77 */     this.size++;
/*  78 */     return treeNode2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Position<E> insertSiblingAfter(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/*  84 */     if (paramPosition == root()) {
/*  85 */       throw new IllegalArgumentException("root cannot have siblings");
/*     */     }
/*  87 */     Position<E> position = parent(paramPosition);
/*  88 */     TreeNode<E> treeNode1 = checkPosition(position);
/*  89 */     PositionList<Position<E>> positionList = treeNode1.getChildren();
/*  90 */     Position position1 = positionList.first();
/*  91 */     boolean bool = false;
/*  92 */     TreeNode<E> treeNode2 = createNode(paramE, parent(paramPosition), null);
/*  93 */     while (position1 != null && !bool) {
/*  94 */       if (position1.element() == paramPosition) {
/*  95 */         positionList.addAfter(position1, treeNode2);
/*  96 */         bool = true; continue;
/*  97 */       }  position1 = positionList.next(position1);
/*     */     } 
/*  99 */     this.size++;
/* 100 */     return treeNode2;
/*     */   }
/*     */   
/*     */   public int size() {
/* 104 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 108 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public boolean isInternal(Position<E> paramPosition) throws IllegalArgumentException {
/* 112 */     return !isExternal(paramPosition);
/*     */   }
/*     */   
/*     */   public boolean isExternal(Position<E> paramPosition) throws IllegalArgumentException {
/* 116 */     TreeNode<E> treeNode = checkPosition(paramPosition);
/* 117 */     return (treeNode.getChildren() == null || treeNode.getChildren().isEmpty());
/*     */   }
/*     */   
/*     */   public boolean isRoot(Position<E> paramPosition) throws IllegalArgumentException {
/* 121 */     checkPosition(paramPosition);
/* 122 */     return (paramPosition == root());
/*     */   }
/*     */   
/*     */   public Position<E> root() {
/* 126 */     return this.root;
/*     */   }
/*     */ 
/*     */   
/*     */   public Position<E> parent(Position<E> paramPosition) throws IllegalArgumentException {
/* 131 */     TreeNode<E> treeNode = checkPosition(paramPosition);
/* 132 */     return treeNode.getParent();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<Position<E>> children(Position<E> paramPosition) throws IllegalArgumentException {
/* 138 */     TreeNode<E> treeNode = checkPosition(paramPosition);
/* 139 */     if (isExternal(paramPosition)) return (Iterable<Position<E>>)new NodePositionList(); 
/* 140 */     return (Iterable<Position<E>>)treeNode.getChildren();
/*     */   }
/*     */   
/*     */   Iterable<Position<E>> positions() {
/* 144 */     NodePositionList nodePositionList = new NodePositionList();
/* 145 */     if (this.size != 0)
/* 146 */       preorderPositions(root(), (PositionList<Position<E>>)nodePositionList); 
/* 147 */     return (Iterable<Position<E>>)nodePositionList;
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/* 151 */     NodePositionList nodePositionList = new NodePositionList();
/* 152 */     Iterable<Position<E>> iterable = positions();
/* 153 */     for (Position<E> position : iterable)
/* 154 */       nodePositionList.addLast(position.element()); 
/* 155 */     return nodePositionList.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(Position<E> paramPosition, E paramE) throws IllegalArgumentException {
/* 160 */     TreeNode<E> treeNode = checkPosition(paramPosition);
/* 161 */     Object object = paramPosition.element();
/* 162 */     treeNode.setElement(paramE);
/* 163 */     return (E)object;
/*     */   }
/*     */   
/*     */   public void removeSubTree(Position<E> paramPosition) {
/* 167 */     if (isRoot(paramPosition)) {
/* 168 */       this.root = null;
/* 169 */       this.size = 0;
/*     */     } else {
/* 171 */       Position<E> position = parent(paramPosition);
/* 172 */       TreeNode<E> treeNode = checkPosition(position);
/* 173 */       int i = countDescendants(paramPosition);
/* 174 */       treeNode.removeChild(paramPosition);
/* 175 */       this.size -= i;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int countDescendants(Position<E> paramPosition) {
/* 180 */     int i = 1;
/* 181 */     for (Position<E> position : children(paramPosition)) {
/* 182 */       i += countDescendants(position);
/*     */     }
/* 184 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TreeNode<E> checkPosition(Position<E> paramPosition) throws IllegalArgumentException {
/* 191 */     if (this.size == 0) {
/* 192 */       throw new IllegalArgumentException("The tree is empty");
/*     */     }
/* 194 */     return this.root.checkNode(paramPosition);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected TreeNode<E> createNode(E paramE, Position<E> paramPosition, PositionList<Position<E>> paramPositionList) {
/* 200 */     return new TreeNode<E>(this, paramE, paramPosition, paramPositionList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preorderPositions(Position<E> paramPosition, PositionList<Position<E>> paramPositionList) throws IllegalArgumentException {
/* 207 */     paramPositionList.addLast(paramPosition);
/* 208 */     for (Position<E> position : children(paramPosition))
/* 209 */       preorderPositions(position, paramPositionList); 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 213 */     StringBuffer stringBuffer = new StringBuffer();
/* 214 */     if (root() == null) {
/* 215 */       return "null";
/*     */     }
/* 217 */     toString(root(), "", false, stringBuffer);
/* 218 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toString(Position<E> paramPosition, String paramString, boolean paramBoolean, StringBuffer paramStringBuffer) {
/* 227 */     paramStringBuffer.append(paramString + (paramBoolean ? "|-- " : "|-- ") + paramPosition.element() + "\n");
/* 228 */     Iterator<Position<E>> iterator = children(paramPosition).iterator();
/* 229 */     Position<E> position = null;
/* 230 */     while (iterator.hasNext()) {
/* 231 */       position = iterator.next();
/* 232 */       if (iterator.hasNext()) {
/* 233 */         toString(position, paramString + (paramBoolean ? "    " : "|   "), false, paramStringBuffer);
/*     */       }
/*     */     } 
/*     */     
/* 237 */     if (!isExternal(paramPosition))
/* 238 */       toString(position, paramString + (paramBoolean ? "    " : "|   "), true, paramStringBuffer); 
/*     */   }
/*     */ }


/* Location:              D:\courses\david\aedlib-2.3.0.jar!\e\\upm\aedlib\tree\LinkedGeneralTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */