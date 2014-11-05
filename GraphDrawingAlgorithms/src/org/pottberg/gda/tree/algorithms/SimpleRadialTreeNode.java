package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.DrawableTreeNode;
import org.pottberg.gda.tree.iterator.WrapperIterable;

public class SimpleRadialTreeNode<T extends DrawableTreeNode<T> & AttributedNode>
    implements RadialTreeNode {

    private T node;

    public SimpleRadialTreeNode(T node) {
	if (node == null) {
	    throw new IllegalArgumentException(new NullPointerException());
	}
	this.node = node;
	if (getAttributes() == null) {
	    node.setAttributes(new SimpleRadialTreeAttributes());
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
    public RadialTreeNode getParentNode() {
	return wrapNode(node.getParentNode());
    }

    @Override
    public double getX() {
	return node.getX();
    }

    @Override
    public double getY() {
	return node.getY();
    }

    @Override
    public RadialTreeNode getThisNode() {
	return wrapNode(node.getThisNode());
    }

    @Override
    public void setLayer(int layer) {
	getAttributes().setLayer(layer);
    }

    @Override
    public int getLevel() {
	return getAttributes().getLevel();
    }

    private SimpleRadialTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleRadialTreeNode<T>(node);
    }

    private RadialTreeAttributes getAttributes() {
	return node.getAttributes(RadialTreeAttributes.class);
    }

    @Override
    public double getMiddleAngle() {
	return getAttributes().getMiddleAngle();
    }

    @Override
    public Iterable<RadialTreeNode> createChildNodeIterable() {
	return new WrapperIterable<T, RadialTreeNode>(
	    node.createChildNodeIterable(),
	    node -> new SimpleRadialTreeNode<>(node));
    }

    @Override
    public int getLeaveNodeCount() {
	return getAttributes().getLeaveNodeCount();
    }

    @Override
    public void setLeaveNodeCount(int count) {
	getAttributes().setLeaveNodeCount(count);
    }

    @Override
    public void setAngleRange(double startAngle, double angle) {
	getAttributes().setAngleRange(startAngle, angle);
    }

    @Override
    public double getStartAngle() {
	return getAttributes().getStartAngle();
    }
    
    @Override
    public double getEndAngle() {
	return getAttributes().getEndAngle();
    }

    @Override
    public double getAngle() {
	return getAttributes().getAngle();
    }

    @Override
    public boolean isLeaveNode() {
	return node.isLeaveNode();
    }

    @Override
    public String toString() {
	return node.toString();
    }
    
    @Override
    public int getHeight() {
	return node.getHeight();
    }

    @Override
    public int getDepth() {
	return node.getDepth();
    }

    @Override
    public int getWeight() {
	return node.getWeight();
    }

}