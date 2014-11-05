package org.pottberg.gda.tree.algorithms;

import java.util.ArrayList;
import java.util.List;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public class LayeredBinaryTreeAlgorithm<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements BinaryTreeAlgorithm {

    private static final int MINIMAL_DISTANCE = 2;
    private BinaryTree<T> tree;

    public LayeredBinaryTreeAlgorithm(BinaryTree<T> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	for (T node : tree.createPostOrderIterable()) {
	    LayeredBinaryTreeNode<?> attributedNode = new SimpleLayeredBinaryTreeNode<T>(node);
	    calculateBoundaries(attributedNode);
	    calculateMinimalDistance(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    LayeredBinaryTreeNode<?> attributedNode = new SimpleLayeredBinaryTreeNode<T>(node);
	    calculateCoordinates(attributedNode);
	}
    }

    private void calculateCoordinates(LayeredBinaryTreeNode<?> attributedNode) {
	if (attributedNode.isRootNode()) {
	    attributedNode.setX(0);
	    attributedNode.setY(0);
	} else {
	    LayeredBinaryTreeNode<?> parentNode = attributedNode.getParentNode();
	    attributedNode.setX(parentNode.getX() + attributedNode.getXOffset());
	    attributedNode.setY(parentNode.getY() + 1);
	}
    }

    private void calculateMinimalDistance(LayeredBinaryTreeNode<?> attributedNode) {
	LayeredBinaryTreeNode<?> leftNode = attributedNode.getLeftNode();
	LayeredBinaryTreeNode<?> rightNode = attributedNode.getRightNode();
	if (leftNode == null || rightNode == null) {
	    if (rightNode != null) {
		rightNode.setXOffset(0);
	    }
	    if (leftNode != null) {
		leftNode.setXOffset(0);
	    }
	    return;
	}

	List<LayeredBinaryTreeNode<?>> leftBoundary = leftNode.getRightBoundary();
	List<LayeredBinaryTreeNode<?>> rightBoundary = rightNode.getLeftBoundary();
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

    private void calculateBoundaries(LayeredBinaryTreeNode<?> attributedNode) {
	if (!attributedNode.hasLeftNode() || !attributedNode.hasRightNode()) {
	    calculateBoundariesForMaximalOneChild(attributedNode);
	    return;
	}
	List<LayeredBinaryTreeNode<?>> leftBoundary = calculateLeftBoundary(attributedNode);
	List<LayeredBinaryTreeNode<?>> rightBoundary = calculateRightBoundary(attributedNode);
	attributedNode.setLeftBoundary(leftBoundary);
	attributedNode.setRightBoundary(rightBoundary);
    }

    private void calculateBoundariesForMaximalOneChild(LayeredBinaryTreeNode<?> attributedNode) {
	LayeredBinaryTreeNode<?> leftNode = attributedNode.getLeftNode();
	    LayeredBinaryTreeNode<?> rightNode = attributedNode.getRightNode();
	List<LayeredBinaryTreeNode<?>> leftBoundary = new ArrayList<>();
	List<LayeredBinaryTreeNode<?>> rightBoundary = new ArrayList<>();
	leftBoundary.add(attributedNode);
	rightBoundary.add(attributedNode);
	if (rightNode != null) {
	    leftBoundary.addAll(rightNode.getLeftBoundary());
	    rightBoundary.addAll(rightNode.getRightBoundary());
	}
	if (leftNode != null) {
	    leftBoundary.addAll(leftNode.getLeftBoundary());
	    rightBoundary.addAll(leftNode.getRightBoundary());
	}
	attributedNode.setLeftBoundary(leftBoundary);
	attributedNode.setRightBoundary(rightBoundary);
    }

    private List<LayeredBinaryTreeNode<?>> calculateRightBoundary(LayeredBinaryTreeNode<?> attributedNode) {
	LayeredBinaryTreeNode<?> leftNode = attributedNode.getLeftNode();
	    LayeredBinaryTreeNode<?> rightNode = attributedNode.getRightNode();	    
	List<LayeredBinaryTreeNode<?>> mainBoundary = rightNode.getRightBoundary();
	List<LayeredBinaryTreeNode<?>> fallbackBoundary = leftNode.getRightBoundary();
	return calculateBoundary(attributedNode, mainBoundary, fallbackBoundary);
    }

    private List<LayeredBinaryTreeNode<?>> calculateLeftBoundary(LayeredBinaryTreeNode<?> attributedNode) {
	LayeredBinaryTreeNode<?> leftNode = attributedNode.getLeftNode();
	    LayeredBinaryTreeNode<?> rightNode = attributedNode.getRightNode();
	List<LayeredBinaryTreeNode<?>> mainBoundary = leftNode.getLeftBoundary();
	List<LayeredBinaryTreeNode<?>> fallbackBoundary = rightNode.getLeftBoundary();
	return calculateBoundary(attributedNode, mainBoundary, fallbackBoundary);
    }

    private List<LayeredBinaryTreeNode<?>> calculateBoundary(LayeredBinaryTreeNode<?> attributedNode, List<LayeredBinaryTreeNode<?>> mainBoundary,
	List<LayeredBinaryTreeNode<?>> fallbackBoundary) {
	List<LayeredBinaryTreeNode<?>> boundary = new ArrayList<LayeredBinaryTreeNode<?>>();
	boundary.add(attributedNode);
	boundary.addAll(mainBoundary);
	if (mainBoundary.size() < fallbackBoundary.size()) {
	    boundary.addAll(getAdditionalItems(mainBoundary, fallbackBoundary));
	}
	return boundary;
    }

    private List<LayeredBinaryTreeNode<?>> getAdditionalItems(List<LayeredBinaryTreeNode<?>> mainBoundary,
	List<LayeredBinaryTreeNode<?>> fallbackBoundary) {
	return fallbackBoundary.subList(mainBoundary.size(),
	    fallbackBoundary.size());
    }

}
