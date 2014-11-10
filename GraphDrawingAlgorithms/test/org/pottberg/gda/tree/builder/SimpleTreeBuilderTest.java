package org.pottberg.gda.tree.builder;

import static org.junit.Assert.*;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createTree;

import org.junit.Test;
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public class SimpleTreeBuilderTest {

    @Test
    public void testSimpleTree() {
	Tree<SimpleTreeNode> tree = createTree(
	    createNode(0l)
		.addChild(1l)
		.addChild(2l));
	SimpleTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getChildNode(0)
	    .getValue());
	assertEquals(new Long(2), root.getChildNode(1)
	    .getValue());
    }

    @Test
    public void testThreeChildNodes() {
	Tree<SimpleTreeNode> tree = createTree(
	    createNode(0l)
		.addChild(1l)
		.addChild(2l)
		.addChild(3l));
	SimpleTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getChildNode(0)
	    .getValue());
	assertEquals(new Long(2), root.getChildNode(1)
	    .getValue());
	assertEquals(new Long(3), root.getChildNode(2)
	    .getValue());
	assertNull(root.getChildNode(3));
    }

    @Test
    public void testComplexTree() {
	Tree<SimpleTreeNode> tree = createTree(createNode(0l)
	    .addChild(
		createNode(1l).addChild(11l)
	    )
	    .addChild(2l));
	SimpleTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getChildNode(0)
	    .getValue());
	assertEquals(new Long(11), root.getChildNode(0)
	    .getChildNode(0)
	    .getValue());
	assertEquals(new Long(2), root.getChildNode(1)
	    .getValue());
    }

    @Test
    public void testComplexTreeSimplified() {
	Tree<SimpleTreeNode> tree = createTree(
	    createNode(0l)
		.addChild(
		    createNode(1l).addChild(11l)
		)
		.addChild(2l)
	    );
	SimpleTreeNode root = tree.getRoot();
	assertEquals(new Long(0), root.getValue());
	assertEquals(new Long(1), root.getChildNode(0)
	    .getValue());
	assertEquals(new Long(11), root.getChildNode(0)
	    .getChildNode(0)
	    .getValue());
	assertEquals(new Long(2), root.getChildNode(1)
	    .getValue());
    }

}
