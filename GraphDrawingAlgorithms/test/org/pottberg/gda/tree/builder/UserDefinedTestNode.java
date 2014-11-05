package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.iterator.ChildNodeBinaryTreeIterable;
import org.pottberg.gda.tree.nodes.AttributedBinaryTreeNodeBase;


public class UserDefinedTestNode extends AttributedBinaryTreeNodeBase<UserDefinedTestNode>{

    public UserDefinedTestNode(Long value) {
	super(value);
    }

    @Override
    public UserDefinedTestNode getThisNode() {
	return this;
    }

    @Override
    public Iterable<UserDefinedTestNode> createChildNodeIterable() {
	return new ChildNodeBinaryTreeIterable<UserDefinedTestNode>(this);
    }

}
