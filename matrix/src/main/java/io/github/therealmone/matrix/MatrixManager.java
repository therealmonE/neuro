package io.github.therealmone.matrix;

import com.sun.istack.internal.Nullable;
import io.github.therealmone.matrix.model.Matrix;

public interface MatrixManager {
    /**
     *
     * Возвращает матричный продукт из двух матриц
     *
     * Условие : количество столбцов первой матрицы должно быть равно
     * количеству строк второй матрицы
     *
     * @param firstMatrix - первая матрица
     * @param secondMatrix - вторая матрица
     * @return матричный продукт
     */
    Matrix matrixProduct(Matrix firstMatrix, Matrix secondMatrix);

    /**
     *
     * Возвращает транспонированную матрицу
     *
     * @param matrix - матрица
     * @return транспонированную матрицу
     */
    @Nullable
    Matrix transpose(Matrix matrix);

    /**
     *
     * Возвращает матрицу, умноженное на значение
     *
     * @param matrix - матрица
     * @param value - значение
     * @return матрицу, умноженную на значение
     */
    Matrix scalar(Matrix matrix, Double value);

    /**
     *
     * Возвращает матрицу, суммированную со значением
     *
     * @param matrix - матрица
     * @param value - значение
     * @return матрицу, суммированную со значением
     */
    Matrix add(Matrix matrix, Double value);

    /**
     *
     * Возвращаем матрицу из массива данных
     * Размеры выходной матрицы: array.length x 1
     *
     * @param array - массив
     * @return матрицу из массива данных
     */
    Matrix fromArray(double[] array);


    /**
     *
     * Возвращает матрицу размерночти rows X columns,
     * заполненную случайными значениями от 0 до 1
     *
     * @param rows - количество строк
     * @param columns - количество столбцов
     * @return матрицу, заполненную случайными значениями
     */
    Matrix randomMatrix(final int rows, final int columns);
}
