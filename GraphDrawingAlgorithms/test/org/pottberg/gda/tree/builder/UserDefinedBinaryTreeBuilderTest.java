package org.pottberg.gda.tree.builder;

import static org.junit.Assert.*;
import static org.pottberg.gda.tree.builder.UserDefinedBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.UserDefinedBinaryTreeBuilder.createTree;

import org.junit.Test;
import org.pottberg.gda.tree.BinaryTree;

public class UserDefinedBinaryTreeBuilderTest {

    @Test
    public void testSimpleTree() {
	BinaryTree<UserDefinedTestNode> tree = createTree(
	    createNode(UserDefinedTestNode.class, 0l)
		.addLeftChild(1l)
		.addRightChild(2l),
	    value -> new UserDefinedTestNode(value));
	UserDefinedTestNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

    @Test
    public void testLeftOnly() {
	BinaryTree<UserDefinedTestNode> tree = createTree(
	    createNode(UserDefinedTestNode.class, 0l).addLeftChild(1l),
	    value -> new UserDefinedTestNode(value));
	UserDefinedTestNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertNull(root.getRightNode());
    }

    @Test
    public void testRightOnly() {
	BinaryTree<UserDefinedTestNode> tree = createTree(
	    createNode(UserDefinedTestNode.class, 0l).addRightChild(2l),
	    value -> new UserDefinedTestNode(value));
	UserDefinedTestNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertNull(root.getLeftNode());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

    @Test
    public void testComplexTree() {
	BinaryTree<UserDefinedTestNode> tree = createTree(createNode(UserDefinedTestNode.class, 0l)
	    .addLeftChild(
		createNode(UserDefinedTestNode.class, 1l).addLeftChild(11l)
	    )
	    .addRightChild(2l),
	    value -> new UserDefinedTestNode(value));
	UserDefinedTestNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertEquals(new Long(11), root.getLeftNode()
	    .getLeftNode()
	    .getValue());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

    @Test
    public void testComplexTreeSimplified() {
	BinaryTree<UserDefinedTestNode> tree = createTree(
	    createNode(UserDefinedTestNode.class, 0l)
		.addLeftChild(
		    createNode(UserDefinedTestNode.class, 1l).addLeftChild(11l)
		)
		.addRightChild(2l),
	    value -> new UserDefinedTestNode(value));
	UserDefinedTestNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertEquals(new Long(11), root.getLeftNode()
	    .getLeftNode()
	    .getValue());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

}
