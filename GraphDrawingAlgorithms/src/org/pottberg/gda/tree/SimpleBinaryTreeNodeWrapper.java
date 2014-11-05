package org.pottberg.gda.tree;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.algorithms.BinaryTreeNodeWrapper;

public abstract class SimpleBinaryTreeNodeWrapper<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode, R extends BinaryTreeNodeWrapper<T, R, E>, E>
    extends SimpleTreeNodeWrapper<T, R, E> implements
    BinaryTreeNodeWrapper<T, R, E> {

    public SimpleBinaryTreeNodeWrapper(T node) {
	super(node);
    }

    @Override
    public boolean hasLeftNode() {
	return wrappedNode.hasLeftNode();
    }

    @Override
    public boolean hasRightNode() {
	return wrappedNode.hasRightNode();
    }

    @Override
    public R getLeftNode() {
	return wrapNode(wrappedNode.getLeftNode());
    }

    @Override
    public R getRightNode() {
	return wrapNode(wrappedNode.getRightNode());
    }

    @Override
    public void setLeftNode(R node) {
	wrappedNode.setLeftNode(node.getWrappedNode());
    }

    @Override
    public void setRightNode(R node) {
	wrappedNode.setRightNode(node.getWrappedNode());
    }

}
