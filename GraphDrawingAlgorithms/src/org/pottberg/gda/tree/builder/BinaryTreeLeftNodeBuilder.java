package org.pottberg.gda.tree.builder;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public interface BinaryTreeLeftNodeBuilder<T extends BinaryTreeNode<T> & ValueNode<V>, V>
    extends BinaryTreeFinisher<T, V> {

    BinaryTreeRightNodeBuilder<T, V> addLeftChild(V value);

    BinaryTreeRightNodeBuilder<T, V> addLeftChild(BinaryTreeFinisher<T, V> builder);
    
}
