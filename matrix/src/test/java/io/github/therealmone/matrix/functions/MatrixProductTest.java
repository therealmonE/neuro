package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixProductTest {
    private final MatrixProduct matrixProduct = new MatrixProduct();

    @Test
    public void normal() {
        final Matrix matrix = matrixProduct.apply(
                new Matrix(new Double[][] {
                        {1d, 2d},
                        {3d, 4d}
                }),
                new Matrix(new Double[][] {
                        {1d, 2d},
                        {3d, 4d}
                })
        );
        assertNotNull(matrix);
        assertEquals(2, matrix.getRowCount());
        assertEquals(2, matrix.getColumnCount());
        assertEquals(7.0, matrix.getValue(0, 0), 0);
        assertEquals(10.0, matrix.getValue(0, 1), 0);
        assertEquals(15.0, matrix.getValue(1, 0), 0);
        assertEquals(22.0, matrix.getValue(1, 1), 0);
    }

    @Test
    public void invalid_sizes() {
        assertNull(matrixProduct.apply(
                new Matrix(new Double[][] {
                        {1d, 2d},
                        {3d, 4d}
                }),
                new Matrix(new Double[][] {
                        {5d}
                })
        ));
    }
}
