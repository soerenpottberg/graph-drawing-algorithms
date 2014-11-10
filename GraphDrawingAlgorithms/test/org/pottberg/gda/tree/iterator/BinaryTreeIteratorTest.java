package org.pottberg.gda.tree.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTreeNode;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTree;

import java.util.Iterator;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;

public abstract class BinaryTreeIteratorTest {

    protected void runTestEmptyTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createEmptyTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertFalse(iterator.hasNext());
    }
    
    protected void runTestOneNodeTree() {
   	BinaryTree<SimpleBinaryTreeNode> tree = createOneNodeTree();
   	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
       }

    protected void runTestHasNext() {
	BinaryTree<SimpleBinaryTreeNode> tree = createSimpleTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertTrue(iterator.hasNext());
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertFalse(iterator.hasNext());
    }

    protected void runTestNoSuchElementException() {
	BinaryTree<SimpleBinaryTreeNode> tree = createSimpleTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertFalse(iterator.hasNext());
	iterator.next();
    }

    protected BinaryTree<SimpleBinaryTreeNode> createEmptyTree() {
	return createBinaryTree();
    }

    protected BinaryTree<SimpleBinaryTreeNode> createOneNodeTree() {
	return createBinaryTree(createBinaryTreeNode(0l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createSimpleTree() {
	return createBinaryTree(createBinaryTreeNode(0l)
	    .addLeftChild(1l)
	    .addRightChild(2l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createTreeWithLeftChild() {
	return createBinaryTree(createBinaryTreeNode(0l).addLeftChild(1l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createTreeWithRightChild() {
	return createBinaryTree(createBinaryTreeNode(0l).addRightChild(2l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createNestedTree() {
	return createBinaryTree(createBinaryTreeNode(0l)
	    .addLeftChild(
		createBinaryTreeNode(1l).addLeftChild(11l)
	    )
	    .addRightChild(2l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createDeepNestedTree() {
	return createBinaryTree(createBinaryTreeNode(0l)
	    .addLeftChild(createBinaryTreeNode(1l)
		.addLeftChild(createBinaryTreeNode(11l)
		    .addLeftChild(111l)
		    .addRightChild(112l))
		.addRightChild(createBinaryTreeNode(12l)
		    .addLeftChild(121l)
		    .addRightChild(122l))
	    )
	    .addRightChild(2l));
    }

    protected BinaryTree<SimpleBinaryTreeNode> createNotFullTree() {
	return createBinaryTree(createBinaryTreeNode(0l)
	    .addLeftChild(createBinaryTreeNode(1l)
		.addLeftChild(createBinaryTreeNode(11l)
		    .addLeftChild(111l)
		    .addRightChild(112l))
		.addRightChild(createBinaryTreeNode(12l)
		    .addRightChild(122l))
	    )
	    .addRightChild(2l));
    }

    protected Long getNextValue(Iterator<SimpleBinaryTreeNode> iterator) {
	return iterator.next()
	    .getValue();
    }

    protected abstract Iterator<SimpleBinaryTreeNode> getIterator(
	BinaryTree<SimpleBinaryTreeNode> tree);

}
