package com.noodlesandwich.palindromatron;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.noodlesandwich.palindromatron.controller.Controller;

public final class Application {
    public static void main(final String[] args) throws Exception {
        final Injector injector = Guice.createInjector(new Configuration());
        injector.getInstance(Controller.class).run();
    }
}
