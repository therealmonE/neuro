package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

public class Transpose implements MatrixFunction<Matrix, Matrix> {

    @Override
    public Matrix apply(final Matrix matrix) {
        final Matrix transposedMatrix = new Matrix(matrix.getColumnCount(), matrix.getRowCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for(int k = 0; k < matrix.getColumnCount(); k++) {
                transposedMatrix.setValue(k, i, matrix.getValue(i, k));
            }
        }
        return transposedMatrix;
    }

}
