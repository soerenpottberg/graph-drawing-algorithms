package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.nodes.TreeNode;

public class ChildNodeTreeIterable<T extends TreeNode<T>> implements
    Iterable<T> {

    private T node;

    public ChildNodeTreeIterable(T node) {
	this.node = node;
    }

    @Override
    public Iterator<T> iterator() {
	return new ChildNodeTreeIterator<>(node);
    }

}
