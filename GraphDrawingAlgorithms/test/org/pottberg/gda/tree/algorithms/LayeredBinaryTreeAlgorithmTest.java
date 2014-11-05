package org.pottberg.gda.tree.algorithms;

import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createTree;

import org.junit.Test;
import org.pottberg.gda.node.DrawableNode;
import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;

public class LayeredBinaryTreeAlgorithmTest {

    @Test
    public void test() {
	BinaryTree<SimpleBinaryTreeNode> tree = createTree(createNode(0l)
	    .addLeftChild(createNode(1l)
		.addLeftChild(createNode(11l)
		    .addLeftChild(111l)
		    .addRightChild(112l) )
		.addRightChild(createNode(12l)
		    .addLeftChild(121l)
		    .addRightChild(122l))
	    )
	    .addRightChild(2l));
	LayeredBinaryTreeAlgorithm<?> algorithm = new LayeredBinaryTreeAlgorithm<SimpleBinaryTreeNode>(tree);
			
	for (DrawableNode node : tree.createPreOrderIterable()) {
	    System.out.println(node);
	}
	algorithm.execute();
	for (DrawableNode node : tree.createPreOrderIterable()) {
	    System.out.println(node);
	}
    }

}
