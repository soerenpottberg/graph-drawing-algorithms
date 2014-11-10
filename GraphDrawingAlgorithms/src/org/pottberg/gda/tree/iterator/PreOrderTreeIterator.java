package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public class PreOrderTreeIterator<E extends TreeNode<E>> implements
    Iterator<E> {

    private E nextNode;

    public PreOrderTreeIterator(Tree<E> tree) {
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
	if (!nextNode.isLeaveNode()) {
	    nextNode = nextNode.getChildNode(0);
	    return;
	}
	if (nextNode.isRootNode()) {
	    nextNode = null;
	    return;
	}
	E childNode = nextNode;
	E parentNode = childNode.getParentNode();
	do {
	    Iterator<E> childNodeIterator = getChildIterator(parentNode);
	    while (childNodeIterator.next() != childNode) {
	    }
	    if (childNodeIterator.hasNext()) {
		nextNode = childNodeIterator.next();
		return;
	    }
	    childNode = parentNode;
	    parentNode = childNode.getParentNode();
	} while (!childNode.isRootNode());

	nextNode = null;
    }

    private Iterator<E> getChildIterator(E node) {
	return node.createChildNodeIterable()
	    .iterator();
    }

}
