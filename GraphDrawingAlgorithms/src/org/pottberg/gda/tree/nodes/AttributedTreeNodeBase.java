package org.pottberg.gda.tree.nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.node.NumberedNode;

public abstract class AttributedTreeNodeBase<T extends AttributedTreeNodeBase<T>>
    implements NumberedNode, DrawableTreeNode<T>, AttributedNode {

    protected List<T> childNodes;
    protected T parentNode;
    protected Long value;
    protected double x;
    protected double y;
    private Map<Class<?>, Object> attributesMap;

    public AttributedTreeNodeBase(Long value) {
	this.value = value;
	attributesMap = new HashMap<>();
	childNodes = new ArrayList<>();
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
	return childNodes.isEmpty();
    }

    @Override
    public T getChildNode(int index) {
	if(index < 0 || index >= childNodes.size()) {
	    return null;
	}
	return childNodes.get(index);
    }

    @Override
    public void addChildNode(T node) {
	node.parentNode = getThisNode();
	childNodes.add(node);
    }

    @Override
    public int getHeight() {
	if (isLeaveNode()) {
	    return 0;
	}
	int maxHeight = 0;
	for (T childNode : childNodes) {
	    maxHeight = Math.max(maxHeight, childNode.getHeight());
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
	for (T childNode : childNodes) {
	    weight += childNode.getWeight();
	}
	return weight;
    }

}
