package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

public class Scalar implements MatrixBiFunction<Matrix, Double, Matrix> {

    @Override
    public Matrix apply(final Matrix matrix, final Double value) {
        final Matrix scaledMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for (int k = 0; k < matrix.getColumnCount(); k++) {
                scaledMatrix.setValue(i, k,matrix.getValue(i, k) * value);
            }
        }
        return scaledMatrix;
    }

}
