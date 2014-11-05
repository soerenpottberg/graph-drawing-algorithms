package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface LayeredBinaryTreeNode <T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> extends
    BinaryTreeNodeWrapper<T, LayeredBinaryTreeNode<T>, LayeredBinaryTreeAttributes>,
    LayeredBinaryTreeAttributes {
}
