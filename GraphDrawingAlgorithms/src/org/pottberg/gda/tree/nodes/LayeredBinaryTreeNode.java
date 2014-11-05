package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.LayeredBinaryTreeAttributes;

public interface LayeredBinaryTreeNode <T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> extends
    BinaryTreeNodeWrapper<T, LayeredBinaryTreeNode<T>, LayeredBinaryTreeAttributes>,
    LayeredBinaryTreeAttributes {
}
