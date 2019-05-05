package io.github.therealmone.matrix.model;

public abstract class DataContainer<T extends Number> {
    final Number[][] data;

    public DataContainer(final int rows, final int columns) throws IllegalArgumentException {
        if(rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Rows and columns count must be greater then 0");
        }
        this.data = new Number[rows][columns];
    }

    public DataContainer(final Number[][] data) {
        this.data = data;
    }

    /**
     * Установка нового значения в массив данных
     *
     * @param row номер строки
     * @param column номер столбца
     * @param value новое значение
     * @throws IndexOutOfBoundsException если номер строки или столбца
     * выходит за гранницы массива данных
     */
    public void setValue(final int row, final int column, final T value) throws IndexOutOfBoundsException {
        checkBounds(row, column);
        this.data[row][column] = value;
    }

    /**
     * Получение значения из массива данных
     *
     * @param row номер строки
     * @param column номер столбца
     * @return значение из массива данных в строке
     * row, столбце column
     * @throws IndexOutOfBoundsException если номер строки или столбца
     * вцыходит за границы массива данных
     */
    public T getValue(final int row, final int column) throws IndexOutOfBoundsException {
        checkBounds(row, column);
        //noinspection unchecked
        return (T) this.data[row][column];
    }

    /**
     * Проверка на вхождение индексов в играницы массива
     *
     * @param row номер строки
     * @param column номер столбца
     * @throws IndexOutOfBoundsException если номер строки или столбца
     * выходит за границы массива данных
     */
    private void checkBounds(final int row, final int column) throws IndexOutOfBoundsException {
        if(row < 0 || this.data.length < row) {
            throw new IndexOutOfBoundsException("Row index out of bounds: " + row);
        }
        if(column < 0 || this.data[0].length < column) {
            throw new IndexOutOfBoundsException("Column index out of bounds: " + column);
        }
    }
}
