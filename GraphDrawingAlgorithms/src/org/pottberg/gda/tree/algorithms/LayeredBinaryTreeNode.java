package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public interface LayeredBinaryTreeNode extends
    BinaryTreeNode<LayeredBinaryTreeNode>,
    DrawableTreeNode<LayeredBinaryTreeNode>,
    LayeredBinaryTreeAttributes {
}
