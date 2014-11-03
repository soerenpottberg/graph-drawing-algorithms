package org.pottberg.gda.tree.builder;

import org.pottberg.gda.node.NumberedNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.AttributedBinaryTreeNodeBase;
import org.pottberg.gda.tree.SimpleBinaryTree;

public class UserDefinedBinaryTreeNodeBuilder<T extends AttributedBinaryTreeNodeBase<T> & NumberedNode>
    extends BinaryTreeNodeBuilder<T, Long> {

    public UserDefinedBinaryTreeNodeBuilder(T parent) {
	super(parent);
    }

    public UserDefinedBinaryTreeNodeBuilder(Long value) {
	super(value);
    }

    @Override
    protected BinaryTree<T> createBinaryTree() {
	return new SimpleBinaryTree<>(parent);
    }

}
