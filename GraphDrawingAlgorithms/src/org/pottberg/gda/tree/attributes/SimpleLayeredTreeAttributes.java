package org.pottberg.gda.tree.attributes;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.LayeredTreeNode;
import org.pottberg.gda.tree.nodes.TreeNode;

public class SimpleLayeredTreeAttributes<T extends TreeNode<T> & DrawableTreeNode<T> & AttributedNode> implements LayeredTreeAttributes {
    private List<LayeredTreeNode<?>> leftBoundary;
    private List<LayeredTreeNode<?>> rightBoundary;
    private int xOffset;
    
    @Override
    public void setLeftBoundary(List<LayeredTreeNode<?>> boundary) {
	leftBoundary = boundary;
    }
    
    @Override
    public void setRightBoundary(List<LayeredTreeNode<?>> boundary) {
	rightBoundary = boundary;
    }
    
    @Override
    public List<LayeredTreeNode<?>> getLeftBoundary() {
	return leftBoundary;
    }
    
    @Override
    public List<LayeredTreeNode<?>> getRightBoundary() {
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
