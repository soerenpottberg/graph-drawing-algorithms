package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface BinaryTreeNodeWrapper<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode, R extends BinaryTreeNode<R> & DrawableTreeNode<R>, E>
    extends BinaryTreeNode<R>, TreeNodeWrapper<T, R, E> {

}
