package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.HBinaryTreeAttributes;

public interface HBinaryTreeNode <T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> extends
    BinaryTreeNodeWrapper<T, HBinaryTreeNode<T>, HBinaryTreeAttributes>,
    HBinaryTreeAttributes {
}
