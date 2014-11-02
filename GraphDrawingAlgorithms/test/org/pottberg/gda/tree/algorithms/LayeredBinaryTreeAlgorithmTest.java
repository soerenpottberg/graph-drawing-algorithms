package org.pottberg.gda.tree.algorithms;

import static org.pottberg.gda.tree.builder.SimpleAttributedBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleAttributedBinaryTreeBuilder.createTree;

import org.junit.Test;
import org.pottberg.gda.node.DrawableNode;
import org.pottberg.gda.tree.BinaryTree;

public class LayeredBinaryTreeAlgorithmTest {

    @Test
    public void test() {
	BinaryTree<SimpleLayeredBinaryTreeNode> tree = createTree(createNode(SimpleLayeredBinaryTreeNode.class, 0l)
	    .addLeftChild(createNode(SimpleLayeredBinaryTreeNode.class, 1l)
		.addLeftChild(createNode(SimpleLayeredBinaryTreeNode.class, 11l)
		    .addLeftChild(111l)
		    .addRightChild(112l) )
		.addRightChild(createNode(SimpleLayeredBinaryTreeNode.class, 12l)
		    .addLeftChild(121l)
		    .addRightChild(122l))
	    )
	    .addRightChild(2l), value -> new SimpleLayeredBinaryTreeNode(value));
	LayeredBinaryTreeAlgorithm<SimpleLayeredBinaryTreeNode> algorithm = new LayeredBinaryTreeAlgorithm<>(tree);
			
	for (DrawableNode node : tree.createPreOrderIterable()) {
	    System.out.println(node);
	}
	algorithm.execute();
	for (DrawableNode node : tree.createPreOrderIterable()) {
	    System.out.println(node);
	}
    }

}
