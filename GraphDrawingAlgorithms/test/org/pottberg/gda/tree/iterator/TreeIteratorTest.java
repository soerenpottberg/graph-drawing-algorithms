package org.pottberg.gda.tree.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createTree;

import java.util.Iterator;

import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public abstract class TreeIteratorTest {

    protected void runTestEmptyTree() {
	Tree<SimpleTreeNode> tree = createEmptyTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertFalse(iterator.hasNext());
    }
    
    protected void runTestOneNodeTree() {
   	Tree<SimpleTreeNode> tree = createOneNodeTree();
   	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertEquals(new Long(0), getNextValue(iterator));
   	assertFalse(iterator.hasNext());
       }

    protected void runTestHasNext() {
	Tree<SimpleTreeNode> tree = createSimpleTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
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
	Tree<SimpleTreeNode> tree = createSimpleTree();
	Iterator<SimpleTreeNode> iterator = getIterator(tree);
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertTrue(iterator.hasNext());
	iterator.next();
	assertFalse(iterator.hasNext());
	iterator.next();
    }

    protected Tree<SimpleTreeNode> createEmptyTree() {
	return createTree();
    }

    protected Tree<SimpleTreeNode> createOneNodeTree() {
	return createTree(createNode(0l));
    }

    protected Tree<SimpleTreeNode> createSimpleTree() {
	return createTree(createNode(0l)
	    .addChild(1l)
	    .addChild(2l));
    }

    protected Tree<SimpleTreeNode> createTreeWithLeftChild() {
	return createTree(createNode(0l).addChild(1l));
    }

    protected Tree<SimpleTreeNode> createTreeWithRightChild() {
	return createTree(createNode(0l).addChild(2l));
    }

    protected Tree<SimpleTreeNode> createNestedTree() {
	return createTree(createNode(0l)
	    .addChild(
		createNode(1l).addChild(11l)
	    )
	    .addChild(2l));
    }

    protected Tree<SimpleTreeNode> createDeepNestedTree() {
	return createTree(createNode(0l)
	    .addChild(createNode(1l)
		.addChild(createNode(11l)
		    .addChild(111l)
		    .addChild(112l))
		.addChild(createNode(12l)
		    .addChild(121l)
		    .addChild(122l))
	    )
	    .addChild(2l));
    }

    protected Tree<SimpleTreeNode> createNotFullTree() {
	return createTree(createNode(0l)
	    .addChild(createNode(1l)
		.addChild(createNode(11l)
		    .addChild(111l)
		    .addChild(112l))
		.addChild(createNode(12l)
		    .addChild(122l))
	    )
	    .addChild(2l));
    }

    protected Long getNextValue(Iterator<SimpleTreeNode> iterator) {
	return iterator.next()
	    .getValue();
    }

    protected abstract Iterator<SimpleTreeNode> getIterator(
	Tree<SimpleTreeNode> tree);

}
