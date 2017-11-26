package com.marsdev.fx.acl;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author wbeebe
 */
public interface CanvasLayer {
    void draw(GraphicsContext gc, double width, double height);
}
