package com.marsdev.scratch;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.text.AttributedString;

/**
 * http://www.jfree.org/forum/viewtopic.php?f=34&t=116969
 */
public class FXGraphics2DDemo2 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MyCanvas canvas = new MyCanvas();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(canvas);
        // Bind canvas size to stack pane size.
        canvas.widthProperty().bind(stackPane.widthProperty());
        canvas.heightProperty().bind(stackPane.heightProperty());
        stage.setScene(new Scene(stackPane));
        stage.setTitle("FXGraphics2DDemo2.java");
        stage.setWidth(700);
        stage.setHeight(390);
        stage.show();

    }

    static class MyCanvas extends Canvas {

        TextLayout textLayout;

        private FXGraphics2D g2;

        public MyCanvas() {
            this.g2 = new FXGraphics2D(getGraphicsContext2D());

            AttributedString as = new AttributedString("Hello World!");
            as.addAttribute(TextAttribute.FONT, new Font("serif", Font.PLAIN, 24));

            this.textLayout = new TextLayout(as.getIterator(), this.g2.getFontRenderContext());
            // Redraw canvas when size changes.
            widthProperty().addListener(evt -> draw());
            heightProperty().addListener(evt -> draw());
        }

        private void draw() {
            double width = getWidth();
            double height = getHeight();
            getGraphicsContext2D().clearRect(0, 0, width, height);
            this.textLayout.draw(this.g2, 50, 50);

            Rectangle2D r = new Rectangle2D.Double(60, 60, 60, 70);
            this.g2.setStroke(new BasicStroke(0.5f));
            this.g2.setPaint(Color.BLACK);
            this.g2.draw(r);
        }

        @Override
        public boolean isResizable() {
            return true;
        }

        @Override
        public double prefWidth(double height) {
            return getWidth();
        }

        @Override
        public double prefHeight(double width) {
            return getHeight();
        }
    }

}
