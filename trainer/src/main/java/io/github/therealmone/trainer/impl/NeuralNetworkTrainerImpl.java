package io.github.therealmone.trainer.impl;

import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.Layer;
import io.github.therealmone.model.Neuron;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.trainer.TrainingFunction;

import java.util.List;

public class NeuralNetworkTrainerImpl implements NeuralNetworkTrainer {
    @Override
    public Matrix feedForward(final AbstractNeuralNetwork neuralNetwork, final Matrix inputs) {
        Matrix outputs;
        outputs = processNextLayer(neuralNetwork.getInputLayer(), inputs);
        outputs = processNextLayer(neuralNetwork.getHiddenLayer(), outputs);
        outputs = processNextLayer(neuralNetwork.getOutputLayer(), outputs);

        return outputs;
    }

    public Matrix processNextLayer(Layer layer, Matrix inputs){
        Matrix outputs = new Matrix(layer.size());
        List<Neuron> neuronsInLayer = layer.getNeurons();
        for(int i = 0; i < layer.size(); i++){
            double[] weights = neuronsInLayer.get(i).getWeights();
            Matrix weightsMatrix = new Matrix(weights.length);
            for(int k = 0; k < weights.length; k++){
                weightsMatrix.setValue(k, weights[k]);
            }
            MatrixManagerImpl mmimp = new MatrixManagerImpl();
            Matrix productedMatrix = mmimp.matrixProduct(inputs, weightsMatrix);
            double[] productedArray = new double[productedMatrix.getRowCount()];
            for (int k = 0; k < productedMatrix.getRowCount(); k++){
                productedArray[k] = productedMatrix.getValue(k);
            }
            outputs.setValue(i,(double) neuronsInLayer.get(i).activate(productedArray));
        }
        return outputs;
    }

    @Override
    public void train(final AbstractNeuralNetwork neuralNetwork, final TrainingFunction trainingFunction, final Matrix inputs, final Matrix targets) {
        trainingFunction.train(neuralNetwork, inputs, targets);
    }
}
