package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.nodes.TreeNode;

public class ChildNodeTreeIterable<T extends TreeNode<T>> implements
    Iterable<T> {

    private T node;
    private boolean backwards;

    public ChildNodeTreeIterable(T node) {
	this(node, false);
    }

    public ChildNodeTreeIterable(T node, boolean backwards) {
	this.node = node;
	this.backwards = backwards;
    }

    @Override
    public Iterator<T> iterator() {
	if (backwards) {
	    return new BackwardsChildNodeTreeIterator<>(node);
	} else {
	    return new ChildNodeTreeIterator<>(node);
	}
    }

}
