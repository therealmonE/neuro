package io.github.therealmone.matrix.model;

import java.util.Arrays;

public class Matrix extends DataContainer<Double> {

    public Matrix(final int row, final int column) {
        super(row, column);
    }

    public Matrix(final int row) {
        super(row, 1);
    }

    public Matrix(final Double[][] data) {
        super(data);
    }

    public void setValue(final int row, final Double value) {
        setValue(row, 0, value);
    }

    public Double getValue(int row) {
        return getValue(row, 0);
    }

    public int getRowCount() {
        return this.data.length;
    }

    public int getColumnCount() {
        return this.data[0].length;
    }

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder();
        for(final Number[] row : data) {
            out.append(Arrays.toString(row)).append("\n");
        }
        return out.toString();
    }
}
