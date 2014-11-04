package org.pottberg.gda.tree.algorithms;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public class SimpleHVBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements HVBinaryTreeNode {

    private T node;

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
    public void setX(int x) {
	node.setX(x);
    }

    @Override
    public boolean isRootNode() {
	return node.isRootNode();
    }

    @Override
    public void setY(int y) {
	node.setY(y);
    }

    @Override
    public HVBinaryTreeNode getParentNode() {
	return wrapNode(node.getParentNode());
    }

    @Override
    public int getX() {
	return node.getX();
    }

    @Override
    public boolean hasLeftNode() {
	return node.hasLeftNode();
    }

    @Override
    public int getY() {
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
    public void setLeftBoundary(List<HVBinaryTreeNode> boundary) {
	getAttributes().setLeftBoundary(boundary);
    }

    @Override
    public void setRightBoundary(List<HVBinaryTreeNode> boundary) {
	getAttributes().setRightBoundary(boundary);
    }

    @Override
    public List<HVBinaryTreeNode> getLeftBoundary() {
	return getAttributes().getLeftBoundary();
    }

    @Override
    public List<HVBinaryTreeNode> getRightBoundary() {
	return getAttributes().getRightBoundary();
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
        return new SimpleHVBinaryTreeNode<T>(node);
    }

    private HVBinaryTreeAttributes getAttributes() {
	return node.getAttributes(HVBinaryTreeAttributes.class);
    }

    @Override
    public int getWidth() {
	return getAttributes().getWidth();
    }

    @Override
    public int getHeight() {
	return getAttributes().getHeight();
    }

    @Override
    public void setWidth(int width) {
	getAttributes().setWidth(width);
    }

    @Override
    public void setHeight(int height) {
	getAttributes().setHeight(height);
    }

    @Override
    public void setYOffset(int offset) {
	getAttributes().setYOffset(offset);
    }

    @Override
    public int getYOffset() {
	return getAttributes().getYOffset();
    }

}