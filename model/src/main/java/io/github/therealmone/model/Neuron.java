package io.github.therealmone.model;

import java.util.function.Function;

public class Neuron {
    private Function<Double, Double> function;
    private double[] weights;
    private double theta;

    public Neuron() {
        // default - 0
        this.theta = 0;
    }

    public Neuron setFunction(final Function<Double, Double> function) {
        this.function = function;
        return this;
    }

    public Neuron setNumberOfInputs(final int numberOfInputs) {
        this.weights = new double[numberOfInputs];
        return this;
    }

    public Neuron setWeight(final int indexOfInput, final double weight) {
        weights[indexOfInput] = weight;
        return this;
    }

    public Neuron setTheta(final double theta) {
        this.theta = theta;
        return this;
    }

    public int activate(final double ... inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }

        double result = function.apply(sum);
        return result >= theta ? 1 : 0;
    }
}
