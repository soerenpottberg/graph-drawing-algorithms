package org.pottberg.gda.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public class PostOrderTreeIterator<E extends TreeNode<E>>
    implements
    Iterator<E> {

    private E nextNode;

    public PostOrderTreeIterator(Tree<E> tree) {
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

	Iterator<E> childNodeIterator = getChildIterator(parentNode);
	while (childNodeIterator.next() != nextNode) {
	}

	if (!childNodeIterator.hasNext()) {
	    nextNode = parentNode;
	    return;
	}

	E node = childNodeIterator.next();
	node = getLeftDeepestNode(node);
	nextNode = node;
    }

    private E getLeftDeepestNode(E node) {
	while (!node.isLeaveNode()) {
	    node = node.getChildNode(0);
	}
	return node;
    }

    private Iterator<E> getChildIterator(E node) {
	return node.createChildNodeIterable()
	    .iterator();
    }

}
