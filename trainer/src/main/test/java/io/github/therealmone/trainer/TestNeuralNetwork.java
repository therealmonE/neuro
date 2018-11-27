package io.github.therealmone.trainer;

import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.model.functions.SigmoidFunction;

//can solve xor
public class TestNeuralNetwork extends AbstractNeuralNetwork {
    @Override
    public void configure() {
        getInputLayer().addNeurons(2).getNeurons().forEach(neuron ->
                neuron.setFunction(new SigmoidFunction())
                        .setNumberOfInputs(2)
                        .setWeight(0, 1.0)
                        .setWeight(1, 1.0)
                        .setTheta(0.5));

        getHiddenLayer().addNeurons(2);

        getHiddenLayer().getNeurons().get(0)
                .setNumberOfInputs(2)
                .setWeight(0, 1.0)
                .setWeight(1, -1.0)
                .setFunction(new SigmoidFunction())
                .setTheta(0.5);

        getHiddenLayer().getNeurons().get(1)
                .setNumberOfInputs(2)
                .setWeight(0, -1.0)
                .setWeight(1, 1.0)
                .setFunction(new SigmoidFunction())
                .setTheta(0.5);

        getOutputLayer().addNeurons(1).getNeurons().forEach(neuron ->
                neuron.setFunction(new SigmoidFunction())
                        .setNumberOfInputs(2)
                        .setWeight(0, 1.0)
                        .setWeight(1, 1.0)
                        .setTheta(0.5));
    }
}
