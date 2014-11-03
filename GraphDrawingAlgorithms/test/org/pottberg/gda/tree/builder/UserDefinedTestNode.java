package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.AttributedBinaryTreeNodeBase;


public class UserDefinedTestNode extends AttributedBinaryTreeNodeBase<UserDefinedTestNode>{

    public UserDefinedTestNode(Long value) {
	super(value);
    }

    @Override
    public UserDefinedTestNode getThisNode() {
	return this;
    }

}
