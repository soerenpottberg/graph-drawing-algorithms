package org.pottberg.gda.tree.builder;

import java.util.function.Function;

import org.pottberg.gda.node.ValueNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.BinaryTreeNode;

public abstract class BinaryTreeNodeBuilder<T extends BinaryTreeNode<T> & ValueNode<V>, V>
    implements BinaryTreeLeftNodeBuilder<T, V>,
    BinaryTreeRightNodeBuilder<T, V> {

    protected T parent;
    private V leftChildValue;
    private V rightChildValue;
    private BinaryTreeFinisher<T, V> leftChildBuilder;
    private BinaryTreeFinisher<T, V> rightChildBuilder;
    private V value;

    public BinaryTreeNodeBuilder(T parent) {
	this.parent = parent;
    }

    public BinaryTreeNodeBuilder(V value) {
	this.value = value;
    }

    @Override
    public BinaryTreeRightNodeBuilder<T, V> addLeftChild(V value) {
	leftChildValue = value;
	return this;
    }

    @Override
    public BinaryTreeRightNodeBuilder<T, V> addLeftChild(
	BinaryTreeFinisher<T, V> builder) {
	leftChildBuilder = builder;
	return this;
    }

    @Override
    public BinaryTreeFinisher<T, V> addRightChild(V value) {
	rightChildValue = value;
	return this;
    }

    @Override
    public BinaryTreeRightNodeBuilder<T, V> addRightChild(
	BinaryTreeFinisher<T, V> builder) {
	rightChildBuilder = builder;
	return this;
    }

    @Override
    public BinaryTree<T> buildTree(Function<V, T> nodeFactory) {
	parent = buildNode(nodeFactory);
	return createBinaryTree();
    }

    @Override
    public T buildNode(Function<V, T> nodeFactory) {
	if (value != null) {
            parent = nodeFactory.apply(value);
        }
	buildChilds(nodeFactory);
	return parent;
    }

    protected abstract BinaryTree<T> createBinaryTree();

    protected void buildChilds(Function<V, T> nodeFactory) {
        if (leftChildValue != null) {
            parent.setLeftNode(nodeFactory.apply(leftChildValue));
        }
        if (rightChildValue != null) {
            parent.setRightNode(nodeFactory.apply(rightChildValue));
        }
        if (leftChildBuilder != null) {
            parent.setLeftNode(leftChildBuilder.buildNode(nodeFactory));
        }
        if (rightChildBuilder != null) {
            parent.setRightNode(rightChildBuilder.buildNode(nodeFactory));
        }
    }

}
