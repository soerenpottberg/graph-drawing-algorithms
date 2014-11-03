package org.pottberg.gda.tree;

public final class SimpleBinaryTreeNode extends AttributedBinaryTreeNodeBase<SimpleBinaryTreeNode> {

    public SimpleBinaryTreeNode(Long value) {
	super(value);
    }

    @Override
    public SimpleBinaryTreeNode getThisNode() {
	return this;
    }

}
