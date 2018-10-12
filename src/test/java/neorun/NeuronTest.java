package neorun;

import neorun.Neuron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Raymond on 26.09.2018.
 */

public class NeuronTest {
    @Test
    public void test() {
        System.out.println("Test");
        Neuron neuron = new Neuron(inputs -> {
            return 0;
        }, new double[] {});

        assertNull(neuron);
    }
}
