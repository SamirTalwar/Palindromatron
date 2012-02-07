package com.noodlesandwich.palindromatron.controller;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;

@RunWith(JMock.class)
public class ConsoleTest {
    private final Mockery context = new Mockery();

    @Test public void
    asks_the_user_for_a_palindrome_and_tells_them_it_is_one() throws Exception {
        final Input input = context.mock(Input.class);
        final Output output = context.mock(Output.class);
        final Controller console = new Console(input, output);

        context.checking(new Expectations() {{
            oneOf(input).read("Enter a palindrome: "); will(returnValue("racecar"));
            oneOf(output).write("Yes, \"racecar\" is most certainly a palindrome.");
        }});

        console.run();
    }
}