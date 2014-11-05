package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface HVBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> extends
    BinaryTreeNodeWrapper<T, HVBinaryTreeNode<T>, HVBinaryTreeAttributes>,
    HVBinaryTreeAttributes {
}
