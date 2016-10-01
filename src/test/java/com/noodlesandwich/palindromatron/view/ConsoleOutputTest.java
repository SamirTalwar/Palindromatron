package com.noodlesandwich.palindromatron.view;

import java.io.IOException;
import java.io.PrintStream;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

public class ConsoleOutputTest {
    @Rule public final JUnitRuleMockery context = new JUnitRuleMockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};

    private final PrintStream outputStream = context.mock(PrintStream.class);

    @Test public void
    writes_to_the_console() throws IOException {
        final ConsoleOutput output = new ConsoleOutput(outputStream);
        final String string = "How wonderful.";

        context.checking(new Expectations() {{
            oneOf(outputStream).println(string);
        }});

        output.write(string);
    }
}
