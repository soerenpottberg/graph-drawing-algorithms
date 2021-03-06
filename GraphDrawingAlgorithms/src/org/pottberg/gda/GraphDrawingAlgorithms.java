package org.pottberg.gda;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class GraphDrawingAlgorithms extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource(
		"gui\\view\\GraphDrawingAlgorithms.fxml"));
	    Scene scene = new Scene(root, 900, 900);
	    scene.getStylesheets()
		.add(getClass().getResource("gui\\view\\application.css")
		    .toExternalForm());
	    primaryStage.setScene(scene);
	    primaryStage.show();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }
}
