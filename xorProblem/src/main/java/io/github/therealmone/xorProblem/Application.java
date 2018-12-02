package io.github.therealmone.xorProblem;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.trainer.NeuralNetworkTrainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {
    private final AbstractNeuralNetwork neuralNetwork;
    private final NeuralNetworkTrainer trainer;
    private final MatrixManager matrixManager;

    @Inject
    public Application(final AbstractNeuralNetwork neuralNetwork, final NeuralNetworkTrainer trainer, final MatrixManager matrixManager) {
        this.neuralNetwork = neuralNetwork;
        this.trainer = trainer;
        this.matrixManager = matrixManager;
    }

    public void run() {
        final Map<Matrix, Matrix> trainingData = new HashMap<>();
        final Random random = new Random();

        trainingData.put(matrixManager.fromArray(new double[] {0, 1}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 0}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {0, 0}), matrixManager.fromArray(new double[] {0}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 1}), matrixManager.fromArray(new double[] {0}));

        final Object[] keySet = trainingData.keySet().toArray();
        for (int i = 0; i < 50000; i++) {
            final Matrix inputs = (Matrix) keySet[random.nextInt(keySet.length)];
            final Matrix targets = trainingData.get(inputs);
            trainer.train(neuralNetwork, inputs, targets, 0.3);
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
