package io.github.therealmone.xorProblem;

import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.functions.SigmoidFunction;

import java.util.Random;

public class NeuralNetwork extends AbstractNeuralNetwork {

    @Override
    public void configure() {
        final Random random = new Random();

        getInputLayer().addNeurons(2).getNeurons().forEach(neuron ->
                neuron.setFunction(x -> x)
                        .setNumberOfInputs(1)
                        .setWeight(0, 1.0)
                        .setBias(0));

        getHiddenLayers().get(0).addNeurons(2);
        getHiddenLayers().get(0).getNeurons().forEach(neuron -> neuron
                .setNumberOfInputs(2)
                .setWeight(0, random.nextDouble())
                .setWeight(1, random.nextDouble())
                .setFunction(new SigmoidFunction())
                .setBias(random.nextDouble() * 2 - 1));

        getOutputLayer().addNeurons(1).getNeurons().forEach(neuron ->
                neuron.setFunction(new SigmoidFunction())
                        .setNumberOfInputs(2)
                        .setWeight(0, random.nextDouble())
                        .setWeight(1, random.nextDouble())
                        .setBias(random.nextDouble() * 2 - 1));
    }
}
