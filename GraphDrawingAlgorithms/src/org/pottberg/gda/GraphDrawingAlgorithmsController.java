package org.pottberg.gda;

import static org.pottberg.gda.tree.builder.SimpleAttributedBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleAttributedBinaryTreeBuilder.createTree;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.DrawableTreeNode;
import org.pottberg.gda.tree.algorithms.LayeredBinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.SimpleLayeredBinaryTreeNode;

public class GraphDrawingAlgorithmsController {

    @FXML
    private Group canvas;

    @FXML
    private void initialize() {
	BinaryTree<SimpleLayeredBinaryTreeNode> tree = createTree(
	    createNode(SimpleLayeredBinaryTreeNode.class, 0l)
		.addLeftChild(
		    createNode(SimpleLayeredBinaryTreeNode.class, 1l)
			.addLeftChild(
			    createNode(SimpleLayeredBinaryTreeNode.class, 11l)
				.addLeftChild(111l)
				.addRightChild(112l))
			.addRightChild(
			    createNode(SimpleLayeredBinaryTreeNode.class, 12l)
				.addLeftChild(121l)
				.addRightChild(122l))
		)
		.addRightChild(2l), value -> new SimpleLayeredBinaryTreeNode(
		value));
	LayeredBinaryTreeAlgorithm<SimpleLayeredBinaryTreeNode> algorithm = new LayeredBinaryTreeAlgorithm<>(
	    tree);

	algorithm.execute();

	int scale = 100;
	
	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    if (node.isRootNode()) {
		continue;
	    }
	    DrawableTreeNode<?> parent = node.getParentNode();
	    Line line = new Line();
	    line.setStartX(parent.getX() * scale);
	    line.setStartY(parent.getY() * scale);
	    line.setEndX(node.getX() * scale);
	    line.setEndY(node.getY() * scale);
	    canvas.getChildren()
		.add(line);
	}
	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    Color nodeColor = node.isRootNode() ? Color.RED : Color.BLUE;
	    Circle circle = new Circle(0.2 * scale, nodeColor);
	    circle.setCenterX(node.getX() * scale);
	    circle.setCenterY(node.getY() * scale);
	    canvas.getChildren()
		.add(circle);
	}
	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    Text text = new Text(node.toString());
	    text.setStroke(Color.WHITE);
	    text.setX(node.getX() * scale);
	    text.setY(node.getY() * scale);
	    canvas.getChildren()
		.add(text);
	}
    }

}
