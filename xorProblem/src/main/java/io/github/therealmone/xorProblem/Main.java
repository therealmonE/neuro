package io.github.therealmone.xorProblem;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new AppModule());
        final Application app = injector.getInstance(Application.class);
        app.run();
    }
}
