package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.BinaryTreeNode;

public class ChildNodeBinaryTreeIterator<E extends BinaryTreeNode<E>> implements
    Iterator<E> {

    private E nextNode;

    public ChildNodeBinaryTreeIterator(E node) {
	if(node.hasLeftNode()) {
	    nextNode = node.getLeftNode();
	    return;
	}
	if(node.hasRightNode()) {
	    nextNode = node.getRightNode();
	    return;
	}
	nextNode = null;
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
	E parent = nextNode.getParentNode();
	if(parent.hasRightNode() && nextNode != parent.getRightNode()) {
	    nextNode = parent.getRightNode();
	    return;
	}
	nextNode = null;
    }

}
