package io.github.therealmone.model;

/**
 * Created by Raymond on 19.09.2018.
 */
public class Neuron {
    private final NeuronFunction function;
    private final double[] weights;
    private final double theta;

    public Neuron(final NeuronFunction function, final double[] weights) {
        this.function = function;
        this.weights = weights;
        // default - 0
        this.theta = 0;
    }

    public Neuron(final NeuronFunction function, final double[] weights, final int theta) {
        this.function = function;
        this.weights = weights;
        this.theta = theta;
    }

    protected int activate(final double ... inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        int result = function.execute(sum);
        return result >= theta ? 1 : 0;

    }
}
