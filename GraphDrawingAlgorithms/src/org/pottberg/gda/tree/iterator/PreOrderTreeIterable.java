package org.pottberg.gda.tree.iterator;

import java.util.Iterator;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public class PreOrderTreeIterable<T extends TreeNode<T>> implements
    Iterable<T> {

    private Tree<T> tree;

    public PreOrderTreeIterable(Tree<T> binaryTree) {
	this.tree = binaryTree;
    }

    @Override
    public Iterator<T> iterator() {
	return new PreOrderTreeIterator<>(tree);
    }

}
