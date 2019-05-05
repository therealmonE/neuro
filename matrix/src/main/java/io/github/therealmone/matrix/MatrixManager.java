package io.github.therealmone.matrix;

import io.github.therealmone.matrix.model.Matrix;

import javax.annotation.Nullable;
import java.util.function.Function;

public interface MatrixManager {

    /**
     * Возвращает матричный продукт из двух матриц
     *
     * Условие : количество столбцов первой матрицы должно быть равно
     * количеству строк второй матрицы
     *
     * @param firstMatrix - первая матрица
     * @param secondMatrix - вторая матрица
     * @return матричный продукт или null, если количество столбцов
     * первой матрицы не равно количеству строк второй матрицы
     */
    @Nullable
    Matrix matrixProduct(final Matrix firstMatrix, final Matrix secondMatrix);

    /**
     * Возвращает hadamard продукт от двух матриц
     *
     * Условие : размерности матриц должны совпадать
     *
     * @param firstMatrix - первая матрица
     * @param secondMatrix - вторая матрица
     * @return hadamard продукт или null, если размерности
     * матриц не совпадают
     */
    @Nullable
    Matrix hadamardProduct(final Matrix firstMatrix, final Matrix secondMatrix);

    /**
     * Возвращает транспонированную матрицу
     *
     * @param matrix - матрица
     * @return транспонированную матрицу
     */
    Matrix transpose(final Matrix matrix);

    /**
     * Возвращает матрицу, умноженное на значение
     *
     * @param matrix - матрица
     * @param value - значение
     * @return матрицу, умноженную на значение
     */
    Matrix scalar(final Matrix matrix, final Double value);

    /**
     * Возвращает матрицу, суммированную со значением
     *
     * @param matrix - матрица
     * @param value - значение
     * @return матрицу, суммированную со значением
     */
    Matrix add(final Matrix matrix, final Double value);

    /**
     * Возвращаем матрицу из массива данных
     * Размеры выходной матрицы: array.length x 1
     *
     * @param array - массив
     * @return матрицу из массива данных
     */
    Matrix fromArray(final double[] array);


    /**
     * Возвращает матрицу размерночти rows X columns,
     * заполненную случайными значениями от 0 до 1
     *
     * @param rows - количество строк
     * @param columns - количество столбцов
     * @return матрицу, заполненную случайными значениями
     */
    Matrix randomMatrix(final int rows, final int columns);

    /**
     * Пропускает каждое значение в матрице через функцию
     *
     * @param matrix - матрица
     * @param function - функция маппинга
     * @return матрицу, значения которой были пропущены через функцию маппинга
     */
    Matrix map(final Matrix matrix, final Function<Double, Double> function);
}
