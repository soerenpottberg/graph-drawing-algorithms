package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;
import org.pottberg.gda.tree.iterator.WrapperIterable;

public class SimpleHVBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements HVBinaryTreeNode {

    private T node;

    public int getDepth() {
	return node.getDepth();
    }

    public int getWeight() {
	return node.getWeight();
    }

    public SimpleHVBinaryTreeNode(T node) {
	if (node == null) {
	    throw new IllegalArgumentException(new NullPointerException());
	}
	this.node = node;
	if (getAttributes() == null) {
	    node.setAttributes(new SimpleHVBinaryTreeAttributes());
	}
    }

    @Override
    public void setX(double x) {
	node.setX(x);
    }

    @Override
    public boolean isRootNode() {
	return node.isRootNode();
    }

    @Override
    public void setY(double y) {
	node.setY(y);
    }

    @Override
    public HVBinaryTreeNode getParentNode() {
	return wrapNode(node.getParentNode());
    }

    @Override
    public double getX() {
	return node.getX();
    }

    @Override
    public boolean hasLeftNode() {
	return node.hasLeftNode();
    }

    @Override
    public double getY() {
	return node.getY();
    }

    @Override
    public HVBinaryTreeNode getThisNode() {
	return wrapNode(node.getThisNode());
    }

    @Override
    public boolean hasRightNode() {
	return node.hasRightNode();
    }

    @Override
    public HVBinaryTreeNode getLeftNode() {
	return wrapNode(node.getLeftNode());
    }

    @Override
    public HVBinaryTreeNode getRightNode() {
	return wrapNode(node.getRightNode());
    }

    @Override
    public void setLeftNode(HVBinaryTreeNode node) {
	node.setLeftNode(node);
    }

    @Override
    public void setRightNode(HVBinaryTreeNode node) {
	node.setRightNode(node);
    }

    @Override
    public void setXOffset(int offset) {
	getAttributes().setXOffset(offset);
    }

    @Override
    public int getXOffset() {
	return getAttributes().getXOffset();
    }

    private SimpleHVBinaryTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleHVBinaryTreeNode<>(node);
    }

    private HVBinaryTreeAttributes getAttributes() {
	return node.getAttributes(HVBinaryTreeAttributes.class);
    }

    @Override
    public int getBoundingBoxWidth() {
	return getAttributes().getBoundingBoxWidth();
    }

    @Override
    public int getBoundingBoxHeight() {
	return getAttributes().getBoundingBoxHeight();
    }

    public int getHeight() {
	return node.getHeight();
    }

    @Override
    public void setBoundingBoxWidth(int width) {
	getAttributes().setBoundingBoxWidth(width);
    }

    @Override
    public void setBoundingBoxHeight(int height) {
	getAttributes().setBoundingBoxHeight(height);
    }

    @Override
    public void setYOffset(int offset) {
	getAttributes().setYOffset(offset);
    }

    @Override
    public int getYOffset() {
	return getAttributes().getYOffset();
    }

    @Override
    public Iterable<HVBinaryTreeNode> createChildNodeIterable() {
	return new WrapperIterable<T, HVBinaryTreeNode>(
	    node.createChildNodeIterable(),
	    node -> new SimpleHVBinaryTreeNode<>(node));
    }
    
    @Override
    public boolean isLeaveNode() {
	return node.isLeaveNode();
    }

}