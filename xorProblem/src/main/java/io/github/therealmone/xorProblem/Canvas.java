package io.github.therealmone.xorProblem;

import com.google.inject.Inject;
import io.github.therealmone.xorProblem.model.Point;

import java.util.*;

import javax.inject.Named;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JPanel {
    private final List<Point> points;
    private final Integer pixelSize;

    @Inject
    public Canvas(
            @Named("CanvasWidth") final Integer width,
            @Named("CanvasHeight") final Integer height,
            @Named("PixelSize") final Integer pixelSize) {
        setSize(new Dimension(width, height));
        setBackground(new Color(0));
        this.points = Collections.synchronizedList(new ArrayList<>());
        this.pixelSize = pixelSize;
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        synchronized (points) {
            for(final Point point : points) {
                graphics.setColor(point.getColor());
                graphics.fillRect(point.getX(), point.getY(), pixelSize, pixelSize);
            }
        }
    }

    public void setPoint(final Point point) {
        points.add(point);
    }
}
