package io.github.therealmone.trainer;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.trainer.impl.NeuralNetworkTrainerImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

public class NeuralNetworkTrainerTest {
    private final TestNeuralNetwork testNeuralNetwork = new TestNeuralNetwork();
    private final MatrixManager matrixManager = new MatrixManagerImpl();
    private final NeuralNetworkTrainer trainer = new NeuralNetworkTrainerImpl(matrixManager);

    @Test
    public void train() {
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
            trainer.train(testNeuralNetwork, inputs, targets, 0.1);
        }

        //[1, 1] - 0
        {
            final Matrix inputs = new Matrix(2);
            inputs.setValue(0, 1.0);
            inputs.setValue(1, 1.0);

            final Matrix outputs = trainer.feedForward(testNeuralNetwork, inputs);
            assertNotSame(inputs, outputs);
            assertEquals(1, outputs.getRowCount());
            assertEquals(1, outputs.getColumnCount());
            assertEquals(0, outputs.getValue(0), 0.1);
        }

        //[0, 1] - 1
        {
            final Matrix inputs = new Matrix(2);
            inputs.setValue(0, 0.0);
            inputs.setValue(1, 1.0);

            final Matrix outputs = trainer.feedForward(testNeuralNetwork, inputs);
            assertNotSame(inputs, outputs);
            assertEquals(1, outputs.getRowCount());
            assertEquals(1, outputs.getColumnCount());
            assertEquals(1, outputs.getValue(0), 0.1);
        }

        //[1, 0] - 1
        {
            final Matrix inputs = new Matrix(2);
            inputs.setValue(0, 1.0);
            inputs.setValue(1, 0.0);

            final Matrix outputs = trainer.feedForward(testNeuralNetwork, inputs);
            assertNotSame(inputs, outputs);
            assertEquals(1, outputs.getRowCount());
            assertEquals(1, outputs.getColumnCount());
            assertEquals(1, outputs.getValue(0), 0.1);
        }

        //[0, 0] - 0
        {
            final Matrix inputs = new Matrix(2);
            inputs.setValue(0, 0.0);
            inputs.setValue(1, 0.0);

            final Matrix outputs = trainer.feedForward(testNeuralNetwork, inputs);
            assertNotSame(inputs, outputs);
            assertEquals(1, outputs.getRowCount());
            assertEquals(1, outputs.getColumnCount());
            assertEquals(0, outputs.getValue(0), 0.1);
        }
    }
}
