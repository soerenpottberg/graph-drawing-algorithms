package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;

public interface BinaryTreeNodeWrapper<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode, R extends BinaryTreeNode<R> & DrawableTreeNode<R>, E>
    extends BinaryTreeNode<R>, TreeNodeWrapper<T, R, E> {

}
