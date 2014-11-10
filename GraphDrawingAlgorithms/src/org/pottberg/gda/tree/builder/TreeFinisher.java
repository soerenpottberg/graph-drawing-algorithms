package org.pottberg.gda.tree.builder;

import java.util.function.Function;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public interface TreeFinisher<T extends TreeNode<T> & ValueNode<V>, V> {
    
    Tree<T> buildTree(Function<V, T> nodeFactory);
    
    T buildNode(Function<V, T> nodeFactory);

}
