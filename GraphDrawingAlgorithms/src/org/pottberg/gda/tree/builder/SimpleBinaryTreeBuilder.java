package org.pottberg.gda.tree.builder;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTree;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;

public class SimpleBinaryTreeBuilder{

    public static BinaryTree<SimpleBinaryTreeNode> createBinaryTree() {
	return new SimpleBinaryTree<SimpleBinaryTreeNode>();
    }

    public static BinaryTree<SimpleBinaryTreeNode> createBinaryTree(
	BinaryTreeFinisher<SimpleBinaryTreeNode, Long> builder) {
	SimpleBinaryTreeNode node = builder.buildNode(SimpleBinaryTreeBuilder::binaryTreeNodeFactory);
	return new SimpleBinaryTreeNodeBuilder(node).buildTree(SimpleBinaryTreeBuilder::binaryTreeNodeFactory);
    }

    public static BinaryTreeNodeBuilder<SimpleBinaryTreeNode, Long> createBinaryTreeNode(
	Long value) {
	SimpleBinaryTreeNode node = new SimpleBinaryTreeNode(value);
	return new SimpleBinaryTreeNodeBuilder(node);
    }

    protected static SimpleBinaryTreeNode binaryTreeNodeFactory(Long value) {
	return new SimpleBinaryTreeNode(value);
    }

}
