package org.pottberg.gda.tree.nodes;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.attributes.RadialTreeAttributes;
import org.pottberg.gda.tree.attributes.SimpleRadialTreeAttributes;

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
    public double getActualAngle() {
	return getAttributes().getActualAngle();
    }

    @Override
    public void setActualAngle(double angle) {
        getAttributes().setActualAngle(angle);
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