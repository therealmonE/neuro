package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class FromArrayTest {
    private final FromArray fromArray = new FromArray();

    @Test
    public void normal() {
        final Matrix matrix = fromArray.apply(new double[] {1d, 2d, 3d, 4d});
        assertEquals(1d, matrix.getValue(0), 0);
        assertEquals(2d, matrix.getValue(1), 0);
        assertEquals(3d, matrix.getValue(2), 0);
        assertEquals(4d, matrix.getValue(3), 0);
    }

    @Test(expected = NullPointerException.class)
    public void null_array() {
        fromArray.apply(null);
    }
}
