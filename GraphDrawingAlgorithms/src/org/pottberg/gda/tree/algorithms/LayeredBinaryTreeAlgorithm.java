package org.pottberg.gda.tree.algorithms;

import java.util.ArrayList;
import java.util.List;

import org.pottberg.gda.tree.BinaryTree;

public class LayeredBinaryTreeAlgorithm<T extends LayeredBinaryTreeNode<T>>
    implements BinaryTreeAlgorithm {

    private static final int MINIMAL_DISTANCE = 2;
    private BinaryTree<T> tree;

    public LayeredBinaryTreeAlgorithm(BinaryTree<T> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	for (T node : tree.createPostOrderIterable()) {
	    calculateBoundaries(node);
	    calculateMinimalDistance(node);
	}
	for (T node : tree.createPreOrderIterable()) {
	    calculateCoordinates(node);
	}
    }

    private void calculateCoordinates(T node) {
	if (node.isRootNode()) {
	    node.setX(0);
	    node.setY(0);
	} else {
	    T parentNode = node.getParentNode();
	    node.setX(parentNode.getX() + node.getXOffset());
	    node.setY(parentNode.getY() + 1);
	}
    }

    private void calculateMinimalDistance(T node) {
	T leftNode = node.getLeftNode();
	T rightNode = node.getRightNode();
	if (leftNode == null || rightNode == null) {
	    if (rightNode != null) {
		rightNode.setXOffset(0);
	    }
	    if (leftNode != null) {
		leftNode.setXOffset(0);
	    }
	    return;
	}

	List<T> leftBoundary = leftNode.getRightBoundary();
	List<T> rightBoundary = rightNode.getLeftBoundary();
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
	    int requiredDistance = MINIMAL_DISTANCE - currentDistance ;
	    minimalDistance = Math.max(minimalDistance, requiredDistance);
	}
	if (isOdd(minimalDistance)) {
	    minimalDistance += 1;
	}
	int offset = minimalDistance / 2;
	leftNode.setXOffset(-offset);
	rightNode.setXOffset(offset);
    }

    private boolean isOdd(int minimalDistance) {
	return minimalDistance % 2 != 0;
    }

    private void calculateBoundaries(T node) {
	if (!node.hasLeftNode() || !node.hasRightNode()) {
	    calculateBoundariesForMaximalOneChild(node);
	    return;
	}
	List<T> leftBoundary = calculateLeftBoundary(node);
	List<T> rightBoundary = calculateRightBoundary(node);
	node.setLeftBoundary(leftBoundary);
	node.setRightBoundary(rightBoundary);
    }

    private void calculateBoundariesForMaximalOneChild(T node) {
	T leftNode = node.getLeftNode();
	    T rightNode = node.getRightNode();
	List<T> leftBoundary = new ArrayList<>();
	List<T> rightBoundary = new ArrayList<>();
	leftBoundary.add(node);
	rightBoundary.add(node);
	if (rightNode != null) {
	    leftBoundary.addAll(rightNode.getLeftBoundary());
	    rightBoundary.addAll(rightNode.getRightBoundary());
	}
	if (leftNode != null) {
	    leftBoundary.addAll(leftNode.getLeftBoundary());
	    rightBoundary.addAll(leftNode.getRightBoundary());
	}
	node.setLeftBoundary(leftBoundary);
	node.setRightBoundary(rightBoundary);
    }

    private List<T> calculateRightBoundary(T node) {
	T leftNode = node.getLeftNode();
	    T rightNode = node.getRightNode();	    
	List<T> mainBoundary = rightNode.getRightBoundary();
	List<T> fallbackBoundary = leftNode.getRightBoundary();
	return calculateBoundary(node, mainBoundary, fallbackBoundary);
    }

    private List<T> calculateLeftBoundary(T node) {
	T leftNode = node.getLeftNode();
	    T rightNode = node.getRightNode();
	List<T> mainBoundary = leftNode.getLeftBoundary();
	List<T> fallbackBoundary = rightNode.getLeftBoundary();
	return calculateBoundary(node, mainBoundary, fallbackBoundary);
    }

    private List<T> calculateBoundary(T node, List<T> mainBoundary,
	List<T> fallbackBoundary) {
	List<T> boundary = new ArrayList<T>();
	boundary.add(node);
	boundary.addAll(mainBoundary);
	if (mainBoundary.size() < fallbackBoundary.size()) {
	    boundary.addAll(getAdditionalItems(mainBoundary, fallbackBoundary));
	}
	return boundary;
    }

    private List<T> getAdditionalItems(List<T> mainBoundary,
	List<T> fallbackBoundary) {
	return fallbackBoundary.subList(mainBoundary.size(),
	    fallbackBoundary.size());
    }

}
