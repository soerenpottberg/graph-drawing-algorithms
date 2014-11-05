package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.node.AttributedNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.DrawableTreeNode;

public class HVBinaryTreeAlgorithm<T extends BinaryTreeNode<T> & DrawableTreeNode<T> & AttributedNode>
    implements BinaryTreeAlgorithm {

    public enum Combination {
	HORIZONTAL, VERTICAL;
    }

    private BinaryTree<T> tree;
    private Combination combination;

    public HVBinaryTreeAlgorithm(BinaryTree<T> tree) {
	this(tree, Combination.HORIZONTAL);
    }

    public HVBinaryTreeAlgorithm(BinaryTree<T> tree, Combination combination) {
	this.tree = tree;
	this.combination = combination;
    }

    @Override
    public void execute() {
	for (T node : tree.createPostOrderIterable()) {
	    HVBinaryTreeNode attributedNode = wrapNode(node);
	    calculateOffsets(attributedNode);
	    calculateBoundingBox(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    HVBinaryTreeNode attributedNode = wrapNode(node);
	    calculateCoordinates(attributedNode);
	}
    }

    private void calculateOffsets(HVBinaryTreeNode node) {

	int offset = 1;
	if (node.hasLeftNode()) {
	    node.getLeftNode()
		.setXOffset(0);
	    node.getLeftNode()
		.setYOffset(offset);
	}

	if (node.hasRightNode()) {
	    node.getRightNode()
		.setXOffset(offset);
	    node.getRightNode()
		.setYOffset(0);
	}

	if (node.hasLeftNode() && node.hasRightNode()) {
	    if (combination == Combination.HORIZONTAL) {
		offset += node.getLeftNode()
		    .getBoundingBoxWidth();
		node.getRightNode()
		    .setXOffset(offset);
	    } else {
		offset += node.getRightNode()
		    .getHeight();
		node.getLeftNode()
		    .setYOffset(offset);
	    }
	}
    }

    private void calculateBoundingBox(HVBinaryTreeNode node) {
	int maxHeight = 0;
	int maxWidth = 0;

	if (node.hasLeftNode() && node.hasRightNode()) {
	    if (combination == Combination.HORIZONTAL) {
		maxWidth += 1;
	    } else {
		maxHeight += 1;
	    }
	}

	if (combination == Combination.HORIZONTAL) {
	    if (node.hasLeftNode()) {
		maxHeight = Math.max(maxHeight, node.getLeftNode()
		    .getHeight() + 1);
		maxWidth += node.getLeftNode()
		    .getBoundingBoxWidth();
	    }
	    if (node.hasRightNode()) {
		maxHeight = Math.max(maxHeight, node.getRightNode()
		    .getHeight());
		maxWidth += node.getRightNode()
		    .getBoundingBoxWidth();
	    }

	} else {
	    if (node.hasLeftNode()) {
		maxHeight = node.getLeftNode()
		    .getHeight();
		maxWidth = Math.max(maxWidth, node.getLeftNode()
		    .getBoundingBoxWidth());
	    }
	    if (node.hasRightNode()) {
		maxHeight += node.getRightNode()
		    .getHeight();
		maxWidth = Math.max(maxWidth, node.getRightNode()
		    .getBoundingBoxWidth() + 1);
	    }

	}
	node.setBoundingBoxHeight(maxHeight);
	node.setBoundingBoxWidth(maxWidth);
    }

    private void calculateCoordinates(HVBinaryTreeNode node) {
	if (node.isRootNode()) {
	    node.setX(0);
	    node.setY(0);
	} else {
	    HVBinaryTreeNode parentNode = node.getParentNode();
	    node.setX(parentNode.getX() + node.getXOffset());
	    node.setY(parentNode.getY() + node.getYOffset());
	}
    }

    private SimpleHVBinaryTreeNode<T> wrapNode(T node) {
	return new SimpleHVBinaryTreeNode<T>(node);
    }

}
