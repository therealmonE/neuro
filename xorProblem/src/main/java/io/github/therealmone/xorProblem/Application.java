package io.github.therealmone.xorProblem;

import com.google.inject.Inject;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.xorProblem.model.Point;

import javax.inject.Named;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {
    private final AbstractNeuralNetwork neuralNetwork;
    private final NeuralNetworkTrainer trainer;
    private final MatrixManager matrixManager;
    private final Window window;
    private final Integer pixelSize;

    @Inject
    public Application(
            final AbstractNeuralNetwork neuralNetwork,
            final NeuralNetworkTrainer trainer,
            final MatrixManager matrixManager,
            final Window window,
            @Named("PixelSize") final Integer pixelSize) {
        this.neuralNetwork = neuralNetwork;
        this.trainer = trainer;
        this.matrixManager = matrixManager;
        this.window = window;
        this.pixelSize = pixelSize;
    }

    public void run() {
        final Map<Matrix, Matrix> trainingData = new HashMap<>();
        final Random random = new Random();

        trainingData.put(matrixManager.fromArray(new double[] {0, 1}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 0}), matrixManager.fromArray(new double[] {1}));
        trainingData.put(matrixManager.fromArray(new double[] {0, 0}), matrixManager.fromArray(new double[] {0}));
        trainingData.put(matrixManager.fromArray(new double[] {1, 1}), matrixManager.fromArray(new double[] {0}));

        final Object[] keySet = trainingData.keySet().toArray();
        for (int i = 0; i < 100_000; i++) {
            final Matrix inputs = (Matrix) keySet[random.nextInt(keySet.length)];
            final Matrix targets = trainingData.get(inputs);
            trainer.train(neuralNetwork, inputs, targets, 0.04);
        }

        trainingData.forEach((inputs, targets) -> System.out.println(
                "Inputs : \n" +
                        inputs +
                        "Neural network outputs : \n" +
                        trainer.feedForward(neuralNetwork, inputs) +
                        "Expected : \n" +
                        targets
        ));

        for (int i = 0; i < (double) window.getWidth(); i += pixelSize) {
            for (int j = 0; j < (double) window.getHeight(); j += pixelSize) {
                final Matrix outputs = trainer.feedForward(
                        neuralNetwork,
                        matrixManager.fromArray(new double[] {
                                (double) (i + pixelSize / 2) / window.getWidth(),
                                (double) (j + pixelSize / 2) / window.getHeight()
                        }));
                final int brightness = (int) (255 * outputs.getValue(0));
                window.setPoint(new Point(i, j, new Color(brightness, brightness, brightness)));
                window.update();
            }
        }

        while(true) {
            window.update();
        }
    }
}
