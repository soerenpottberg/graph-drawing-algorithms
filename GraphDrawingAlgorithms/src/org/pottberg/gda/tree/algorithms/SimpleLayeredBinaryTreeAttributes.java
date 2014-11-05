package org.pottberg.gda.tree.algorithms;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public class SimpleLayeredBinaryTreeAttributes<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode> implements LayeredBinaryTreeAttributes {
    private List<LayeredBinaryTreeNode<?>> leftBoundary;
    private List<LayeredBinaryTreeNode<?>> rightBoundary;
    private int xOffset;
    
    @Override
    public void setLeftBoundary(List<LayeredBinaryTreeNode<?>> boundary) {
	leftBoundary = boundary;
    }
    
    @Override
    public void setRightBoundary(List<LayeredBinaryTreeNode<?>> boundary) {
	rightBoundary = boundary;
    }
    
    @Override
    public List<LayeredBinaryTreeNode<?>> getLeftBoundary() {
	return leftBoundary;
    }
    
    @Override
    public List<LayeredBinaryTreeNode<?>> getRightBoundary() {
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
    
}
