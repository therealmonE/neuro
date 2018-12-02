package io.github.therealmone.matrix.impl;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;

import java.util.Random;
import java.util.function.Function;

public class MatrixManagerImpl implements MatrixManager {

    @Inject
    public MatrixManagerImpl() {

    }

    @Override
    public Matrix matrixProduct(final Matrix firstMatrix, final Matrix secondMatrix) {
        if(firstMatrix.getColumnCount() != secondMatrix.getRowCount()){
            return null;
        }

        final Matrix matrixProduct = new Matrix(firstMatrix.getRowCount(), secondMatrix.getColumnCount());
        for(int i = 0; i < firstMatrix.getRowCount(); i++) { //каждую строку из первой матрицы
            for(int k = 0; k < secondMatrix.getColumnCount(); k++) { //умножаю на каждый столбец из второй матрицы
                double multiplyRowByColumnResult = 0;
                for (int l = 0; l < firstMatrix.getColumnCount(); l++) { // складывая произведения элементов
                    multiplyRowByColumnResult += firstMatrix.getValue(i, l) * secondMatrix.getValue(l, k);
                }
                matrixProduct.setValue(i, k, multiplyRowByColumnResult);
            }
        }
        return matrixProduct;
    }

    @Override
    public Matrix hadamardProduct(final Matrix firstMatrix, final Matrix secondMatrix) {
        if(firstMatrix.getRowCount() != secondMatrix.getRowCount() || firstMatrix.getColumnCount() != secondMatrix.getColumnCount()) {
            return null;
        }

        final Matrix hadamardProduct = new Matrix(firstMatrix.getRowCount(), firstMatrix.getColumnCount());
        for (int i = 0; i < firstMatrix.getRowCount(); i++) {
            for (int j = 0; j < firstMatrix.getColumnCount(); j++) {
                hadamardProduct.setValue(i, j, firstMatrix.getValue(i, j) * secondMatrix.getValue(i, j));
            }
        }
        return hadamardProduct;
    }

    @Override
    public Matrix transpose(final Matrix matrix) {
        final Matrix transposeMatrix = new Matrix(matrix.getColumnCount(), matrix.getRowCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for(int k = 0; k < matrix.getColumnCount(); k++) {
                transposeMatrix.setValue(k, i, matrix.getValue(i, k));
            }
        }
        return transposeMatrix;
    }

    @Override
    public Matrix scalar(final Matrix matrix, final Double value) {
        final Matrix returnMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for (int k = 0; k < matrix.getColumnCount(); k++) {
                returnMatrix.setValue(i, k,matrix.getValue(i, k) * value);
            }
        }
        return returnMatrix;
    }

    @Override
    public Matrix add(final Matrix matrix, final Double value) {
        final Matrix returnMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for (int k = 0; k < matrix.getColumnCount(); k++) {
                returnMatrix.setValue(i, k,matrix.getValue(i, k) + value);
            }
        }
        return returnMatrix;
    }

    @Override
    public Matrix fromArray(final double[] array) {
        final Matrix matrix = new Matrix(array.length);
        for(int i = 0; i < array.length; i++) {
            matrix.setValue(i,array[i]);
        }
        return matrix;
    }

    @Override
    public Matrix randomMatrix(final int rows, final int columns) {
        final Random random = new Random();
        final Matrix matrix = new Matrix(rows, columns);
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                matrix.setValue(i, j, random.nextDouble());
            }
        }
        return matrix;
    }

    @Override
    public Matrix map(final Matrix matrix, final Function<Double, Double> function) {
        final Matrix mappedMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                mappedMatrix.setValue(i, j, function.apply(matrix.getValue(i, j)));
            }
        }
        return mappedMatrix;
    }
}
