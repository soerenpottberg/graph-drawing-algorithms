package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.RadialTreeNode;
import org.pottberg.gda.tree.nodes.SimpleRadialTreeNode;

public class RadialTreeAlgorithm<T extends DrawableTreeNode<T> & AttributedNode>
    implements TreeAlgorithm {

    private Tree<T> tree;

    public RadialTreeAlgorithm(Tree<T> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	for (T node : tree.createPostOrderIterable()) {
	    RadialTreeNode<?> attributedNode = wrapNode(node);
	    calculateNumberOfLeaveNodes(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    RadialTreeNode<?> attributedNode = wrapNode(node);
	    calculateLayer(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    RadialTreeNode<?> attributedNode = wrapNode(node);
	    calculateActualAngle(attributedNode);
	    calculateChildNodeAngleRanges(attributedNode);
	    calculateCoordinates(attributedNode);
	}
    }

    @Override
    public boolean isRadialLayout() {
	return true;
    }

    private void calculateNumberOfLeaveNodes(RadialTreeNode<?> node) {
	if (node.isLeaveNode()) {
	    node.setLeaveNodeCount(1);
	    return;
	}
	int numberOfLeaveNodes = 0;
	for (RadialTreeNode<?> child : node.createChildNodeIterable()) {
	    numberOfLeaveNodes += child.getLeaveNodeCount();
	}
	node.setLeaveNodeCount(numberOfLeaveNodes);
    }

    private void calculateLayer(RadialTreeNode<?> node) {
	if (node.isRootNode()) {
	    node.setLayer(0);
	} else {
	    RadialTreeNode<?> parentNode = node.getParentNode();
	    node.setLayer(parentNode.getLevel() + 1);
	}
    }

    private void calculateChildNodeAngleRanges(RadialTreeNode<?> node) {
	if (node.isRootNode()) {
	    node.setAngleRange(0, 2 * Math.PI);
	}

	int totalLeaveNodeCount = node.getLeaveNodeCount();
	double startAngle = node.getStartAngle();
	for (RadialTreeNode<?> child : node.createChildNodeIterable()) {
	    int currentLeaveNodeCount = child.getLeaveNodeCount();
	    double angle = currentLeaveNodeCount / (double) totalLeaveNodeCount
		* node.getAngle();
	    child.setAngleRange(startAngle, angle);
	    startAngle += angle;
	}
    }

    private void calculateActualAngle(RadialTreeNode<?> node) {
	if (node.isRootNode()) {
	    return;
	}
	RadialTreeNode<?> parentNode = node.getParentNode();
	if (parentNode.isRootNode()) {
	    double startAngle = node.getStartAngle();
	    double angle = node.getAngle();
	    node.setActualAngle(startAngle + angle / 2d);
	    return;
	}
	double delta = Math.acos(parentNode.getLevel()
	    / (double) (node.getLevel()));
	double parentAngle = parentNode.getActualAngle();
	double startAngle = Math.max(node.getStartAngle(), parentAngle - delta);
	double endAngle = Math.min(node.getEndAngle(), parentAngle + delta);
	double angle = endAngle - startAngle;
	node.setActualAngle(startAngle + angle / 2d);
    }

    private void calculateCoordinates(RadialTreeNode<?> node) {
	double angle = node.getActualAngle();
	node.setX(node.getLevel() * Math.cos(angle));
	node.setY(node.getLevel() * Math.sin(angle));
    }

    private RadialTreeNode<?> wrapNode(T node) {
	return new SimpleRadialTreeNode<T>(node);
    }

}
