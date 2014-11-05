package org.pottberg.gda.tree;

import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public interface BinaryTree<T extends BinaryTreeNode<T>> extends Tree<T> {
    
    @Override
    T getRoot();

}
