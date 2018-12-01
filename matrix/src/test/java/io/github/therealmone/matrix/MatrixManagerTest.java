package io.github.therealmone.matrix;

import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.matrix.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixManagerTest {
    private final MatrixManager matrixManager = new MatrixManagerImpl();

    @Test
    public void add() {
        final Matrix matrix = createMatrix();
        final Matrix checkMatrix = matrixManager.add(matrix, -1.0);
        assertNotSame(checkMatrix, matrix);
        assertEquals(0, checkMatrix.getValue(0, 0), 0);
        assertEquals(1.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(2.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(3.0, checkMatrix.getValue(1, 1), 0);
    }

    @Test
    public void scalar() {
        final Matrix matrix = createMatrix();
        final Matrix checkMatrix = matrixManager.scalar(matrix, 2.0);
        assertNotSame(matrix, checkMatrix);
        assertEquals(2.0, checkMatrix.getValue(0, 0), 0);
        assertEquals(4.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(6.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(8.0, checkMatrix.getValue(1, 1), 0);
    }

    @Test
    public void transpose() {
        final Matrix matrix = createMatrix();
        final Matrix checkMatrix = matrixManager.transpose(matrix);
        assertNotSame(matrix, checkMatrix);
        assertEquals(1.0, checkMatrix.getValue(0, 0), 0);
        assertEquals(3.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(2.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(4.0, checkMatrix.getValue(1, 1), 0);
    }

    @Test
    public void matrix_product() {
        final Matrix firstMatrix = createMatrix();
        final Matrix secondMatrix = createMatrix();
        final Matrix checkMatrix = matrixManager.matrixProduct(firstMatrix, secondMatrix);
        assertNotSame(checkMatrix, firstMatrix);
        assertNotSame(checkMatrix, secondMatrix);
        assertEquals(2, checkMatrix.getRowCount());
        assertEquals(2, checkMatrix.getColumnCount());
        assertEquals(7.0, checkMatrix.getValue(0, 0), 0);
        assertEquals(10.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(15.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(22.0, checkMatrix.getValue(1, 1), 0);
    }

    @Test
    public void hadamard_product() {
        final Matrix firstMatrix = createMatrix();
        final Matrix secondMatrix = createMatrix();
        final Matrix checkMatrix = matrixManager.hadamardProduct(firstMatrix, secondMatrix);
        assertNotSame(checkMatrix, firstMatrix);
        assertNotSame(checkMatrix, secondMatrix);
        assertEquals(2, checkMatrix.getRowCount());
        assertEquals(2, checkMatrix.getColumnCount());
        assertEquals(1.0, checkMatrix.getValue(0, 0), 0);
        assertEquals(4.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(9.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(16.0, checkMatrix.getValue(1, 1), 0);
    }

    @Test
    public void map() {
        final Matrix matrix = createMatrix();
        final Matrix checkMatrix = matrixManager.map(matrix, x -> x * 2);
        assertNotSame(matrix, checkMatrix);
        assertEquals(2, checkMatrix.getRowCount());
        assertEquals(2, checkMatrix.getColumnCount());
        assertEquals(2.0, checkMatrix.getValue(0, 0), 0);
        assertEquals(4.0, checkMatrix.getValue(0, 1), 0);
        assertEquals(6.0, checkMatrix.getValue(1, 0), 0);
        assertEquals(8.0, checkMatrix.getValue(1, 1), 0);
    }

    private Matrix createMatrix() {
        final Matrix matrix = new Matrix(2, 2);
        matrix.setValue(0, 0, 1.0);
        matrix.setValue(0, 1, 2.0);
        matrix.setValue(1, 0, 3.0);
        matrix.setValue(1, 1, 4.0);
        return matrix;
    }
}
