package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public class PostOrderTreeIterable<T extends TreeNode<T>> implements
    Iterable<T> {

    private Tree<T> binaryTree;

    public PostOrderTreeIterable(Tree<T> binaryTree) {
	this.binaryTree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
	return new PostOrderTreeIterator<>(binaryTree);
    }

}
