package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {
    private final Scalar scalar = new Scalar();

    @Test
    public void normal() {
        final Matrix matrix = scalar.apply(
                new Matrix(new Double[][] {
                        {1d, 2d},
                        {3d, 4d}
                }),
                2d
        );
        assertEquals(2d, matrix.getValue(0, 0), 0);
        assertEquals(4d, matrix.getValue(0, 1), 0);
        assertEquals(6d, matrix.getValue(1, 0), 0);
        assertEquals(8d, matrix.getValue(1, 1), 0);
    }

    @Test(expected = NullPointerException.class)
    public void null_value() {
        scalar.apply(
                new Matrix(new Double[][] {
                        {1d, 2d}
                }),
                null
        );
    }
}
