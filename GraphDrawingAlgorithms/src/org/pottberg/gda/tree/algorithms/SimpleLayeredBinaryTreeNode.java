package org.pottberg.gda.tree.algorithms;

import java.util.List;

import org.pottberg.gda.tree.SimpleAttributedBinaryTreeNode;

public class SimpleLayeredBinaryTreeNode extends SimpleAttributedBinaryTreeNode<SimpleLayeredBinaryTreeNode> implements LayeredBinaryTreeNode<SimpleLayeredBinaryTreeNode>{

    private List<SimpleLayeredBinaryTreeNode> leftBoundary;
    private List<SimpleLayeredBinaryTreeNode> rightBoundary;
    private int xOffset;

    public SimpleLayeredBinaryTreeNode(Long value) {
	super(value);
    }

    @Override
    public void setLeftBoundary(List<SimpleLayeredBinaryTreeNode> boundary) {
	leftBoundary = boundary;	
    }

    @Override
    public void setRightBoundary(List<SimpleLayeredBinaryTreeNode> boundary) {
	rightBoundary = boundary;
    }

    @Override
    public List<SimpleLayeredBinaryTreeNode> getLeftBoundary() {
	return leftBoundary;
    }

    @Override
    public List<SimpleLayeredBinaryTreeNode> getRightBoundary() {
	return rightBoundary;
    }

    @Override
    public void setXOffset(int xOffset) {
	this.xOffset = xOffset;
    }

    @Override
    public int getXOffset() {
	return xOffset;
    }

    @Override
    public SimpleLayeredBinaryTreeNode getThisNode() {
	return this;
    }
    
}
