package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTree;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;

public class SimpleBinaryTreeNodeBuilder extends
    BinaryTreeNodeBuilder<SimpleBinaryTreeNode, Long> {

    public SimpleBinaryTreeNodeBuilder(SimpleBinaryTreeNode parent) {
	super(parent);
    }

    @Override
    protected BinaryTree<SimpleBinaryTreeNode> createBinaryTree() {
	return new SimpleBinaryTree<SimpleBinaryTreeNode>(parent);
    }

}
