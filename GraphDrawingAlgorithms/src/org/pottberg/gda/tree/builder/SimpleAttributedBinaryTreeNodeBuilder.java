package org.pottberg.gda.tree.builder;

import org.pottberg.gda.node.NumberedNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleAttributedBinaryTreeNode;
import org.pottberg.gda.tree.SimpleBinaryTree;

public class SimpleAttributedBinaryTreeNodeBuilder<T extends SimpleAttributedBinaryTreeNode<T> & NumberedNode>
    extends BinaryTreeNodeBuilder<T, Long> {

    public SimpleAttributedBinaryTreeNodeBuilder(T parent) {
	super(parent);
    }

    public SimpleAttributedBinaryTreeNodeBuilder(Long value) {
	super(value);
    }

    @Override
    protected BinaryTree<T> createBinaryTree() {
	return new SimpleBinaryTree<>(parent);
    }

}
