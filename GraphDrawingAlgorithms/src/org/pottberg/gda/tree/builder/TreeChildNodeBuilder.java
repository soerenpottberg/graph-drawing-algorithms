package org.pottberg.gda.tree.builder;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.nodes.TreeNode;

public interface TreeChildNodeBuilder<T extends TreeNode<T> & ValueNode<V>, V>
    extends TreeFinisher<T, V> {

    TreeChildNodeBuilder<T, V> addChild(V value);

    TreeChildNodeBuilder<T, V> addChild(TreeFinisher<T, V> builder);

}
