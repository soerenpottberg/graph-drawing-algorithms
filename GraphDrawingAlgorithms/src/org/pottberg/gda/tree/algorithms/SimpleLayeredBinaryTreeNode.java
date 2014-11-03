package org.pottberg.gda.tree.algorithms;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public class SimpleLayeredBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements LayeredBinaryTreeNode {

    private T node;

    public SimpleLayeredBinaryTreeNode(T node) {
	if (node == null) {
	    throw new IllegalArgumentException(new NullPointerException());
	}
	this.node = node;
	if (getAttributes() == null) {
	    node.setAttributes(new SimpleLayeredBinaryTreeAttributes());
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
    public LayeredBinaryTreeNode getParentNode() {
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
    public LayeredBinaryTreeNode getThisNode() {
	return wrapNode(node.getThisNode());
    }

    @Override
    public boolean hasRightNode() {
	return node.hasRightNode();
    }

    @Override
    public LayeredBinaryTreeNode getLeftNode() {
	return wrapNode(node.getLeftNode());
    }

    @Override
    public LayeredBinaryTreeNode getRightNode() {
	return wrapNode(node.getRightNode());
    }

    @Override
    public void setLeftNode(LayeredBinaryTreeNode node) {
	node.setLeftNode(node);
    }

    @Override
    public void setRightNode(LayeredBinaryTreeNode node) {
	node.setRightNode(node);
    }

    @Override
    public void setLeftBoundary(List<LayeredBinaryTreeNode> boundary) {
	getAttributes().setLeftBoundary(boundary);
    }

    @Override
    public void setRightBoundary(List<LayeredBinaryTreeNode> boundary) {
	getAttributes().setRightBoundary(boundary);
    }

    @Override
    public List<LayeredBinaryTreeNode> getLeftBoundary() {
	return getAttributes().getLeftBoundary();
    }

    @Override
    public List<LayeredBinaryTreeNode> getRightBoundary() {
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

    private SimpleLayeredBinaryTreeNode<T> wrapNode(T node) {
        if (node == null) {
            return null;
        }
        return new SimpleLayeredBinaryTreeNode<T>(node);
    }

    private LayeredBinaryTreeAttributes getAttributes() {
	return node.getAttributes(LayeredBinaryTreeAttributes.class);
    }

}