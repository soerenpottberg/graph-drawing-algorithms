package org.pottberg.gda.tree;

import java.util.HashMap;
import java.util.Map;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.node.NumberedNode;

public abstract class AttributedBinaryTreeNodeBase<T extends AttributedBinaryTreeNodeBase<T>>
    implements NumberedNode, BinaryTreeNode<T>, DrawableTreeNode<T>,
    AttributedNode {

    protected T parentNode;
    protected T leftNode;
    protected T rightNode;
    protected Long value;
    protected double x;
    protected double y;
    private Map<Class<?>, Object> attributesMap;

    public AttributedBinaryTreeNodeBase(Long value) {
	this.value = value;
	attributesMap = new HashMap<>();
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
    public void setX(double x) {
	this.x = x;
    }

    @Override
    public void setY(double y) {
	this.y = y;
    }

    @Override
    public double getX() {
	return x;
    }

    @Override
    public double getY() {
	return y;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> V getAttributes(Class<V> type) {
	return (V) attributesMap.get(type);
    }

    @Override
    public <V> void setAttributes(Class<V> type, V attributes) {
	attributesMap.put(type, attributes);
    };

    @Override
    public boolean isLeaveNode() {
	return !hasLeftNode() && !hasRightNode();
    }

    @Override
    public int getHeight() {
	if (isLeaveNode()) {
	    return 0;
	}
	int maxHeight = 0;
	if (hasLeftNode()) {
	    maxHeight = Math.max(maxHeight, getLeftNode().getHeight());
	}
	if (hasRightNode()) {
	    maxHeight = Math.max(maxHeight, getRightNode().getHeight());
	}
	return maxHeight + 1;
    }

    @Override
    public int getDepth() {
	if (isRootNode()) {
	    return 0;
	}
	return getParentNode().getDepth() + 1;
    }

    @Override
    public int getWeight() {
	int weight = 1;
	if (hasLeftNode()) {
	    weight += getLeftNode().getWeight();
	}
	if (hasRightNode()) {
	    weight += getRightNode().getWeight();
	}
	return weight;
    }

}
