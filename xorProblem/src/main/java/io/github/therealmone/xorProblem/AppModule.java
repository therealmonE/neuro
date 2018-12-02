package io.github.therealmone.xorProblem;

import com.google.inject.AbstractModule;
import io.github.therealmone.matrix.MatrixManager;
import io.github.therealmone.matrix.impl.MatrixManagerImpl;
import io.github.therealmone.model.AbstractNeuralNetwork;
import io.github.therealmone.trainer.NeuralNetworkTrainer;
import io.github.therealmone.trainer.impl.NeuralNetworkTrainerImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AbstractNeuralNetwork.class).to(NeuralNetwork.class);
        bind(MatrixManager.class).to(MatrixManagerImpl.class);
        bind(NeuralNetworkTrainer.class).to(NeuralNetworkTrainerImpl.class);
        bind(Application.class);
    }
}
