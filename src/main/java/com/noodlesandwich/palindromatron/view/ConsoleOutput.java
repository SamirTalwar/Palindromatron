package com.noodlesandwich.palindromatron.view;

import java.io.PrintStream;

import javax.inject.Inject;

import com.noodlesandwich.palindromatron.configuration.ConsoleDependency;

public final class ConsoleOutput implements Output {
    private final PrintStream outputStream;

    @Inject
    public ConsoleOutput(@ConsoleDependency final PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(final String string) {
        outputStream.println(string);
    }
}
