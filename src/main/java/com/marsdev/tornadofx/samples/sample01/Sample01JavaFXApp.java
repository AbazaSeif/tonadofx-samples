package com.marsdev.tornadofx.samples.sample01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sample01JavaFXApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Button button = new Button("Click Me");

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Button Clicked", ButtonType.OK);
        alert.setHeaderText("Sample 01 JavaFX");

        button.setOnAction(e -> alert.show());

        root.setCenter(button);
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.setTitle("Sample 01 JavaFX");
        primaryStage.show();
    }
}
