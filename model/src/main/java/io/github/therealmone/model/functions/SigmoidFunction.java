package io.github.therealmone.model.functions;


import java.util.function.Function;

/**
 * Most usual function for neural network
 */

public class SigmoidFunction implements Function<Double, Double> {
    @Override
    public Double apply(Double x) {
        return 1f / (1f + Math.exp( -x ));
    }
}
