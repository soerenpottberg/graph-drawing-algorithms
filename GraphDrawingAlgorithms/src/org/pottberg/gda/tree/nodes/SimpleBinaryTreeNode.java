package org.pottberg.gda.tree.nodes;

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
    
    @Override
    public Iterable<SimpleBinaryTreeNode> createBackwardsChildNodeIterable() {
        // TODO Auto-generated method stub
        return new ChildNodeBinaryTreeIterable<SimpleBinaryTreeNode>(this, true);
    }

}
