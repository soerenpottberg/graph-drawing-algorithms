package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.LayeredTreeAttributes;

public interface LayeredTreeNode <T extends DrawableTreeNode<T> & AttributedNode> extends
    TreeNodeWrapper<T, LayeredTreeNode<T>, LayeredTreeAttributes>,
    LayeredTreeAttributes {
}
