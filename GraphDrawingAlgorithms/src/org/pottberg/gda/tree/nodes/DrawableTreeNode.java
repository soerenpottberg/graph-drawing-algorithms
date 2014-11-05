package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.DrawableNode;

public interface DrawableTreeNode<T extends DrawableTreeNode<T>> extends TreeNode<T>, DrawableNode{

}
