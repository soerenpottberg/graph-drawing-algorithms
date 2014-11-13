package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.HBinaryTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleHBinaryTreeAttributes;

public class SimpleHBinaryTreeNode<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    extends
    SimpleBinaryTreeNodeWrapper<T, HBinaryTreeNode<T>, HBinaryTreeAttributes>
    implements HBinaryTreeNode<T> {

    public SimpleHBinaryTreeNode(T node) {
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
    public void setYOffset(int offset) {
	getAttributes().setYOffset(offset);
    }

    @Override
    public int getYOffset() {
	return getAttributes().getYOffset();
    }

    private HBinaryTreeAttributes getAttributes() {
	return getAttributes(HBinaryTreeAttributes.class);
    }

    @Override
    protected HBinaryTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleHBinaryTreeNode<T>(node);
    }

    @Override
    protected HBinaryTreeAttributes createAttributes() {
	return new SimpleHBinaryTreeAttributes<T>();
    }

    @Override
    public void setDistance(int distance) {
	getAttributes().setDistance(distance);
    }

    @Override
    public int getDistance() {
	return getAttributes().getDistance();
    }

}