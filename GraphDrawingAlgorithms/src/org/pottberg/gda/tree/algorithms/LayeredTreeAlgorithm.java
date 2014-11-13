package org.pottberg.gda.tree.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.LayeredTreeNode;
import org.pottberg.gda.tree.nodes.SimpleLayeredTreeNode;

public class LayeredTreeAlgorithm<T extends DrawableTreeNode<T> & AttributedNode>
    implements TreeAlgorithm {

    private static final int MINIMAL_DISTANCE = 1;
    private Tree<T> tree;

    public LayeredTreeAlgorithm(Tree<T> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	for (T node : tree.createPostOrderIterable()) {
	    LayeredTreeNode<?> attributedNode = wrapNode(node);
	    calculateBoundaries(attributedNode);
	    calculateMinimalDistance(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    LayeredTreeNode<?> attributedNode = wrapNode(node);
	    calculateCoordinates(attributedNode);
	}
    }

    private void calculateCoordinates(LayeredTreeNode<?> attributedNode) {
	if (attributedNode.isRootNode()) {
	    attributedNode.setX(0);
	    attributedNode.setY(0);
	} else {
	    LayeredTreeNode<?> parentNode = attributedNode.getParentNode();
	    attributedNode.setX(parentNode.getX() + attributedNode.getXOffset());
	    attributedNode.setY(parentNode.getY() + 1);
	}
    }

    private void calculateMinimalDistance(LayeredTreeNode<?> node) {
	Iterator<? extends LayeredTreeNode<?>> childNodeIterator = node
	    .createChildNodeIterable()
	    .iterator();
	if (!childNodeIterator.hasNext()) {
	    return;
	}
	LayeredTreeNode<?> firstChild = childNodeIterator.next();
	if (!childNodeIterator.hasNext()) {
	    firstChild.setXOffset(0);
	    return;
	}
	LayeredTreeNode<?> leftChild = firstChild;
	LayeredTreeNode<?> rightChild;
	int totalDistance = 0;
	while (childNodeIterator.hasNext()) {
	    rightChild = childNodeIterator.next();
	    totalDistance += calculateMinimalDistance(leftChild, rightChild);
	    leftChild = rightChild;
	}
	if (isOdd(totalDistance)) {
	    totalDistance += 1;
	    firstChild.setXOffset(firstChild.getXOffset() + 1); 
	}

	LayeredTreeNode<?> lastChild = null;
	int minimalDistance = 0;
	for (LayeredTreeNode<?> childNode : node.createChildNodeIterable()) {
	    int offset;
	    if (lastChild == null) {
		offset = -totalDistance / 2 + minimalDistance;
	    } else {
		offset = lastChild.getXOffset() + minimalDistance;
	    }
	    minimalDistance = childNode.getXOffset();
	    childNode.setXOffset(offset);
	    lastChild = childNode;
	}

    }

    private int calculateMinimalDistance(LayeredTreeNode<?> leftChild,
	LayeredTreeNode<?> rightChild) {
	List<LayeredTreeNode<?>> leftBoundary = leftChild.getRightBoundary();
	List<LayeredTreeNode<?>> rightBoundary = rightChild.getLeftBoundary();
	int minimalSize = Math.min(leftBoundary.size(), rightBoundary.size());
	int minimalDistance = MINIMAL_DISTANCE;
	int leftOffset = 0;
	int rightOffset = 0;
	for (int i = 1; i < minimalSize; i++) {
	    leftOffset += leftBoundary.get(i)
		.getXOffset();
	    rightOffset += rightBoundary.get(i)
		.getXOffset();
	    int currentDistance = rightOffset - leftOffset;
	    int requiredDistance = MINIMAL_DISTANCE - currentDistance;
	    minimalDistance = Math.max(minimalDistance, requiredDistance);
	}
	leftChild.setXOffset(minimalDistance);
	return minimalDistance;
    }

    private boolean isOdd(int minimalDistance) {
	return minimalDistance % 2 != 0;
    }

    private void calculateBoundaries(LayeredTreeNode<?> attributedNode) {
	Iterator<? extends LayeredTreeNode<?>> childNodeIterator = attributedNode
	    .createChildNodeIterable()
	    .iterator();
	LayeredTreeNode<?> firstChild = null;
	if (childNodeIterator.hasNext()) {
	    firstChild = childNodeIterator.next();
	}
	if (!childNodeIterator.hasNext()) {
	    calculateBoundariesForMaximalOneChild(attributedNode, firstChild);
	    return;
	}
	List<LayeredTreeNode<?>> leftBoundary = calculateLeftBoundary(attributedNode);
	List<LayeredTreeNode<?>> rightBoundary = calculateRightBoundary(attributedNode);
	attributedNode.setLeftBoundary(leftBoundary);
	attributedNode.setRightBoundary(rightBoundary);
    }

    private void calculateBoundariesForMaximalOneChild(
	LayeredTreeNode<?> attributedNode, LayeredTreeNode<?> firstChild) {
	List<LayeredTreeNode<?>> leftBoundary = new ArrayList<>();
	List<LayeredTreeNode<?>> rightBoundary = new ArrayList<>();
	leftBoundary.add(attributedNode);
	rightBoundary.add(attributedNode);
	if (firstChild != null) {
	    leftBoundary.addAll(firstChild.getLeftBoundary());
	    rightBoundary.addAll(firstChild.getRightBoundary());
	}
	attributedNode.setLeftBoundary(leftBoundary);
	attributedNode.setRightBoundary(rightBoundary);
    }

    private List<LayeredTreeNode<?>> calculateRightBoundary(
	LayeredTreeNode<?> attributedNode) {
	Iterator<? extends LayeredTreeNode<?>> childNodeIterator = attributedNode
	    .createBackwardsChildNodeIterable()
	    .iterator();
	LayeredTreeNode<?> firstChild = childNodeIterator.next();
	return calculateBoundary(attributedNode, firstChild, childNodeIterator,
	    LayeredTreeNode::getRightBoundary);
    }

    private List<LayeredTreeNode<?>> calculateLeftBoundary(
	LayeredTreeNode<?> attributedNode) {
	Iterator<? extends LayeredTreeNode<?>> childNodeIterator = attributedNode
	    .createChildNodeIterable()
	    .iterator();
	LayeredTreeNode<?> firstChild = childNodeIterator.next();
	return calculateBoundary(attributedNode, firstChild, childNodeIterator,
	    LayeredTreeNode::getLeftBoundary);
    }

    private List<LayeredTreeNode<?>> calculateBoundary(
	LayeredTreeNode<?> attributedNode, LayeredTreeNode<?> firstChild,
	Iterator<? extends LayeredTreeNode<?>> childNodeIterator,
	Function<LayeredTreeNode<?>, List<LayeredTreeNode<?>>> boundaryGetter) {

	List<LayeredTreeNode<?>> mainBoundary = boundaryGetter.apply(firstChild);
	List<LayeredTreeNode<?>> boundary = new ArrayList<LayeredTreeNode<?>>();
	boundary.add(attributedNode);
	boundary.addAll(mainBoundary);
	while (childNodeIterator.hasNext()) {
	    LayeredTreeNode<?> childNode = childNodeIterator.next();
	    List<LayeredTreeNode<?>> fallbackBoundary = boundaryGetter.apply(childNode);
	    if (boundary.size() - 1 < fallbackBoundary.size()) {
		boundary.addAll(getAdditionalItems(boundary.size() - 1,
		    fallbackBoundary));
	    }
	}
	return boundary;
    }

    private List<LayeredTreeNode<?>> getAdditionalItems(int size,
	List<LayeredTreeNode<?>> fallbackBoundary) {
	return fallbackBoundary.subList(size,
	    fallbackBoundary.size());
    }

    private LayeredTreeNode<?> wrapNode(T node) {
	return new SimpleLayeredTreeNode<T>(node);
    }

}
