package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;

public class PreOrderBinaryTreeIterable<T extends BinaryTreeNode<T>> implements
    Iterable<T> {

    private BinaryTree<T> binaryTree;

    public PreOrderBinaryTreeIterable(BinaryTree<T> binaryTree) {
	this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
	return new PreOrderBinaryTreeIterator<T>(binaryTree);
    }

}
