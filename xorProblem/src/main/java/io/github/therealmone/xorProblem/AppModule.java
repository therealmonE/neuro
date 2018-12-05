package io.github.therealmone.xorProblem;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
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

        bind(Integer.class).annotatedWith(Names.named("CanvasWidth")).toInstance(500);
        bind(Integer.class).annotatedWith(Names.named("CanvasHeight")).toInstance(500);
        bind(Integer.class).annotatedWith(Names.named("PixelSize")).toInstance(5);
        bind(Canvas.class);
        bind(Window.class);
    }
}
