package org.pottberg.gda.tree;

import org.pottberg.gda.node.NumberedNode;

public abstract class SimpleAttributedBinaryTreeNode<T extends SimpleAttributedBinaryTreeNode<T>>
    implements NumberedNode, BinaryTreeNode<T>, DrawableTreeNode<T> {

    protected T parentNode;
    protected T leftNode;
    protected T rightNode;
    protected Long value;
    protected int x;
    protected int y;

    public SimpleAttributedBinaryTreeNode(Long value) {
	this.value = value;
    }

    @Override
    public boolean isRootNode() {
	return parentNode == null;
    }

    @Override
    public T getParentNode() {
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
    public T getLeftNode() {
	return leftNode;
    }

    @Override
    public T getRightNode() {
	return rightNode;
    }

    @Override
    public void setLeftNode(T node) {
	if (leftNode != null) {
	    leftNode.parentNode = null;
	}
	node.parentNode = getThisNode();
	leftNode = node;
    }

    @Override
    public void setRightNode(T node) {
	if (rightNode != null) {
	    rightNode.parentNode = null;
	}
	node.parentNode = getThisNode();
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
    public void setX(int x) {
	this.x = x;
    }

    @Override
    public void setY(int y) {
	this.y = y;
    }

    @Override
    public int getX() {
	return x;
    }

    @Override
    public int getY() {
	return y;
    }

}
