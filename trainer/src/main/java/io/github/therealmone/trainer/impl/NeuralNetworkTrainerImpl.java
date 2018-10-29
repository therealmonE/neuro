package io.github.therealmone.trainer.impl;

import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.trainer.TrainingFunction;

public class NeuralNetworkTrainerImpl implements NeuralNetworkTrainer {
    @Override
    public Matrix feedForward(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs) {
        return null;
    }

    @Override
    public void train(final AbstractNeuralNetwork neuralNetwork, final TrainingFunction trainingFunction, final Matrix inputs, final Matrix targets) {
        trainingFunction.train(neuralNetwork, inputs, targets);
    }
}
