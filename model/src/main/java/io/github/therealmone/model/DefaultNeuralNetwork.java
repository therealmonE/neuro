package io.github.therealmone.model;

import io.github.therealmone.model.functions.SigmoidFunction;

import java.util.Random;

public class DefaultNeuralNetwork extends AbstractNeuralNetwork {
    private final Random random = new Random();

    @Override
    public void configure() {
        addInputLayer().addNeurons(2)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(2)
                                .setWeight(0, random.nextDouble() * 2 - 1)
                                .setWeight(1, random.nextDouble() * 2 - 1)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.4));

        addHiddenLayer().addNeurons(3)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(2)
                                .setWeight(0, random.nextDouble() * 2 - 1)
                                .setWeight(1, random.nextDouble() * 2 - 1)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.5));

        addOutputLayer().addNeurons(1)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(3)
                                .setWeight(0, random.nextDouble() * 2 - 1)
                                .setWeight(1, random.nextDouble() * 2 - 1)
                                .setWeight(2, random.nextDouble() * 2 - 1)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.2));
    }
}
