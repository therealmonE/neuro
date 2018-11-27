package io.github.therealmone.trainer.impl;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.Layer;
import io.github.therealmone.model.Neuron;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.trainer.TrainingFunction;

public class NeuralNetworkTrainerImpl implements NeuralNetworkTrainer {
    private final MatrixManager matrixManager;
    private final TrainingFunction trainingFunction;

    @Inject
    public NeuralNetworkTrainerImpl(final MatrixManager matrixManager, final TrainingFunction trainingFunction) {
        this.matrixManager = matrixManager;
        this.trainingFunction = trainingFunction;
    }

    @Override
    public Matrix feedForward(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs) {
        return processNextLayer(neuralNetwork.getOutputLayer(),
               processNextLayer(neuralNetwork.getHiddenLayer(),
               processInputLayer(neuralNetwork.getInputLayer(), inputs)));
    }

    private Matrix processNextLayer(final Layer layer, final Matrix inputs) {
        final Matrix weightMatrix = buildWeightMatrix(layer);
        final Matrix matrixOfWeightedSum = matrixManager.matrixProduct(weightMatrix, inputs);

        final Matrix outputs = new Matrix(layer.size());
        for (int i = 0; i < layer.size(); i++) {
            outputs.setValue(i, layer.getNeurons().get(i).activate(matrixOfWeightedSum.getValue(i)));
        }
        return outputs;
    }

    //S-elements in this layer
    private Matrix processInputLayer(final Layer layer, final Matrix inputs) {
        final Matrix output = new Matrix(layer.size());
        for (int i = 0; i < layer.size(); i++) {
            final Neuron neuron = layer.getNeurons().get(i);
            output.setValue(i, neuron.activate(inputs.getValue(i) * neuron.getWeights()[0]));
        }
        return output;
    }

    private Matrix buildWeightMatrix(final Layer layer) {
        final Matrix weightMatrix = new Matrix(layer.size(), layer.getNeurons().get(0).getWeights().length);
        for (int i = 0; i < layer.size(); i++) {
            for (int j = 0; j < layer.getNeurons().get(i).getWeights().length; j++) {
                weightMatrix.setValue(i, j, layer.getNeurons().get(i).getWeights()[j]);
            }
        }
        return weightMatrix;
    }

    @Override
    public void train(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs, final Matrix targets) {
        trainingFunction.train(neuralNetwork, inputs, targets);
    }
}
