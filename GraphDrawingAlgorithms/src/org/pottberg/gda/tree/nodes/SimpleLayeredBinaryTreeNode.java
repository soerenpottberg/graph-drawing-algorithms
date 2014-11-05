package org.pottberg.gda.tree.nodes;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.LayeredBinaryTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleLayeredBinaryTreeAttributes;

public class SimpleLayeredBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    extends
    SimpleBinaryTreeNodeWrapper<T, LayeredBinaryTreeNode<T>, LayeredBinaryTreeAttributes>
    implements LayeredBinaryTreeNode<T> {

    public SimpleLayeredBinaryTreeNode(T node) {
	super(node);
    }

    @Override
    public void setLeftBoundary(List<LayeredBinaryTreeNode<?>> boundary) {
	getAttributes().setLeftBoundary(boundary);
    }

    @Override
    public void setRightBoundary(List<LayeredBinaryTreeNode<?>> boundary) {
	getAttributes().setRightBoundary(boundary);
    }

    @Override
    public List<LayeredBinaryTreeNode<?>> getLeftBoundary() {
	return getAttributes().getLeftBoundary();
    }

    @Override
    public List<LayeredBinaryTreeNode<?>> getRightBoundary() {
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

    private LayeredBinaryTreeAttributes getAttributes() {
	return getAttributes(LayeredBinaryTreeAttributes.class);
    }

    @Override
    protected LayeredBinaryTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleLayeredBinaryTreeNode<T>(node);
    }

    @Override
    protected LayeredBinaryTreeAttributes createAttributes() {
	return new SimpleLayeredBinaryTreeAttributes<T>();
    }

}