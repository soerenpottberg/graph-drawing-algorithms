package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public class ChildNodeBinaryTreeIterable<T extends BinaryTreeNode<T>>
    implements
    Iterable<T> {

    private T node;
    private boolean backwards;

    public ChildNodeBinaryTreeIterable(T node) {
	this(node, false);
    }

    public ChildNodeBinaryTreeIterable(T node, boolean backwards) {
	this.node = node;
	this.backwards = backwards;
    }

    @Override
    public Iterator<T> iterator() {
	if (backwards) {
	    return new BackwardsChildNodeBinaryTreeIterator<>(node);
	} else {
	    return new ChildNodeBinaryTreeIterator<>(node);
	}
    }

}
