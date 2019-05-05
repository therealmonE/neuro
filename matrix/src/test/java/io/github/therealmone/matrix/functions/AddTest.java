package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTest {
    private final Add add = new Add();

    @Test
    public void normal() {
        final Matrix matrix = new Matrix(new Double[][] {
                {1d, 2d},
                {3d, 4d}
        });
        final Matrix newMatrix = add.apply(matrix, 1d);
        assertEquals(2d, newMatrix.getValue(0, 0), 0);
        assertEquals(3d, newMatrix.getValue(0, 1), 0);
        assertEquals(4d, newMatrix.getValue(1, 0), 0);
        assertEquals(5d, newMatrix.getValue(1, 1), 0);
    }

    @Test(expected = NullPointerException.class)
    public void null_value() {
        final Matrix matrix = new Matrix(new Double[][] {
                {1d, 2d},
                {3d, 4d}
        });
        add.apply(matrix, null);
    }
}
