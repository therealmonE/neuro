package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

public class Add implements MatrixBiFunction<Matrix, Double, Matrix> {

    @Override
    public Matrix apply(final Matrix matrix, final Double value) {
        final Matrix returnMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for(int i = 0; i < matrix.getRowCount(); i++) {
            for (int k = 0; k < matrix.getColumnCount(); k++) {
                returnMatrix.setValue(i, k,matrix.getValue(i, k) + value);
            }
        }
        return returnMatrix;
    }

}
