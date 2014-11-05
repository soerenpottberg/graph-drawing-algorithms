package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.RadialTreeAttributes;

public interface RadialTreeNode <T extends DrawableTreeNode<T> & AttributedNode> extends
    TreeNodeWrapper<T, RadialTreeNode<T>, RadialTreeAttributes>,
    RadialTreeAttributes {
}
