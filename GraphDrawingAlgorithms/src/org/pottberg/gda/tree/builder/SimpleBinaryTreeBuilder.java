package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTreeNode;

public class SimpleBinaryTreeBuilder{

    public static BinaryTree<SimpleBinaryTreeNode> createTree() {
	return new SimpleBinaryTree<SimpleBinaryTreeNode>();
    }

    public static BinaryTree<SimpleBinaryTreeNode> createTree(
	BinaryTreeFinisher<SimpleBinaryTreeNode, Long> builder) {
	SimpleBinaryTreeNode node = builder.buildNode(SimpleBinaryTreeBuilder::createBinaryTreeNode);
	return new SimpleBinaryTreeNodeBuilder(node).buildTree(SimpleBinaryTreeBuilder::createBinaryTreeNode);
    }

    public static BinaryTreeNodeBuilder<SimpleBinaryTreeNode, Long> createNode(
	Long value) {
	SimpleBinaryTreeNode node = new SimpleBinaryTreeNode(value);
	return new SimpleBinaryTreeNodeBuilder(node);
    }

    protected static SimpleBinaryTreeNode createBinaryTreeNode(Long value) {
	return new SimpleBinaryTreeNode(value);
    }

}
