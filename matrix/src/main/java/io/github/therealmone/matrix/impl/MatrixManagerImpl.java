package io.github.therealmone.matrix.impl;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;

import java.util.Random;

public class MatrixManagerImpl implements MatrixManager {
    //todo:

    @Override
    public Matrix matrixProduct(Matrix firstMatrix, Matrix secondMatrix) {
        if(firstMatrix.getColumnCount() == secondMatrix.getRowCount()){
            return null;
        }
        Matrix matrixProduct = new Matrix(firstMatrix.getRowCount(), secondMatrix.getColumnCount());
        for(int i = 0; i < firstMatrix.getRowCount(); i++){ //каждую строку из первой матрицы
            for(int k = 0; k < secondMatrix.getColumnCount(); k++){ //умножаю на каждый столбец из второй матрицы
                double multiplyRowByColumnResult = 0;
                for (int l = 0; l < firstMatrix.getColumnCount(); l++) { // складывая произведения элементов
                    multiplyRowByColumnResult += firstMatrix.getValue(i,l) * secondMatrix.getValue(l,k);
                }
                matrixProduct.setValue(i,k,multiplyRowByColumnResult); //
            }
        }
        return matrixProduct;
    }

    @Override
    public Matrix transpose(Matrix matrix) {
        Matrix transposeMatrix = new Matrix(matrix.getColumnCount(), matrix.getRowCount());
        for(int i = 0; i < matrix.getRowCount(); i++){ //для каждой строки матрицы
            for(int k = 0; k < matrix.getColumnCount(); k++){ //берем каждый элемент
                transposeMatrix.setValue(k, i, matrix.getValue(i,k));
            }
        }
        return transposeMatrix;
    }

    @Override
    public Matrix scalar(Matrix matrix, Double value) {
        //нужно ли создавать новую матрицу? если нет, то не будет ли изменена сама передаваемая матрица в вызывающем методе?
        for(int i = 0; i < matrix.getRowCount(); i++){
            for (int k = 0; k < matrix.getColumnCount(); k++){
                matrix.setValue(i,k,matrix.getValue(i,k) * value);
            }
        }
        return matrix;
    }

    @Override
    public Matrix add(Matrix matrix, Double value) {
        for(int i = 0; i < matrix.getRowCount(); i++){
            for (int k = 0; k < matrix.getColumnCount(); k++){
                matrix.setValue(i,k,matrix.getValue(i,k) + value);
            }
        }
        return matrix;
    }

    @Override
    public Matrix fromArray(double[] array) {
        Matrix matrix = new Matrix(array.length);
        for(int i = 0; i < array.length; i++){
            matrix.setValue(i,array[i]);
        }
        return matrix;
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
