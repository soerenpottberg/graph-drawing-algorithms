package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public class BackwardsChildNodeBinaryTreeIterator<E extends BinaryTreeNode<E>> implements
    Iterator<E> {

    private E nextNode;

    public BackwardsChildNodeBinaryTreeIterator(E node) {
	if(node.hasRightNode()) {
	    nextNode = node.getRightNode();
	    return;
	}
	if(node.hasLeftNode()) {
	    nextNode = node.getLeftNode();
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
	if(parent.hasLeftNode() && nextNode != parent.getLeftNode()) {
	    nextNode = parent.getLeftNode();
	    return;
	}
	nextNode = null;
    }

}
