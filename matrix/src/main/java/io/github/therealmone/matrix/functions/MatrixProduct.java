package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

import javax.annotation.Nullable;

public class MatrixProduct implements MatrixBiFunction<Matrix, Matrix, Matrix> {

    @Override
    @Nullable
    public Matrix apply(final Matrix firstMatrix, final Matrix secondMatrix) {
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

}
