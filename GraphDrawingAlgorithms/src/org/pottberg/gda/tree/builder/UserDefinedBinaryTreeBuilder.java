package org.pottberg.gda.tree.builder;

import java.util.function.Function;

import org.pottberg.gda.node.NumberedNode;
import org.pottberg.gda.tree.BinaryTreeNode;
import org.pottberg.gda.tree.AttributedBinaryTreeNodeBase;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTree;

public class UserDefinedBinaryTreeBuilder {

    public static <T extends BinaryTreeNode<T>> BinaryTree<T> createTree() {
	return new SimpleBinaryTree<>();
    }

    public static <T extends AttributedBinaryTreeNodeBase<T> & NumberedNode> BinaryTree<T> createTree(
	BinaryTreeFinisher<T, Long> builder, Function<Long, T> nodeFactory) {
	T node = builder.buildNode(nodeFactory);
	return new UserDefinedBinaryTreeNodeBuilder<T>(node).buildTree(nodeFactory);
    }

    public static <T extends AttributedBinaryTreeNodeBase<T> & NumberedNode> BinaryTreeNodeBuilder<T, Long> createNode(Class<T> type,
	Long value) {
	return new UserDefinedBinaryTreeNodeBuilder<T>(value);
    }

}
