package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.iterator.WrapperIterable;

public abstract class SimpleTreeNodeWrapper<T extends DrawableTreeNode<T> & AttributedNode, R extends TreeNodeWrapper<T, R, E>, E>
    implements TreeNodeWrapper<T, R, E> {

    T wrappedNode;

    public SimpleTreeNodeWrapper(T node) {
	if (node == null) {
	    throw new IllegalArgumentException(new NullPointerException());
	}
	wrappedNode = node;
    }

    @Override
    public void setX(double d) {
	wrappedNode.setX(d);
    }

    @Override
    public int getHeight() {
	return wrappedNode.getHeight();
    }

    @Override
    public void setY(double y) {
	wrappedNode.setY(y);
    }

    @Override
    public int getDepth() {
	return wrappedNode.getDepth();
    }

    @Override
    public boolean isRootNode() {
	return wrappedNode.isRootNode();
    }

    @Override
    public double getX() {
	return wrappedNode.getX();
    }

    @Override
    public int getWeight() {
	return wrappedNode.getWeight();
    }

    @Override
    public boolean isLeaveNode() {
	return wrappedNode.isLeaveNode();
    }

    @Override
    public double getY() {
	return wrappedNode.getY();
    }

    @Override
    public R getParentNode() {
	return wrapNode(wrappedNode.getParentNode());
    }

    @Override
    public R getThisNode() {
	return wrapNode(wrappedNode.getThisNode());
    }

    @Override
    public Iterable<R> createChildNodeIterable() {
	Iterable<T> iterable = wrappedNode.createChildNodeIterable();
	return new WrapperIterable<>(iterable, this::wrapNode);
    }
    
    @Override
    public R getChildNode(int index) {
	return wrapNode(wrappedNode.getChildNode(index));
    }

    @Override
    public void addChildNode(R node) {
	wrappedNode.addChildNode(node.getWrappedNode());
    }
    
    @Override
    public T getWrappedNode() {
	return wrappedNode;
    }

    @Override
    public E getAttributes(Class<E> type) {
        E attributes = wrappedNode.getAttributes(type);
        if(attributes == null) {
            attributes = createAttributes();
            wrappedNode.setAttributes(type, attributes);
        }
        return attributes;
    }

    protected abstract R wrapNode(T node);
    
    protected abstract E createAttributes();

}
