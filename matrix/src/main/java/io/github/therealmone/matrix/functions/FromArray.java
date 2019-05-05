package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

public class FromArray implements MatrixFunction<double[], Matrix> {

    @Override
    public Matrix apply(final double[] array) {
        final Matrix matrix = new Matrix(array.length);
        for(int i = 0; i < array.length; i++) {
            matrix.setValue(i, array[i]);
        }
        return matrix;
    }

}
