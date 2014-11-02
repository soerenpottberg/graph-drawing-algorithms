package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;

public class PostOrderBinaryTreeIterable<T extends BinaryTreeNode<T>> implements
    Iterable<T> {

    private BinaryTree<T> binaryTree;

    public PostOrderBinaryTreeIterable(BinaryTree<T> binaryTree) {
	this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
	return new PostOrderBinaryTreeIterator<T>(binaryTree);
    }

}
