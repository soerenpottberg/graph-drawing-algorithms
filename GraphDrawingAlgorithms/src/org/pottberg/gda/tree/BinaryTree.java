package org.pottberg.gda.tree;

public interface BinaryTree<T extends BinaryTreeNode<T>> extends Tree<T> {
    
    @Override
    T getRoot();

}
