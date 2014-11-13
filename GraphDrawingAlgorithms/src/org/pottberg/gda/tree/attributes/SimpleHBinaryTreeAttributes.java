package org.pottberg.gda.tree.attributes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.TreeNode;

public class SimpleHBinaryTreeAttributes<T extends TreeNode<T> & DrawableTreeNode<T> & AttributedNode> implements HBinaryTreeAttributes {
    private int xOffset;
    private int yOffset;
    private int distance;
    
    @Override
    public void setXOffset(int offset) {
	xOffset = offset;
    }
    
    @Override
    public int getXOffset() {
	return xOffset;
    }

    @Override
    public void setYOffset(int offset) {
	this.yOffset = offset;
    }

    @Override
    public int getYOffset() {
	return yOffset;
    }

    @Override
    public void setDistance(int distance) {
	this.distance = distance;
    }

    @Override
    public int getDistance() {
	return distance;
    }
    
}
