import neorun.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Raymond on 19.09.2018.
 */
public class Layer {
    private List<Neuron> neuronList = new ArrayList<>();

    public int size() {
        return neuronList.size();
    }

    public List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neuronList);
    }

    public void addNeuron(final Neuron neuron) {
        neuronList.add(neuron);
    }
}
