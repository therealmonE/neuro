package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    private final Map map = new Map();

    @Test
    public void normal() {
        final Matrix matrix = map.apply(new Matrix(
                new Double[][] {
                        {1d, 2d},
                        {3d, 4d}
                }),
                value -> value * 2);
        assertEquals(2d, matrix.getValue(0, 0), 0);
        assertEquals(4d, matrix.getValue(0, 1), 0);
        assertEquals(6d, matrix.getValue(1, 0), 0);
        assertEquals(8d, matrix.getValue(1, 1), 0);
    }

    @Test(expected = NullPointerException.class)
    public void null_function() {
        map.apply(new Matrix(new Double[][] {{1d, 2d}}), null);
    }
}
