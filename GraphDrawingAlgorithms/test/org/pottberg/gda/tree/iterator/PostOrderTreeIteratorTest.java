package org.pottberg.gda.tree.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public class PostOrderTreeIteratorTest extends TreeIteratorTest {

    @Test
    public void testSimpleTree() {
	Tree<SimpleTreeNode> tree = createSimpleTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
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
	Tree<SimpleTreeNode> tree = createTreeWithLeftChild();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testRightOnly() {
	Tree<SimpleTreeNode> tree = createTreeWithRightChild();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(2), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testNestedTree() {
	Tree<SimpleTreeNode> tree = createNestedTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testDeepNestedTree() {
	Tree<SimpleTreeNode> tree = createDeepNestedTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(111), getNextValue(iterator));
	assertEquals(new Long(112), getNextValue(iterator));
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(121), getNextValue(iterator));
	assertEquals(new Long(122), getNextValue(iterator));
	assertEquals(new Long(12), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Test
    public void testNotFullTree() {
	Tree<SimpleTreeNode> tree = createNotFullTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(111), getNextValue(iterator));
	assertEquals(new Long(112), getNextValue(iterator));
	assertEquals(new Long(11), getNextValue(iterator));
	assertEquals(new Long(122), getNextValue(iterator));
	assertEquals(new Long(12), getNextValue(iterator));
	assertEquals(new Long(1), getNextValue(iterator));
	assertEquals(new Long(2), getNextValue(iterator));
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
    }

    @Override
    protected Iterator<SimpleTreeNode> getIterator(
	Tree<SimpleTreeNode> tree) {
	return tree.createPostOrderIterable()
	    .iterator();
    }

}
