package org.pottberg.gda.tree;


public interface BinaryTreeNode<T extends BinaryTreeNode<T>> extends
    TreeNode<T>{

    boolean hasLeftNode();

    boolean hasRightNode();

    T getLeftNode();

    T getRightNode();

    void setLeftNode(T node);

    void setRightNode(T node);

}
