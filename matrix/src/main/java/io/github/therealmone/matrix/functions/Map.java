package io.github.therealmone.matrix.functions;

import io.github.therealmone.matrix.model.Matrix;

import java.util.function.Function;

public class Map implements MatrixBiFunction<Matrix, Function<Double, Double>, Matrix> {

    @Override
    public Matrix apply(final Matrix matrix, final Function<Double, Double> mapper) {
        final Matrix mappedMatrix = new Matrix(matrix.getRowCount(), matrix.getColumnCount());
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColumnCount(); j++) {
                mappedMatrix.setValue(i, j, mapper.apply(matrix.getValue(i, j)));
            }
        }
        return mappedMatrix;
    }

}
