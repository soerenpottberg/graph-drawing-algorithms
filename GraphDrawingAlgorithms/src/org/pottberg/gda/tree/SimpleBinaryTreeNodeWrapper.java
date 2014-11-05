package org.pottberg.gda.tree;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.algorithms.BinaryTreeNodeWrapper;
import org.pottberg.gda.tree.iterator.WrapperIterable;

public abstract class SimpleBinaryTreeNodeWrapper<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode, R extends BinaryTreeNodeWrapper<T, R, E>, E>
    implements BinaryTreeNodeWrapper<T, R, E> {

    T wrappedNode;

    public SimpleBinaryTreeNodeWrapper(T node) {
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
    public boolean hasLeftNode() {
	return wrappedNode.hasLeftNode();
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
    public boolean hasRightNode() {
	return wrappedNode.hasRightNode();
    }

    @Override
    public R getParentNode() {
	return wrapNode(wrappedNode.getParentNode());
    }

    @Override
    public R getLeftNode() {
	return wrapNode(wrappedNode.getLeftNode());
    }

    @Override
    public R getThisNode() {
	return wrapNode(wrappedNode.getThisNode());
    }

    @Override
    public R getRightNode() {
	return wrapNode(wrappedNode.getRightNode());
    }

    @Override
    public Iterable<R> createChildNodeIterable() {
	Iterable<T> iterable = wrappedNode.createChildNodeIterable();
	return new WrapperIterable<>(iterable, this::wrapNode);
    }
    
    @Override
    public T getWrappedNode() {
	return wrappedNode;
    }

    @Override
    public void setLeftNode(R node) {
	wrappedNode.setLeftNode(node.getWrappedNode());
    }

    @Override
    public void setRightNode(R node) {
	wrappedNode.setRightNode(node.getWrappedNode());
    }
    
    @Override
    public E getAttributes(Class<E> type) {
        E attributes = wrappedNode.getAttributes(type);
        if(attributes == null) {
            attributes = createAttributes();
            wrappedNode.setAttributes(attributes);
        }
        return attributes;
    }

    protected abstract R wrapNode(T node);
    
    protected abstract E createAttributes();

}
