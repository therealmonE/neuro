package io.github.therealmone.model;

import java.util.function.Function;

public class Neuron {
    private Function<Double, Double> function;
    private double[] weights;
    private double bias;

    public Neuron() {
        // default - 0
        this.bias = 0;
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

    public Neuron setBias(final double bias) {
        this.bias = bias;
        return this;
    }

    public double getBias() {
        return bias;
    }

    public double[] getWeights(){
        return this.weights;
    }

    public double activate(final double weightedSum) {
        return function.apply(weightedSum + bias);
    }
}
