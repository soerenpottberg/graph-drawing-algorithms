package org.pottberg.gda.tree.builder;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.nodes.BinaryTreeNode;

public interface BinaryTreeRightNodeBuilder<T extends BinaryTreeNode<T> & ValueNode<V>, V>
    extends BinaryTreeFinisher<T, V> {

    BinaryTreeFinisher<T, V> addRightChild(V value);

    BinaryTreeFinisher<T, V> addRightChild(BinaryTreeFinisher<T, V> builder);

}
