package io.github.therealmone.model;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNeuralNetwork {
    private final Layer inputLayer;
    private final List<Layer> hiddenLayers;
    private final Layer outputLayer;

    @Inject
    public AbstractNeuralNetwork() {
        this.inputLayer = new Layer();
        this.hiddenLayers = new ArrayList<Layer>() {{add(new Layer());}};
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

    public Layer addAdditionalHiddenLayer() {
        final Layer hiddenLayer = new Layer();
        hiddenLayers.add(hiddenLayer);
        return hiddenLayer;
    }

    public List<Layer> getHiddenLayers() {
        return hiddenLayers;
    }

    public Layer getOutputLayer() {
        return outputLayer;
    }
}
