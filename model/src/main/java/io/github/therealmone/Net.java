package io.github.therealmone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Raymond on 19.09.2018.
 */
public class Net {
    private List<Layer> layers = new ArrayList<>();

    public int size() {
        return layers.size();
    }

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(layers);
    }

    public void addLayer(final Layer layer) {
        layers.add(layer);
    }
}
