package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.nodes.TreeNode;

public class BackwardsChildNodeTreeIterator<E extends TreeNode<E>> implements
    Iterator<E> {

    private int nextNodeIndex;
    private E node;
    private E nextNode;

    public BackwardsChildNodeTreeIterator(E node) {
	this.node = node;
	if (!node.isLeaveNode()) {
	    nextNodeIndex = 0;
	    while(node.getChildNode(nextNodeIndex + 1) != null) {
		nextNodeIndex++;
	    }
	    nextNode = node.getChildNode(nextNodeIndex);
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
	nextNodeIndex--;
	nextNode = node.getChildNode(nextNodeIndex);
    }

}
