package io.github.therealmone.trainer;

import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;

@FunctionalInterface
public interface TrainingFunction {
    void train(AbstractNeuralNetwork neuralNetwork, Matrix inputs, Matrix targets);
}
