package com.noodlesandwich.palindromatron.configuration;

import java.io.InputStream;
import java.io.PrintStream;

import com.google.inject.AbstractModule;
import com.noodlesandwich.palindromatron.controller.Console;
import com.noodlesandwich.palindromatron.controller.Controller;
import com.noodlesandwich.palindromatron.model.CachedPalindromes;
import com.noodlesandwich.palindromatron.model.Palindromes;
import com.noodlesandwich.palindromatron.model.SimplePalindromes;
import com.noodlesandwich.palindromatron.view.ConsoleInput;
import com.noodlesandwich.palindromatron.view.ConsoleOutput;
import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;

public final class Configuration extends AbstractModule {
    @Override
    protected void configure() {
        bind(Controller.class).to(Console.class);

        bind(Input.class).to(ConsoleInput.class);
        bind(Output.class).to(ConsoleOutput.class);
        bind(InputStream.class).annotatedWith(ConsoleDependency.class).toInstance(System.in);
        bind(PrintStream.class).annotatedWith(ConsoleDependency.class).toInstance(System.out);

        bind(Palindromes.class).to(CachedPalindromes.class);
        bind(Palindromes.class).annotatedWith(NoCaching.class).to(SimplePalindromes.class);
    }
}
