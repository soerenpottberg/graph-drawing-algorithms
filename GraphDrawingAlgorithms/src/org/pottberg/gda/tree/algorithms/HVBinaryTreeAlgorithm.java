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
	    HVBinaryTreeNode<?> attributedNode = wrapNode(node);
	    calculateOffsets(attributedNode);
	    calculateBoundingBox(attributedNode);
	}
	for (T node : tree.createPreOrderIterable()) {
	    HVBinaryTreeNode<?> attributedNode = wrapNode(node);
	    calculateCoordinates(attributedNode);
	}
    }

    private void calculateOffsets(HVBinaryTreeNode<?> attributedNode) {

	int offset = 1;
	if (attributedNode.hasLeftNode()) {
	    attributedNode.getLeftNode()
		.setXOffset(0);
	    attributedNode.getLeftNode()
		.setYOffset(offset);
	}

	if (attributedNode.hasRightNode()) {
	    attributedNode.getRightNode()
		.setXOffset(offset);
	    attributedNode.getRightNode()
		.setYOffset(0);
	}

	if (attributedNode.hasLeftNode() && attributedNode.hasRightNode()) {
	    if (combination == Combination.HORIZONTAL) {
		offset += attributedNode.getLeftNode()
		    .getBoundingBoxWidth();
		attributedNode.getRightNode()
		    .setXOffset(offset);
	    } else {
		offset += attributedNode.getRightNode()
		    .getHeight();
		attributedNode.getLeftNode()
		    .setYOffset(offset);
	    }
	}
    }

    private void calculateBoundingBox(HVBinaryTreeNode<?> attributedNode) {
	int maxHeight = 0;
	int maxWidth = 0;

	if (attributedNode.hasLeftNode() && attributedNode.hasRightNode()) {
	    if (combination == Combination.HORIZONTAL) {
		maxWidth += 1;
	    } else {
		maxHeight += 1;
	    }
	}

	if (combination == Combination.HORIZONTAL) {
	    if (attributedNode.hasLeftNode()) {
		maxHeight = Math.max(maxHeight, attributedNode.getLeftNode()
		    .getHeight() + 1);
		maxWidth += attributedNode.getLeftNode()
		    .getBoundingBoxWidth();
	    }
	    if (attributedNode.hasRightNode()) {
		maxHeight = Math.max(maxHeight, attributedNode.getRightNode()
		    .getHeight());
		maxWidth += attributedNode.getRightNode()
		    .getBoundingBoxWidth();
	    }

	} else {
	    if (attributedNode.hasLeftNode()) {
		maxHeight = attributedNode.getLeftNode()
		    .getHeight();
		maxWidth = Math.max(maxWidth, attributedNode.getLeftNode()
		    .getBoundingBoxWidth());
	    }
	    if (attributedNode.hasRightNode()) {
		maxHeight += attributedNode.getRightNode()
		    .getHeight();
		maxWidth = Math.max(maxWidth, attributedNode.getRightNode()
		    .getBoundingBoxWidth() + 1);
	    }

	}
	attributedNode.setBoundingBoxHeight(maxHeight);
	attributedNode.setBoundingBoxWidth(maxWidth);
    }

    private void calculateCoordinates(HVBinaryTreeNode<?> attributedNode) {
	if (attributedNode.isRootNode()) {
	    attributedNode.setX(0);
	    attributedNode.setY(0);
	} else {
	    HVBinaryTreeNode<?> parentNode = attributedNode.getParentNode();
	    attributedNode.setX(parentNode.getX() + attributedNode.getXOffset());
	    attributedNode.setY(parentNode.getY() + attributedNode.getYOffset());
	}
    }

    private HVBinaryTreeNode<?> wrapNode(T node) {
	return new SimpleHVBinaryTreeNode<T>(node);
    }

}
