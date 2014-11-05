package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.HVBinaryTreeAttributes;

public interface HVBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> extends
    BinaryTreeNodeWrapper<T, HVBinaryTreeNode<T>, HVBinaryTreeAttributes>,
    HVBinaryTreeAttributes {
}
