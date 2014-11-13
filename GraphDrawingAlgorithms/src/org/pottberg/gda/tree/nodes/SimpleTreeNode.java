package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.tree.iterator.ChildNodeTreeIterable;

public class SimpleTreeNode extends AttributedTreeNodeBase<SimpleTreeNode>{

    public SimpleTreeNode(Long value) {
	super(value);
    }

    @Override
    public SimpleTreeNode getThisNode() {
	return this;
    }

    @Override
    public Iterable<SimpleTreeNode> createChildNodeIterable() {
	return new ChildNodeTreeIterable<SimpleTreeNode>(this);
    }

    @Override
    public Iterable<SimpleTreeNode> createBackwardsChildNodeIterable() {
	return new ChildNodeTreeIterable<SimpleTreeNode>(this, true);
    }

}
