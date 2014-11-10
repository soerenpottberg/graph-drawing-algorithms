package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.SimpleTree;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public class SimpleTreeBuilder{

    public static Tree<SimpleTreeNode> createTree() {
	return new SimpleTree<SimpleTreeNode>();
    }

    public static Tree<SimpleTreeNode> createTree(
	TreeFinisher<SimpleTreeNode, Long> builder) {
	SimpleTreeNode node = builder.buildNode(SimpleTreeBuilder::createTreeNode);
	return new SimpleTreeNodeBuilder(node).buildTree(SimpleTreeBuilder::createTreeNode);
    }

    public static TreeNodeBuilder<SimpleTreeNode, Long> createNode(
	Long value) {
	SimpleTreeNode node = new SimpleTreeNode(value);
	return new SimpleTreeNodeBuilder(node);
    }

    protected static SimpleTreeNode createTreeNode(Long value) {
	return new SimpleTreeNode(value);
    }

}
