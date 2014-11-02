package org.pottberg.gda.tree.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.SimpleBinaryTreeNode;

public class PreOrderBinaryTreeIteratorTest extends BinaryTreeIteratorTest {

    @Test
    public void testSimpleTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createSimpleTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testEmptyTree() {
	runTestEmptyTree();
    }
    
    @Test
    public void testOneNodeTree() {
	runTestOneNodeTree();
    }
    
    @Test
    public void testHasNext() {
	runTestHasNext();
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
	runTestNoSuchElementException();
    }

    @Test
    public void testLeftOnly() {
	BinaryTree<SimpleBinaryTreeNode> tree = createTreeWithLeftChild();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testRightOnly() {
	BinaryTree<SimpleBinaryTreeNode> tree = createTreeWithRightChild();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testNestedTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createNestedTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testDeepNestedTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createDeepNestedTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(111), getNextValue(iterator));
	assertEquals(new Long(112), getNextValue(iterator));
	assertEquals(new Long(12), getNextValue(iterator));
	assertEquals(new Long(121), getNextValue(iterator));
	assertEquals(new Long(122), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }
    
    @Test
    public void testNotFullTree() {
	BinaryTree<SimpleBinaryTreeNode> tree = createNotFullTree();
	Iterator<SimpleBinaryTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(111), getNextValue(iterator));
	assertEquals(new Long(112), getNextValue(iterator));
	assertEquals(new Long(12), getNextValue(iterator));
	assertEquals(new Long(122), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Override
    protected Iterator<SimpleBinaryTreeNode> getIterator(
	BinaryTree<SimpleBinaryTreeNode> tree) {
	return tree.createPreOrderIterable()
	    .iterator();
    }

}
