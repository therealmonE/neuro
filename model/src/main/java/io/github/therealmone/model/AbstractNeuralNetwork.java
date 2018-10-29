package io.github.therealmone.model;

public abstract class AbstractNeuralNetwork {
    private final Layer inputLayer;
    private final Layer hiddenLayer;
    private final Layer outputLayer;

    public AbstractNeuralNetwork() {
        this.inputLayer = new Layer();
        this.hiddenLayer = new Layer();
        this.outputLayer = new Layer();
        configure();
        editConfig();
    }

    public abstract void configure();

    public void editConfig() {
        //override it
    }

    public Layer getInputLayer() {
        return inputLayer;
    }

    public Layer getHiddenLayer() {
        return hiddenLayer;
    }

    public Layer getOutputLayer() {
        return outputLayer;
    }
}
