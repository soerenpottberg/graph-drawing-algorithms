package org.pottberg.gda.tree.algorithms;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;

public class SimpleTreeAlgorithm
    implements TreeAlgorithm {

    private Tree<? extends DrawableTreeNode<?>> tree;

    public SimpleTreeAlgorithm(Tree<? extends DrawableTreeNode<?>> tree) {
	this.tree = tree;
    }

    @Override
    public void execute() {
	int x = 0;
	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    node.setX(x++);
	}
	int y = 0;
	for (DrawableTreeNode<?> node : tree.createPostOrderIterable()) {
	    node.setY(y++);
	}
    }

}
