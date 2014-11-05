package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.BinaryTreeNode;

public class ChildNodeBinaryTreeIterable<T extends BinaryTreeNode<T>> implements
    Iterable<T> {

    private T node;

    public ChildNodeBinaryTreeIterable(T node) {
	this.node = node;
    }

    @Override
    public Iterator<T> iterator() {
	return new ChildNodeBinaryTreeIterator<>(node);
    }

}
