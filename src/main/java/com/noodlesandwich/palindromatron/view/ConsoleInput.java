package com.noodlesandwich.palindromatron.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.inject.Inject;

import com.noodlesandwich.palindromatron.configuration.ConsoleDependency;

public final class ConsoleInput implements Input {
    private final InputStream inputStream;
    private final PrintStream outputStream;

    @Inject
    public ConsoleInput(@ConsoleDependency final InputStream inputStream, @ConsoleDependency final PrintStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public String read(final String prompt) throws IOException {
        outputStream.print(prompt);
        return new BufferedReader(new InputStreamReader(inputStream)).readLine();
    }
}
