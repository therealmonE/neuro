package io.github.therealmone.matrix.model;

import java.util.Random;

public class Matrix {
    private final Double[][] data;

    Matrix(final int row, final int column) {
      this.data = new Double[row][column];
    }

    Matrix(final int row) {
        this.data = new Double[row][1];
    }

    public void setValue(final int row, final int column, final Double value) {
        data[row][column] = value;
    }

    public void setValue(final int row, final Double value) {
        data[row][0] = value;
    }

    public Double getValue(final int row, final int column) {
        return data[row][column];
    }

    public Double getValue(int row) {
        return data[row][0];
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return data[0].length;
    }

    public void randomize() {
        final Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextDouble();
            }
        }
    }
}
