package io.github.therealmone.matrix.functions;

import java.util.function.BiFunction;

/**
 * Интерфейс для обозначения функций над двумя матрицами
 *
 * @param <T> тип первого параметра
 * @param <U> тип второго параметра
 * @param <R> тип результата
 */
public interface MatrixBiFunction<T, U, R> extends BiFunction<T, U, R> {
}
