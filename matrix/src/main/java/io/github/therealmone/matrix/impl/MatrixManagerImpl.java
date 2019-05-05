package io.github.therealmone.matrix.impl;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.functions.*;
import io.github.therealmone.matrix.model.Matrix;

import java.util.function.Function;

public class MatrixManagerImpl implements MatrixManager {
    private final MatrixProduct matrixProduct = new MatrixProduct();
    private final HadamardProduct hadamardProduct = new HadamardProduct();
    private final Transpose transpose = new Transpose();
    private final Scalar scalar = new Scalar();
    private final Add add = new Add();
    private final FromArray fromArray = new FromArray();
    private final RandomMatrix randomMatrix = new RandomMatrix();
    private final Map map = new Map();

    @Override
    public Matrix matrixProduct(final Matrix firstMatrix, final Matrix secondMatrix) {
        return matrixProduct.apply(firstMatrix, secondMatrix);
    }

    @Override
    public Matrix hadamardProduct(final Matrix firstMatrix, final Matrix secondMatrix) {
        return hadamardProduct.apply(firstMatrix, secondMatrix);
    }

    @Override
    public Matrix transpose(final Matrix matrix) {
        return transpose.apply(matrix);
    }

    @Override
    public Matrix scalar(final Matrix matrix, final Double value) {
        return scalar.apply(matrix, value);
    }

    @Override
    public Matrix add(final Matrix matrix, final Double value) {
        return add.apply(matrix, value);
    }

    @Override
    public Matrix fromArray(final double[] array) {
        return fromArray.apply(array);
    }

    @Override
    public Matrix randomMatrix(final int rows, final int columns) {
        return randomMatrix.apply(rows, columns);
    }

    @Override
    public Matrix map(final Matrix matrix, final Function<Double, Double> function) {
        return map.apply(matrix, function);
    }
}
