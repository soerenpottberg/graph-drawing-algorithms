package org.pottberg.gda.tree;

import org.pottberg.gda.node.NumberedNode;

public final class SimpleBinaryTreeNode implements
    BinaryTreeNode<SimpleBinaryTreeNode>, NumberedNode {

    private SimpleBinaryTreeNode parentNode;
    private SimpleBinaryTreeNode leftNode;
    private SimpleBinaryTreeNode rightNode;
    private Long value;
    
    public SimpleBinaryTreeNode(Long value) {
	this.value = value;
    }

    @Override
    public boolean isRootNode() {
	return parentNode == null;
    }

    @Override
    public SimpleBinaryTreeNode getParentNode() {
	return parentNode;
    }

    @Override
    public boolean hasLeftNode() {
	return leftNode != null;
    }

    @Override
    public boolean hasRightNode() {
	return rightNode != null;
    }

    @Override
    public SimpleBinaryTreeNode getLeftNode() {
	return leftNode;
    }

    @Override
    public SimpleBinaryTreeNode getRightNode() {
	return rightNode;
    }

    @Override
    public void setLeftNode(SimpleBinaryTreeNode node) {
	if(leftNode != null) {
	    leftNode.parentNode = null;
	}
	node.parentNode = this;
	leftNode = node;
    }

    @Override
    public void setRightNode(SimpleBinaryTreeNode node) {
	if(rightNode != null) {
	    rightNode.parentNode = null;
	}
	node.parentNode = this;
	rightNode = node;
    }

    @Override
    public Long getValue() {
	return value;
    }

    @Override
    public void setValue(Long value) {
	this.value = value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public SimpleBinaryTreeNode getThisNode() {
	return this;
    }

}
