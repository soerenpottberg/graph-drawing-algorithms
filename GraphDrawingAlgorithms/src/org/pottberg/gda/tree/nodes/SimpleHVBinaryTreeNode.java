package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.HVBinaryTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleHVBinaryTreeAttributes;

public class SimpleHVBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    extends SimpleBinaryTreeNodeWrapper<T, HVBinaryTreeNode<T>, HVBinaryTreeAttributes> implements HVBinaryTreeNode<T> {

    public SimpleHVBinaryTreeNode(T node) {
	super(node);
    }

    @Override
    public void setXOffset(int offset) {
	getAttributes().setXOffset(offset);
    }

    @Override
    public int getXOffset() {
	return getAttributes().getXOffset();
    }

    @Override
    public int getBoundingBoxWidth() {
	return getAttributes().getBoundingBoxWidth();
    }

    @Override
    public int getBoundingBoxHeight() {
	return getAttributes().getBoundingBoxHeight();
    }

    @Override
    public void setBoundingBoxWidth(int width) {
	getAttributes().setBoundingBoxWidth(width);
    }

    @Override
    public void setBoundingBoxHeight(int height) {
	getAttributes().setBoundingBoxHeight(height);
    }

    @Override
    public void setYOffset(int offset) {
	getAttributes().setYOffset(offset);
    }

    @Override
    public int getYOffset() {
	return getAttributes().getYOffset();
    }

    @Override
    protected HVBinaryTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleHVBinaryTreeNode<>(node);
    }

    @Override
    protected HVBinaryTreeAttributes createAttributes() {
	return new SimpleHVBinaryTreeAttributes();
    }

    private HVBinaryTreeAttributes getAttributes() {
        return getAttributes(HVBinaryTreeAttributes.class);
    }

}