package io.github.therealmone.trainer;

import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;

public interface NeuralNetworkTrainer {

    /**
     *
     * Пропускает входные значения через нейросеть
     * Размеры входной и выходной матрицы зависят от конфигурации сети
     *
     * @param inputs - матрица входных значений
     * @return матрицу выходных значений
     */
    Matrix feedForward(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs);

    /**
     *
     * Тренирует нейросеть на входных и целевых значениях
     * Метод тренировки задается функцией trainingFunction
     *
     * @param neuralNetwork - конфигурированная нейронная сеть
     * @param inputs - матрица входных значений
     * @param targets - матрица целевых значений
     */
    void train(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs, final Matrix targets, final double learningRate);
}
