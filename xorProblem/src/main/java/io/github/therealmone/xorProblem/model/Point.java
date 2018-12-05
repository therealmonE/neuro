package io.github.therealmone.xorProblem.model;

import java.awt.*;

public class Point {
    private final int x;
    private final int y;
    private final Color color;

    public Point(final int x, final int y, final Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }

    public int getY() {
        return y;
    }
}
