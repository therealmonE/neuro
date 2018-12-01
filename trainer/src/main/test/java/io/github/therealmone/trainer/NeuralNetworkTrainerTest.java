package io.github.therealmone.trainer;

import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.matrix.model.Matrix;
import io.github.therealmone.trainer.impl.NeuralNetworkTrainerImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeuralNetworkTrainerTest {
    private final TestNeuralNetwork testNeuralNetwork = new TestNeuralNetwork();
    private final MatrixManager matrixManager = new MatrixManagerImpl();
    private final NeuralNetworkTrainer trainer = new NeuralNetworkTrainerImpl(matrixManager);

    @Test
    public void feed_forward() {
        //[1, 1] - 0
        {
            final Matrix inputs = new Matrix(2);
            inputs.setValue(0, 1.0);
            inputs.setValue(1, 1.0);

            final Matrix outputs = trainer.feedForward(testNeuralNetwork, inputs);
            assertNotSame(inputs, outputs);
            assertEquals(1, outputs.getRowCount());
            assertEquals(1, outputs.getColumnCount());
            assertEquals(0, outputs.getValue(0), 0);
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
            assertEquals(1, outputs.getValue(0), 0);
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
            assertEquals(1, outputs.getValue(0), 0);
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
            assertEquals(0, outputs.getValue(0), 0);
        }
    }
}
