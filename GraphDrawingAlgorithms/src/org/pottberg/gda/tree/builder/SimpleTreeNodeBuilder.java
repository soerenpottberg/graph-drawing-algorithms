package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.SimpleTree;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public class SimpleTreeNodeBuilder extends
    TreeNodeBuilder<SimpleTreeNode, Long> {

    public SimpleTreeNodeBuilder(SimpleTreeNode parent) {
	super(parent);
    }

    public SimpleTreeNodeBuilder(Long value) {
	super(value);
    }

    @Override
    protected Tree<SimpleTreeNode> createTree() {
	return new SimpleTree<SimpleTreeNode>(parent);
    }

    @Override
    protected TreeFinisher<SimpleTreeNode, Long> crateTreeNodeBuilder(Long value) {
	return new SimpleTreeNodeBuilder(value);
    }

}
