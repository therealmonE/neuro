package io.github.therealmone.matrix.model;

import java.util.Arrays;

public class Matrix {
    private final Double[][] data;

    public Matrix(final int row, final int column) {
      this.data = new Double[row][column];
    }

    public Matrix(final int row) {
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

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder();
        for(final Double[] row : data) {
            out.append(Arrays.toString(row)).append("\n");
        }
        return out.toString();
    }
}
