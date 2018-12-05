package io.github.therealmone.trainer.impl;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.Layer;
import io.github.therealmone.model.Neuron;
import io.github.therealmone.trainer.NeuralNetworkTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeuralNetworkTrainerImpl implements NeuralNetworkTrainer {
    private final MatrixManager matrixManager;

    @Inject
    public NeuralNetworkTrainerImpl(final MatrixManager matrixManager) {
        this.matrixManager = matrixManager;
    }

    @Override
    public Matrix feedForward(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs) {
        Matrix outputs = processInputLayer(neuralNetwork.getInputLayer(), inputs);
        for (final Layer hiddenLayer : neuralNetwork.getHiddenLayers()) {
            outputs = processNextLayer(hiddenLayer, outputs);
        }
        outputs = processNextLayer(neuralNetwork.getOutputLayer(), outputs);
        return outputs;
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
        final List<Matrix> hiddenLayersOutputs = new ArrayList<>();
        for(final Layer hiddenLayer : neuralNetwork.getHiddenLayers()) {
            hiddenLayersOutputs.add(processNextLayer(hiddenLayer, hiddenLayersOutputs.size() == 0
                    ? inputLayerOutputs
                    : hiddenLayersOutputs.get(hiddenLayersOutputs.size() - 1)));
        }
        final Matrix outputLayerOutputs = processNextLayer(neuralNetwork.getOutputLayer(), hiddenLayersOutputs.get(hiddenLayersOutputs.size() - 1));

        final Matrix outputLayerErrors = getErrors(outputLayerOutputs, targets);
        adjustWeightsAndBiases(
                neuralNetwork.getOutputLayer(),
                hiddenLayersOutputs.get(hiddenLayersOutputs.size() - 1),
                outputLayerOutputs,
                outputLayerErrors,
                learningRate);

        assert hiddenLayersOutputs.size() == neuralNetwork.getHiddenLayers().size();

        Matrix lastCalculatedErrors = outputLayerErrors;
        for (int i = neuralNetwork.getHiddenLayers().size() - 1; i >= 0; i--) {
            final Matrix weightMatrixFromNextLayer = i == neuralNetwork.getHiddenLayers().size() - 1
                    ? buildWeightMatrix(neuralNetwork.getOutputLayer())
                    : buildWeightMatrix(neuralNetwork.getHiddenLayers().get(i + 1));
            lastCalculatedErrors = matrixManager.matrixProduct(matrixManager.transpose(weightMatrixFromNextLayer), lastCalculatedErrors);
            final Matrix inputsForCurrentLayer = i != 0
                    ? hiddenLayersOutputs.get(i - 1)
                    : inputLayerOutputs;

            adjustWeightsAndBiases(
                    neuralNetwork.getHiddenLayers().get(i),
                    inputsForCurrentLayer,
                    hiddenLayersOutputs.get(i),
                    lastCalculatedErrors,
                    learningRate
            );
        }
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
