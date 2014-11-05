package org.pottberg.gda;

import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createTree;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;

import org.pottberg.gda.tree.BinaryTree;
import org.pottberg.gda.tree.DrawableTreeNode;
import org.pottberg.gda.tree.SimpleBinaryTreeNode;
import org.pottberg.gda.tree.algorithms.BinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.HVBinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.HVBinaryTreeAlgorithm.Combination;
import org.pottberg.gda.tree.algorithms.RadialTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.TreeAlgorithm;

public class GraphDrawingAlgorithmsController {

    @FXML
    private Group canvas;

    @FXML
    private void initialize() {
	BinaryTree<SimpleBinaryTreeNode> tree = createTree(
	    createNode(0l)
		.addLeftChild(createNode(1l)
		    .addLeftChild(createNode(11l)
			.addLeftChild(111l)
			.addRightChild(112l))
		    .addRightChild(createNode(12l)
			.addLeftChild(121l)
			.addRightChild(122l))
		)
		.addRightChild(2l));
	// BinaryTreeAlgorithm algorithm = new
	// LayeredBinaryTreeAlgorithm<SimpleBinaryTreeNode>( tree);
	BinaryTreeAlgorithm algorithm = new HVBinaryTreeAlgorithm<SimpleBinaryTreeNode>(
	 tree, Combination.HORIZONTAL);
	//TreeAlgorithm algorithm = new RadialTreeAlgorithm<>(tree);

	algorithm.execute();

	int scale = 100;
	
	for (int i = 1; i <= tree.getHeight(); i++) {
	    Circle circle = new Circle(i * scale);
	    circle.setStroke(Color.GRAY);
	    circle.setFill(Color.TRANSPARENT);
	    circle.setCenterX(0);
	    circle.setCenterY(0);

	    canvas.getChildren()
		.add(circle);
	}

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

	    Text text = new Text(node.toString());
	    text.setStroke(Color.WHITE);
	    text.setX(node.getX() * scale);
	    text.setY(node.getY() * scale);
	    text.setTextAlignment(TextAlignment.CENTER);
	    text.setBoundsType(TextBoundsType.VISUAL);

	    StackPane stack = new StackPane();
	    stack.getChildren()
		.addAll(circle, text);
	    stack.relocate(node.getX() * scale, node.getY() * scale);
	    stack.translateXProperty()
		.bind(stack.widthProperty()
		    .divide(-2));
	    stack.translateYProperty()
		.bind(stack.heightProperty()
		    .divide(-2));

	    canvas.getChildren()
		.add(stack);
	}
    }

}
