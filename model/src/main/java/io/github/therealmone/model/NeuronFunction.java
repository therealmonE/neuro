package io.github.therealmone.model;

/**
 * Created by Raymond on 19.09.2018.
 */

@FunctionalInterface
public interface NeuronFunction {
    int execute(double inputs);
}
