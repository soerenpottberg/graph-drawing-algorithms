package org.pottberg.gda.tree;

import org.pottberg.gda.tree.iterator.PostOrderTreeIterable;
import org.pottberg.gda.tree.iterator.PreOrderTreeIterable;
import org.pottberg.gda.tree.nodes.TreeNode;

public class SimpleTree<T extends TreeNode<T>> implements Tree<T> {

    T root;

    public SimpleTree(T root) {
	this.root = root;
    }

    public SimpleTree() {
    }

    @Override
    public Iterable<T> createPreOrderIterable() {
	return new PreOrderTreeIterable<T>(this);
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
    public int getHeight() {
	return root.getHeight();
    }

    @Override
    public int getDepth() {
	return root.getDepth();
    }

    @Override
    public int getWeight() {
	return root.getWeight();
    }

    @Override
    public Iterable<T> createPostOrderIterable() {
	return new PostOrderTreeIterable<T>(this);
    }

}
