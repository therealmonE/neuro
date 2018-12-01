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

        getHiddenLayer().addNeurons(2);

        getHiddenLayer().getNeurons().get(0)
                .setNumberOfInputs(2)
                .setWeight(0, random.nextDouble() * 2 - 1)
                .setWeight(1, random.nextDouble() * 2 - 1)
                .setFunction(new SigmoidFunction())
                .setBias(random.nextDouble() * 2 - 1);

        getHiddenLayer().getNeurons().get(1)
                .setNumberOfInputs(2)
                .setWeight(0, random.nextDouble() * 2 - 1)
                .setWeight(1, random.nextDouble() * 2 - 1)
                .setFunction(new SigmoidFunction())
                .setBias(random.nextDouble() * 2 - 1);

        getOutputLayer().addNeurons(1).getNeurons().forEach(neuron ->
                neuron.setFunction(new SigmoidFunction())
                        .setNumberOfInputs(2)
                        .setWeight(0, random.nextDouble() * 2 - 1)
                        .setWeight(1, random.nextDouble() * 2 - 1)
                        .setBias(random.nextDouble() * 2 - 1));
    }
}
