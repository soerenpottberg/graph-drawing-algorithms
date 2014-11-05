package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.DrawableTreeNode;
import org.pottberg.gda.tree.SimpleTreeNodeWrapper;

public class SimpleRadialTreeNode<T extends DrawableTreeNode<T> & AttributedNode>
    extends SimpleTreeNodeWrapper<T, RadialTreeNode<T>, RadialTreeAttributes>implements RadialTreeNode<T> {

    public SimpleRadialTreeNode(T node) {
	super(node);
    }

    @Override
    public void setLayer(int layer) {
	getAttributes().setLayer(layer);
    }

    @Override
    public int getLevel() {
	return getAttributes().getLevel();
    }

    @Override
    public double getMiddleAngle() {
	return getAttributes().getMiddleAngle();
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
    protected RadialTreeNode<T> wrapNode(T node) {
	if (node == null) {
	    return null;
	}
	return new SimpleRadialTreeNode<T>(node);
    }

    @Override
    protected RadialTreeAttributes createAttributes() {
	return new SimpleRadialTreeAttributes();
    }

    private RadialTreeAttributes getAttributes() {
        return getAttributes(RadialTreeAttributes.class);
    }

}