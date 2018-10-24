package io.github.therealmone.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Layer {
    private List<Neuron> neuronList = new ArrayList<>();

    public int size() {
        return neuronList.size();
    }

    public List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neuronList);
    }
  
    public Layer addNeuron(final Neuron neuron) {
        neuronList.add(neuron);
        return this;
    }

    public Layer addNeurons(final int count) {
        for (int i = 0; i < count; i++) {
            neuronList.add(new Neuron());
        }
        return this;
    }
}
