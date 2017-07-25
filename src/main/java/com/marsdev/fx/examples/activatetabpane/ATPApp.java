/*
 * Copyright (c) 2017 Mercuria Energy America, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Mercuria Energy America, Inc ("Confidential Information").  You
 *  shall not disclose such Confidential Information and shall use
 *  it only in accordance with the terms of the license agreement you
 *  entered into with Mercuria Energy America, Inc.
 *
 *  ATPApp
 *  jchildress
 */
package com.marsdev.fx.examples.activatetabpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ATPApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button buttonBlue = new Button("Select blue");
        Button buttonGreen = new Button("Select green");
        HBox topBar = new HBox(5.0);
        topBar.getChildren().addAll(buttonBlue, buttonGreen);

        TabPane tabPane = new TabPane();

        Tab tab0 = new Tab("blue");
        tab0.setContent(new Rectangle(200, 200, Color.BLUE));

        Tab tab1 = new Tab("green");
        tab1.setContent(new Rectangle(200, 200, Color.GREEN));

        tabPane.getTabs().addAll(tab0, tab1);
        buttonBlue.setOnAction(e -> tabPane.getSelectionModel().select(tab0));
        buttonGreen.setOnAction(e -> tabPane.getSelectionModel().select(tab1));

        BorderPane content = new BorderPane();
        content.setTop(topBar);
        content.setCenter(tabPane);

        primaryStage.setScene(new Scene(content, 300, 300));
        primaryStage.show();
    }
}
