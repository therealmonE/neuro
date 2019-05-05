package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

import javax.annotation.Nullable;

public class HadamardProduct implements MatrixBiFunction<Matrix, Matrix, Matrix> {

    @Override
    @Nullable
    public Matrix apply(final Matrix firstMatrix, final Matrix secondMatrix) {
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

}
