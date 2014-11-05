package org.pottberg.gda.tree;

import org.pottberg.gda.tree.iterator.ChildNodeBinaryTreeIterable;

public final class SimpleBinaryTreeNode extends AttributedBinaryTreeNodeBase<SimpleBinaryTreeNode> {

    public SimpleBinaryTreeNode(Long value) {
	super(value);
    }

    @Override
    public SimpleBinaryTreeNode getThisNode() {
	return this;
    }

    @Override
    public Iterable<SimpleBinaryTreeNode> createChildNodeIterable() {
	return new ChildNodeBinaryTreeIterable<SimpleBinaryTreeNode>(this);
    }

}
