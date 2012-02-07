package com.noodlesandwich.palindromatron.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.hamcrest.Description;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Action;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JMock.class)
public class ConsoleInputTest {
    private final Mockery context = new Mockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};

    private final InputStream inputStream = context.mock(InputStream.class);
    private final PrintStream outputStream = context.mock(PrintStream.class);

    private InputStream realInputStream;
    private PrintStream realOutputStream;

    @Before public void
    set_up_the_input_stream() {
        realInputStream = System.in;
        realOutputStream = System.out;
        System.setIn(inputStream);
        System.setOut(outputStream);
    }

    @After public void
    reset_the_input_stream() {
        System.setIn(realInputStream);
        System.setOut(realOutputStream);
    }

    @Test public void
    reads_from_the_console() throws IOException {
        final String prompt = "Throw some text in here, bub: ";
        final String result = "Froody desserts.";

        final ConsoleInput input = new ConsoleInput(inputStream, outputStream);

        context.checking(new Expectations() {{
            oneOf(outputStream).print(prompt);
            oneOf(inputStream).read(with(any(byte[].class)), with(any(int.class)), with(any(int.class)));
                will(setTheReadBytesTo(result + "\n"));
            allowing(inputStream).read(with(any(byte[].class)), with(any(int.class)), with(any(int.class))); will(returnValue(-1));

            oneOf(inputStream).available(); will(returnValue(result.length() + 1));
        }});

        assertThat(input.read(prompt), is(result));
    }

    private static Action setTheReadBytesTo(final String string) {
        return new Action() {
            @Override
            public Object invoke(final Invocation invocation) throws Throwable {
                final byte[] bytes = (byte[]) invocation.getParameter(0);
                final int offset = (Integer) invocation.getParameter(1);
                final byte[] stringBytes = string.getBytes();
                final int length = Math.min((Integer) invocation.getParameter(2), stringBytes.length);
                for (int i = 0; i < length; i++) {
                    bytes[offset + i] = stringBytes[i];
                }
                return length;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("sets the read bytes to ").appendValue(string);
            }
        };
    }
}
