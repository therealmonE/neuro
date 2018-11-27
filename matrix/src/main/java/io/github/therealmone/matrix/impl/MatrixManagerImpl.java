package io.github.therealmone.matrix.impl;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;

import java.util.Random;

public class MatrixManagerImpl implements MatrixManager {
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
}
