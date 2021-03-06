package com.marsdev.fx.acl;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author wbeebe
 */
public class TargetLayer implements CanvasLayer {

    @Override
    public void draw(GraphicsContext gc, double width, double height) {
        gc.fillOval((width - 40) / 2.0, (height - 40) / 2.0, 40, 40);

        Font font = gc.getFont();
        gc.fillText("Width: " + Double.toString(width), width / 2 + 2, font.getSize());

        // Some interesting graphics context manipulation. Move to the left
        // edge and print the height, rotated 90 degrees parallel to the
        // left edge.
        //
        gc.save();
        gc.translate(font.getSize(), height / 2);
        gc.rotate(-90);
        gc.fillText("Height: " + Double.toString(height), 2, 0);
        gc.restore();

        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeLine(0, 0, width, height);
        gc.strokeLine(0, height, width, 0);
        gc.strokeLine(width / 2.0, 0, width / 2.0, height);
        gc.strokeLine(0, height / 2.0, width, height / 2.0);
    }
}
