package io.github.therealmone.trainer.impl;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.Layer;
import io.github.therealmone.model.Neuron;
import io.github.therealmone.trainer.NeuralNetworkTrainer;

public class NeuralNetworkTrainerImpl implements NeuralNetworkTrainer {
    private final MatrixManager matrixManager;

    @Inject
    public NeuralNetworkTrainerImpl(final MatrixManager matrixManager) {
        this.matrixManager = matrixManager;
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
    public void train(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs, final Matrix targets, final double learningRate) {
        final Matrix inputLayerOutputs = processInputLayer(neuralNetwork.getInputLayer(), inputs);
        final Matrix hiddenLayerOutputs = processNextLayer(neuralNetwork.getHiddenLayer(), inputLayerOutputs);
        final Matrix outputLayerOutputs = processNextLayer(neuralNetwork.getOutputLayer(), hiddenLayerOutputs);

        final Matrix outputLayerErrors = getErrors(outputLayerOutputs, targets);
        final Matrix hiddenLayerErrors = matrixManager.matrixProduct(
                matrixManager.transpose(buildWeightMatrix(neuralNetwork.getOutputLayer())),
                outputLayerErrors);

        adjustWeightsAndBiases(neuralNetwork.getOutputLayer(), hiddenLayerOutputs, outputLayerOutputs, outputLayerErrors, learningRate);
        adjustWeightsAndBiases(neuralNetwork.getHiddenLayer(), inputLayerOutputs, hiddenLayerOutputs, hiddenLayerErrors, learningRate);
    }

    private void adjustWeightsAndBiases(final Layer layer, final Matrix inputs, final Matrix outputs, final Matrix errors, final double learningRate) {
        final Matrix derivativeOutputs = matrixManager.map(outputs, x -> x * (1 - x));
        final Matrix gradient = matrixManager.scalar(matrixManager.hadamardProduct(errors, derivativeOutputs), learningRate);
        final Matrix weightsDeltas = matrixManager.matrixProduct(gradient, matrixManager.transpose(inputs));

        for (int i = 0; i < layer.size(); i++) {
            final Neuron neuron = layer.getNeurons().get(i);
            for (int j = 0; j < neuron.getWeights().length; j++) {
                neuron.setWeight(j, neuron.getWeights()[j] + weightsDeltas.getValue(i, j));
            }
            neuron.setBias(neuron.getBias() + gradient.getValue(i));
        }
    }

    private Matrix getErrors(final Matrix outputs, final Matrix targets) {
        if(targets.getRowCount() != outputs.getRowCount()) {
            return null;
        }

        final Matrix errors = new Matrix(targets.getRowCount());
        for (int i = 0; i < targets.getRowCount(); i++) {
            errors.setValue(i, targets.getValue(i) - outputs.getValue(i));
        }
        return errors;
    }
}
