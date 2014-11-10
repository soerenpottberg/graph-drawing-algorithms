package org.pottberg.gda.gui.controller;

import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTree;
import static org.pottberg.gda.tree.builder.SimpleBinaryTreeBuilder.createBinaryTreeNode;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createNode;
import static org.pottberg.gda.tree.builder.SimpleTreeBuilder.createTree;

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
import org.pottberg.gda.tree.Tree;
import org.pottberg.gda.tree.algorithms.BinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.HVBinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.HVBinaryTreeAlgorithm.Combination;
import org.pottberg.gda.tree.algorithms.LayeredBinaryTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.RadialTreeAlgorithm;
import org.pottberg.gda.tree.algorithms.TreeAlgorithm;
import org.pottberg.gda.tree.nodes.DrawableTreeNode;
import org.pottberg.gda.tree.nodes.SimpleBinaryTreeNode;
import org.pottberg.gda.tree.nodes.SimpleTreeNode;

public class GraphDrawingAlgorithmsController {

    @FXML
    private FlowPane binaryTreesCanvasList;

    @FXML
    private FlowPane abitraryTreesCanvasList;

    @FXML
    private void initialize() {
	showBinaryTreeAlgorithms();
	showAbitraryTreeAlgorithms();
    }

    private void showBinaryTreeAlgorithms() {
	BinaryTree<SimpleBinaryTreeNode> tree = createBinaryTree(
	    createBinaryTreeNode(0l)
		.addLeftChild(createBinaryTreeNode(1l)
		    .addLeftChild(createBinaryTreeNode(11l)
			.addLeftChild(111l)
			.addRightChild(112l))
		    .addRightChild(createBinaryTreeNode(12l)
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
	    drawTree(tree, canvas, algorithm.isRadialLayout());
	    binaryTreesCanvasList.getChildren()
		.add(canvas);
	}
    }

    private void showAbitraryTreeAlgorithms() {
	Tree<SimpleTreeNode> tree = createTree(
	    createNode(0l)
		.addChild(createNode(1l)
		    .addChild(createNode(11l)
			.addChild(111l)
			.addChild(112l))
		    .addChild(createNode(12l)
			.addChild(121l)
			.addChild(122l)
			.addChild(123l))
		)
		.addChild(createNode(2l)
		    .addChild(createNode(21l)
			.addChild(211l)
			.addChild(212l)
			.addChild(213l)
		    )
		)
		.addChild(createNode(3l))
	    );
	List<TreeAlgorithm> algorithms = new ArrayList<>();
	algorithms.add(new RadialTreeAlgorithm<SimpleTreeNode>(tree));

	for (BinaryTreeAlgorithm algorithm : algorithms) {
	    algorithm.execute();
	    Group canvas = new Group();
	    drawTree(tree, canvas, algorithm.isRadialLayout());
	    abitraryTreesCanvasList.getChildren()
		.add(canvas);
	}
    }

    private void drawTree(Tree<? extends DrawableTreeNode<?>> tree,
	Group canvas,
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

    private void drawCircles(Tree<?> tree,
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

    private void drawGrid(Tree<? extends DrawableTreeNode<?>> tree,
	Group canvas,
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

    private void drawNodes(Tree<? extends DrawableTreeNode<?>> tree,
	Group canvas,
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

    private void drawEdges(Tree<? extends DrawableTreeNode<?>> tree,
	Group canvas,
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
