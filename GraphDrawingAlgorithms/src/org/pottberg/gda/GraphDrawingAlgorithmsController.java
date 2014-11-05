package org.pottberg.gda;

import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createTree;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
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
import org.pottberg.gda.tree.algorithms.LayeredBinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.RadialTreeAlgorithm;

public class GraphDrawingAlgorithmsController {

    @FXML
    private FlowPane canvasList;

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
	List<BinaryTreeAlgorithm> algorithms = new ArrayList<>();
	algorithms.add(new HVBinaryTreeAlgorithm<SimpleBinaryTreeNode>(tree,
	    Combination.HORIZONTAL));
	algorithms.add(new HVBinaryTreeAlgorithm<SimpleBinaryTreeNode>(tree,
	    Combination.VERTICAL));
	algorithms.add(new RadialTreeAlgorithm<SimpleBinaryTreeNode>(tree));
	algorithms.add(new LayeredBinaryTreeAlgorithm<SimpleBinaryTreeNode>(
	    tree));
	
	for (BinaryTreeAlgorithm algorithm : algorithms) {
	    algorithm.execute();
	    Group canvas = new Group();
	    drawNodes(tree, canvas, algorithm.isRadialLayout());
	    canvasList.getChildren()
		.add(canvas);
	}
    }

    private void drawNodes(BinaryTree<SimpleBinaryTreeNode> tree, Group canvas,
	boolean isRadialLayout) {
	int scale = 80;

	if (isRadialLayout) {
	    drawCircles(tree, canvas, scale);
	} else {
	    drawGrid(tree, canvas, scale);
	}

	drawEdges(tree, canvas, scale);
	drawNodes(tree, canvas, scale);
    }

    private void drawCircles(BinaryTree<SimpleBinaryTreeNode> tree,
	Group canvas, int scale) {
	for (int i = 1; i <= tree.getHeight(); i++) {
	    Circle circle = new Circle(i * scale);
	    circle.setStroke(Color.GRAY);
	    circle.setFill(Color.TRANSPARENT);
	    circle.setCenterX(0);
	    circle.setCenterY(0);

	    canvas.getChildren()
		.add(circle);
	}
    }

    private void drawGrid(BinaryTree<SimpleBinaryTreeNode> tree, Group canvas,
	int scale) {

	double minX = 0;
	double maxX = 0;
	double minY = 0;
	double maxY = 0;

	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    maxX = Math.max(maxX, node.getX());
	    minX = Math.min(minX, node.getX());
	    maxY = Math.max(maxY, node.getY());
	    minY = Math.min(minY, node.getY());
	}

	minX--;
	maxX++;
	minY--;
	maxY++;

	for (double x = minX; x <= maxX; x++) {
	    Line line = new Line();
	    line.setStroke(Color.GRAY);
	    line.setStartX(x * scale);
	    line.setStartY(minY * scale);
	    line.setEndX(x * scale);
	    line.setEndY(maxY * scale);

	    canvas.getChildren()
		.add(line);
	}
	for (double y = minY; y <= maxY; y++) {
	    Line line = new Line();
	    line.setStroke(Color.GRAY);
	    line.setStartX(minX * scale);
	    line.setStartY(y * scale);
	    line.setEndX(maxX * scale);
	    line.setEndY(y * scale);

	    canvas.getChildren()
		.add(line);
	}
    }

    private void drawNodes(BinaryTree<SimpleBinaryTreeNode> tree, Group canvas,
	int scale) {
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

    private void drawEdges(BinaryTree<SimpleBinaryTreeNode> tree, Group canvas,
	int scale) {
	for (DrawableTreeNode<?> node : tree.createPreOrderIterable()) {
	    if (node.isRootNode()) {
		continue;
	    }
	    DrawableTreeNode<?> parent = node.getParentNode();
	    Line line = new Line();
	    line.setStrokeWidth(3);
	    line.setStartX(parent.getX() * scale);
	    line.setStartY(parent.getY() * scale);
	    line.setEndX(node.getX() * scale);
	    line.setEndY(node.getY() * scale);
	    canvas.getChildren()
		.add(line);
	}
    }

}
