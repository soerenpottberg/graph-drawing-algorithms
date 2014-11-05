package org.pottberg.gda.tree.builder;

import java.util.function.Function;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public interface BinaryTreeFinisher<T extends BinaryTreeNode<T> & ValueNode<V>, V> {
    
    BinaryTree<T> buildTree(Function<V, T> nodeFactory);
    
    T buildNode(Function<V, T> nodeFactory);

}
