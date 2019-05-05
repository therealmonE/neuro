package io.github.therealmone.matrix.functions;

import java.util.function.Function;

/**
 * Интерфейс для обозначения функции над матрицей
 *
 * @param <T> тип входного знаения
 * @param <R> тип результата
 */
public interface MatrixFunction<T, R> extends Function<T, R> {
}
