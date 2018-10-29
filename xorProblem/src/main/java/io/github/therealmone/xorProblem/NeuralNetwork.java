package io.github.therealmone.xorProblem;

import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.functions.SigmoidFunction;

import java.util.Random;

public class NeuralNetwork extends AbstractNeuralNetwork {
    private final Random random = new Random();

    @Override
    public void configure() {
        getInputLayer().addNeurons(2)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(1)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.5)
                                .setWeight(0, random.nextInt(2) - 1));

        getHiddenLayer().addNeurons(2)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(2)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.5)
                                .setWeight(0, random.nextInt(2) - 1)
                                .setWeight(1, random.nextInt(2) - 1));

        getOutputLayer().addNeurons(1)
                .getNeurons().forEach(
                        neuron -> neuron
                                .setNumberOfInputs(2)
                                .setFunction(new SigmoidFunction())
                                .setTheta(0.5)
                                .setWeight(0, random.nextInt(2) - 1)
                                .setWeight(1, random.nextInt(2) - 1));
    }
}
