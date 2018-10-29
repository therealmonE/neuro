package io.github.therealmone.matrix.impl;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;

import java.util.Random;

public class MatrixManagerImpl implements MatrixManager {
    //todo:

    @Override
    public Matrix matrixProduct(Matrix firstMatrix, Matrix secondMatrix) {
        return null;
    }

    @Override
    public Matrix transpose(Matrix matrix) {
        return null;
    }

    @Override
    public Matrix scalar(Matrix matrix, Double value) {
        return null;
    }

    @Override
    public Matrix add(Matrix matrix, Double value) {
        return null;
    }

    @Override
    public Matrix fromArray(double[] array) {
        return null;
    }

    @Override
    public Matrix randomMatrix(int rows, int columns) {
        final Random random = new Random();
        final Matrix matrix = new Matrix(rows, columns);
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                matrix.setValue(i, j, random.nextDouble());
            }
        }
        return matrix;
    }
}
