package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

import java.util.Random;

public class RandomMatrix implements MatrixBiFunction<Integer, Integer, Matrix> {

    @Override
    public Matrix apply(final Integer rows, final Integer columns) {
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
