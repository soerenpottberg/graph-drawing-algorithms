package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface RadialTreeNode <T extends DrawableTreeNode<T> & AttributedNode> extends
    TreeNodeWrapper<T, RadialTreeNode<T>, RadialTreeAttributes>,
    RadialTreeAttributes {
}
