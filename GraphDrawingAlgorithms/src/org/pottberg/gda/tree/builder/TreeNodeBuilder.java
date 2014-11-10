package org.pottberg.gda.tree.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.TreeNode;

public abstract class TreeNodeBuilder<T extends TreeNode<T> & ValueNode<V>, V>
    implements TreeChildNodeBuilder<T, V> {

    protected T parent;
    private List<TreeFinisher<T, V>> childBuilderList = new ArrayList<TreeFinisher<T,V>>();
    private V value;

    public TreeNodeBuilder(T parent) {
	this.parent = parent;
    }

    public TreeNodeBuilder(V value) {
	this.value = value;
    }

    @Override
    public TreeChildNodeBuilder<T, V> addChild(V value) {
	childBuilderList.add(crateTreeNodeBuilder(value));
	return this;
    }

    @Override
    public TreeChildNodeBuilder<T, V> addChild(TreeFinisher<T, V> builder) {
	childBuilderList.add(builder);
	return this;
    }

    @Override
    public Tree<T> buildTree(Function<V, T> nodeFactory) {
	parent = buildNode(nodeFactory);
	return createTree();
    }

    @Override
    public T buildNode(Function<V, T> nodeFactory) {
	if (value != null) {
	    parent = nodeFactory.apply(value);
	}
	buildChilds(nodeFactory);
	return parent;
    }

    protected abstract Tree<T> createTree();

    protected void buildChilds(Function<V, T> nodeFactory) {
	for (TreeFinisher<T, V> childBuilder : childBuilderList) {
	    parent.addChildNode(childBuilder.buildNode(nodeFactory));
	}
    }

    protected abstract TreeFinisher<T, V> crateTreeNodeBuilder(V value);

}
