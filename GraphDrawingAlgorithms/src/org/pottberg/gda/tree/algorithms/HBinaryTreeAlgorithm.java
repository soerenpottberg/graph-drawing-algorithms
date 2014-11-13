package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.BinaryTreeNode;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.HBinaryTreeNode;
import org.pottberg.gda.tree.nodes.SimpleHBinaryTreeNode;

public class HBinaryTreeAlgorithm<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements BinaryTreeAlgorithm {

    private BinaryTree<T> tree;

    public HBinaryTreeAlgorithm(BinaryTree<T> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	for (T node : tree.createPreOrderIterable()) {
	    HBinaryTreeNode<?> attributedNode = wrapNode(node);
	    calculateOffsets(attributedNode);
	}
	for (T node : tree.createPostOrderIterable()) {
	    HBinaryTreeNode<?> attributedNode = wrapNode(node);
	    calculateDistance(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    HBinaryTreeNode<?> attributedNode = wrapNode(node);
	    calculateCoordinates(attributedNode);
	}
    }

    private void calculateOffsets(HBinaryTreeNode<?> node) {
	if (node.isRootNode()) {
	    if (node.hasLeftNode()) {
		node.getLeftNode()
		    .setXOffset(-1);
	    }
	    if (node.hasRightNode()) {
		node.getRightNode()
		    .setXOffset(1);
	    }
	    return;
	}
	int xOffsetLeft;
	int yOffsetLeft;
	int xOffsetRight;
	int yOffsetRight;
	if (node.getXOffset() == 0) {
	    xOffsetLeft = -1;
	    yOffsetLeft = 0;
	    xOffsetRight = 1;
	    yOffsetRight = 0;
	} else {
	    xOffsetLeft = 0;
	    yOffsetLeft = -1;
	    xOffsetRight = 0;
	    yOffsetRight = 1;
	}
	if (node.hasLeftNode()) {
	    HBinaryTreeNode<?> leftNode = node.getLeftNode();
	    leftNode.setXOffset(xOffsetLeft);
	    leftNode.setYOffset(yOffsetLeft);
	}
	if (node.hasRightNode()) {
	    HBinaryTreeNode<?> rightNode = node.getRightNode();
	    rightNode.setXOffset(xOffsetRight);
	    rightNode.setYOffset(yOffsetRight);
	}
    }

    private void calculateDistance(HBinaryTreeNode<?> node) {
	if (node.isLeaveNode()) {
	    node.setDistance(1);
	    return;
	}
	int distanceLeft = 0;
	int distanceRight = 0;
	if (node.hasLeftNode()) {
	    HBinaryTreeNode<?> leftNode = node.getLeftNode();
	    distanceLeft = leftNode.getDistance();
	}
	if (node.hasRightNode()) {
	    HBinaryTreeNode<?> rightNode = node.getRightNode();
	    distanceRight = rightNode.getDistance();
	}
	int distance = Math.max(distanceLeft, distanceRight);
	if (node.getXOffset() == 0) {
	    node.setDistance(distance);
	} else {
	    node.setDistance(2 * distance);
	}
    }

    private void calculateCoordinates(HBinaryTreeNode<?> node) {
	if (node.isRootNode()) {
	    node.setX(0);
	    node.setY(0);
	    return;
	}
	HBinaryTreeNode<?> parentNode = node.getParentNode();
	node.setX(parentNode.getX() + node.getXOffset() * node.getDistance());
	node.setY(parentNode.getY() + node.getYOffset() * node.getDistance());
    }

    private HBinaryTreeNode<?> wrapNode(T node) {
	return new SimpleHBinaryTreeNode<T>(node);
    }

}
