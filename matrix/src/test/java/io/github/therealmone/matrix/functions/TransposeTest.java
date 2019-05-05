package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransposeTest {
    private final Transpose transpose = new Transpose();

    @Test
    public void normal() {
        final Matrix matrix = transpose.apply(
                new Matrix(new Double[][] {
                        {1d, 2d},
                        {3d, 4d},
                        {5d, 6d}
                })
        );
        assertEquals(1d, matrix.getValue(0, 0), 0);
        assertEquals(3d, matrix.getValue(0, 1), 0);
        assertEquals(5d, matrix.getValue(0, 2), 0);
        assertEquals(2d, matrix.getValue(1, 0), 0);
        assertEquals(4d, matrix.getValue(1, 1), 0);
        assertEquals(6d, matrix.getValue(1, 2), 0);
    }

    @Test(expected = NullPointerException.class)
    public void null_matrix() {
        transpose.apply(null);
    }
}
