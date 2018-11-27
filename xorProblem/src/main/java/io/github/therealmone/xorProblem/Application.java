package io.github.therealmone.xorProblem;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.trainer.TrainingFunction;
import io.github.therealmone.trainer.impl.BackPropagationTrainingFunction;
import io.github.therealmone.trainer.impl.NeuralNetworkTrainerImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        final MatrixManager matrixManager = new MatrixManagerImpl();
        final NeuralNetwork neuralNetwork = new NeuralNetwork();
        final TrainingFunction trainingFunction = new BackPropagationTrainingFunction();
        final NeuralNetworkTrainer trainer = new NeuralNetworkTrainerImpl(matrixManager, trainingFunction);
        final Map<Matrix, Matrix> trainingData = new HashMap<>();
        final Random random = new Random();

        trainingData.put(matrixManager.fromArray(new double[] {0, 1}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 0}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {0, 0}), matrixManager.fromArray(new double[] {0}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 1}), matrixManager.fromArray(new double[] {0}));

        final Object[] keySet = trainingData.keySet().toArray();
        for (int i = 0; i < 10000; i++) {
            final Matrix inputs = (Matrix) keySet[random.nextInt(keySet.length)];
            final Matrix targets = trainingData.get(inputs);
            trainer.train(neuralNetwork, inputs, targets);
        }

        trainingData.forEach((inputs, targets) -> System.out.println(
                "Inputs : \n" +
                inputs +
                "Neural network outputs : \n" +
                trainer.feedForward(neuralNetwork, inputs) +
                "Expected : \n" +
                targets
        ));
    }
}
