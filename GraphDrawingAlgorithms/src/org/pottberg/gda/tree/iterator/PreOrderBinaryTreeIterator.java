package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public class PreOrderBinaryTreeIterator<E extends BinaryTreeNode<E>> implements
    Iterator<E> {

    private E nextNode;

    public PreOrderBinaryTreeIterator(BinaryTree<E> tree) {
	nextNode = tree.getRoot();
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
	if (nextNode.hasLeftNode()) {
	    nextNode = nextNode.getLeftNode();
	    return;
	}
	if (nextNode.hasRightNode()) {
	    nextNode = nextNode.getRightNode();
	    return;
	}
	if (nextNode.isRootNode()) {
	    nextNode = null;
	    return;
	}
	E childNode = nextNode;
	E parentNode = childNode.getParentNode();
	do {
	    if (parentNode.hasRightNode()
		&& parentNode.getRightNode() != childNode) {
		nextNode = parentNode.getRightNode();
		return;
	    }
	    childNode = parentNode;
	    parentNode = childNode.getParentNode();
	} while (!childNode.isRootNode());

	nextNode = null;
    }

}
