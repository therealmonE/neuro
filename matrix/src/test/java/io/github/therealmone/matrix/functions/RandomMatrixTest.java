package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomMatrixTest {
    private final RandomMatrix randomMatrix = new RandomMatrix();

    @Test
    public void normal() {
        final Matrix matrix = randomMatrix.apply(4, 4);
        assertEquals(4, matrix.getRowCount());
        assertEquals(4, matrix.getColumnCount());
    }

    @Test(expected = NullPointerException.class)
    public void null_values() {
        randomMatrix.apply(null, null);
    }
}
