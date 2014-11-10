package org.pottberg.gda.tree.builder;

import static org.junit.Assert.*;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTreeNode;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTree;

import org.junit.Test;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;

public class SimpleBinaryTreeBuilderTest {

    @Test
    public void testSimpleTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(
	    createBinaryTreeNode(0l)
		.addLeftChild(1l)
		.addRightChild(2l));
	SimpleBinaryTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

    @Test
    public void testLeftOnly() {
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(
	    createBinaryTreeNode(0l).addLeftChild(1l));
	SimpleBinaryTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getLeftNode()
	    .getValue());
	assertNull(root.getRightNode());
    }

    @Test
    public void testRightOnly() {
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(
	    createBinaryTreeNode(0l).addRightChild(2l));
	SimpleBinaryTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertNull(root.getLeftNode());
	assertEquals(new Long(2), root.getRightNode()
	    .getValue());
    }

    @Test
    public void testComplexTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(createBinaryTreeNode(0l)
	    .addLeftChild(
		createBinaryTreeNode(1l).addLeftChild(11l)
	    )
	    .addRightChild(2l));
	SimpleBinaryTreeNode root = tree.getRoot();
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
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(
	    createBinaryTreeNode(0l)
		.addLeftChild(
		    createBinaryTreeNode(1l).addLeftChild(11l)
		)
		.addRightChild(2l)
	    );
	SimpleBinaryTreeNode root = tree.getRoot();
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
