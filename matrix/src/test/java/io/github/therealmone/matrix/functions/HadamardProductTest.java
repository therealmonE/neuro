package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class HadamardProductTest {
    private final HadamardProduct hadamardProduct = new HadamardProduct();

    @Test
    public void normal() {
        final Matrix matrix = hadamardProduct.apply(new Matrix(new Double[][] {
                {1d, 2d},
                {3d, 4d}
        }), new Matrix(new Double[][] {
                {5d, 6d},
                {7d, 8d}
        }));
        assertEquals(2, matrix.getRowCount());
        assertEquals(2, matrix.getColumnCount());
        assertEquals(5d, matrix.getValue(0, 0), 0);
        assertEquals(12d, matrix.getValue(0, 1), 0);
        assertEquals(21d, matrix.getValue(1, 0), 0);
        assertEquals(32d, matrix.getValue(1, 1), 0);
    }

    @Test
    public void different_sizes() {
        final Matrix matrix = hadamardProduct.apply(new Matrix(new Double[][] {
                {1d, 2d, 3d, 4d}
        }), new Matrix(new Double[][] {
                {5d, 6d},
                {7d, 8d},
                {7d, 8d}
        }));
        assertNull(matrix);
    }

    @Test(expected = NullPointerException.class)
    public void null_args() {
        hadamardProduct.apply(null, null);
    }
}
