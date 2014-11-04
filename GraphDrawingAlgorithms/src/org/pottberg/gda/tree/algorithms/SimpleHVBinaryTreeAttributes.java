package org.pottberg.gda.tree.algorithms;

import java.util.List;

public class SimpleHVBinaryTreeAttributes implements HVBinaryTreeAttributes {
    private List<HVBinaryTreeNode> leftBoundary;
    private List<HVBinaryTreeNode> rightBoundary;
    private int width;
    private int height;
    private int xOffset;
    private int yOffset;
    
    @Override
    public void setLeftBoundary(List<HVBinaryTreeNode> boundary) {
	leftBoundary = boundary;
    }
    
    @Override
    public void setRightBoundary(List<HVBinaryTreeNode> boundary) {
	rightBoundary = boundary;
    }
    
    @Override
    public List<HVBinaryTreeNode> getLeftBoundary() {
	return leftBoundary;
    }
    
    @Override
    public List<HVBinaryTreeNode> getRightBoundary() {
	return rightBoundary;
    }
    
    @Override
    public void setXOffset(int offset) {
	xOffset = offset;
    }
    
    @Override
    public int getXOffset() {
	return xOffset;
    }

    @Override
    public int getWidth() {
	return width;
    }

    @Override
    public int getHeight() {
	return height;
    }

    @Override
    public void setWidth(int width) {
	this.width = width;
    }

    @Override
    public void setHeight(int height) {
	this.height = height;	
    }

    @Override
    public void setYOffset(int offset) {
	this.yOffset = offset;	
    }

    @Override
    public int getYOffset() {
	return yOffset;
    }
    
}
