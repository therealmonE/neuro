package io.github.therealmone.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractNeuralNetwork {
    private Layer inputLayer;
    private final List<Layer> hiddenLayers;
    private Layer outputLayer;

    public AbstractNeuralNetwork() {
        this.hiddenLayers = new ArrayList<>();
        configure();
        editConfig();
    }

    public Layer addInputLayer() {
        if(inputLayer == null) {
            inputLayer = new Layer();
        }
        return inputLayer;
    }

    public Layer addOutputLayer() {
        if(outputLayer == null) {
            outputLayer = new Layer();
        }
        return outputLayer;
    }

    public Layer addHiddenLayer() {
        final Layer hiddenLayer = new Layer();
        hiddenLayers.add(hiddenLayer);
        return hiddenLayer;
    }

    public abstract void configure();

    public void editConfig() {
        //override it
    }

    public void feedForward(double ... inputs) {
        //todo:
    }

    public Layer getInputLayer() {
        return inputLayer;
    }

    public List<Layer> getHiddenLayers() {
        return Collections.unmodifiableList(hiddenLayers);
    }

    public Layer getOutputLayer() {
        return outputLayer;
    }
}
