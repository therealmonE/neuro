package io.github.therealmone.xorProblem;

import com.google.inject.Inject;
import io.github.therealmone.xorProblem.model.Point;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final Canvas canvas;

    @Inject
    public Window(final Canvas canvas) {
        this.canvas = canvas;
        init();
    }

    private void init() {
        setTitle("Xor problem");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
        setLocation(500, 200);
        final GridLayout layout = new GridLayout(1, 1);
        setLayout(layout);
        add(canvas);
        setVisible(true);
        setResizable(false);
    }

    public void setPoint(final Point point) {
        canvas.setPoint(point);
    }

    public void update() {
        canvas.repaint();
    }
}
