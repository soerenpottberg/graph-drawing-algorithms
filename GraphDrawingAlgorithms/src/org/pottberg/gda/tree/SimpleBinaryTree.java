package org.pottberg.gda.tree;

import org.pottberg.gda.tree.iterator.PostOrderBinaryTreeIterable;
import org.pottberg.gda.tree.iterator.PreOrderBinaryTreeIterable;

public class SimpleBinaryTree<T extends BinaryTreeNode<T>> implements
    BinaryTree<T> {

    T root;

    public SimpleBinaryTree(T root) {
	this.root = root;
    }

    public SimpleBinaryTree() {
    }

    @Override
    public Iterable<T> createPreOrderIterable() {
	return new PreOrderBinaryTreeIterable<T>(this);
    }

    @Override
    public T getRoot() {
	return root;
    }

    @Override
    public boolean hasRoot() {
        return root != null;
    }

    @Override
    public Iterable<T> createPostOrderIterable() {
	return new PostOrderBinaryTreeIterable<T>(this);
    }

}
