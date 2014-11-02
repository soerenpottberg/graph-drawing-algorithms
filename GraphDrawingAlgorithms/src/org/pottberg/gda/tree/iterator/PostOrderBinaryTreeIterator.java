package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;

public class PostOrderBinaryTreeIterator<E extends BinaryTreeNode<E>>
    implements
    Iterator<E> {

    private E nextNode;

    public PostOrderBinaryTreeIterator(BinaryTree<E> tree) {
	if (tree.hasRoot()) {
	    nextNode = getLeftDeepestNode(tree.getRoot());
	} else {
	    nextNode = null;
	}
    }

    @Override
    public boolean hasNext() {
	return nextNode != null;
    }

    @Override
    public E next() {
	E nextNode = this.nextNode;
	if (nextNode == null) {
	    throw new NoSuchElementException();
	}
	advanceIterator();
	return nextNode;
    }

    private void advanceIterator() {
	if (nextNode.isRootNode()) {
	    nextNode = null;
	    return;
	}
	E parentNode = nextNode.getParentNode();
	if (!parentNode.hasRightNode()) {
	    nextNode = parentNode;
	    return;
	}
	E node = parentNode.getRightNode();
	if (node == nextNode) {
	    nextNode = parentNode;
	    return;
	}
	node = getLeftDeepestNode(node);
	nextNode = node;
    }

    private E getLeftDeepestNode(E node) {
	while (node.hasLeftNode() || node.hasRightNode()) {
	    if (node.hasLeftNode()) {
		node = node.getLeftNode();
	    } else {
		node = node.getRightNode();
	    }
	}
	return node;
    }

}
