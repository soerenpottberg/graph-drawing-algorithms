package org.pottberg.gda.tree.nodes;

import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.LayeredBinaryTreeAttributes;
import org.pottberg.gda.tree.attributes.LayeredTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleLayeredBinaryTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleLayeredTreeAttributes;

public class SimpleLayeredTreeNode<T extends TreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    extends
    SimpleTreeNodeWrapper<T, LayeredTreeNode<T>, LayeredTreeAttributes>
    implements LayeredTreeNode<T> {

    public SimpleLayeredTreeNode(T node) {
	super(node);
    }

    @Override
    public void setLeftBoundary(List<LayeredTreeNode<?>> boundary) {
	getAttributes().setLeftBoundary(boundary);
    }

    @Override
    public void setRightBoundary(List<LayeredTreeNode<?>> boundary) {
	getAttributes().setRightBoundary(boundary);
    }

    @Override
    public List<LayeredTreeNode<?>> getLeftBoundary() {
	return getAttributes().getLeftBoundary();
    }

    @Override
    public List<LayeredTreeNode<?>> getRightBoundary() {
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

    private LayeredTreeAttributes getAttributes() {
	return getAttributes(LayeredTreeAttributes.class);
    }

    @Override
    protected LayeredTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleLayeredTreeNode<T>(node);
    }

    @Override
    protected LayeredTreeAttributes createAttributes() {
	return new SimpleLayeredTreeAttributes<T>();
    }

}