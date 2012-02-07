package com.noodlesandwich.palindromatron.controller;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.noodlesandwich.palindromatron.view.Input;

@RunWith(JMock.class)
public class ConsoleTest {
    private final Mockery context = new Mockery();

    @Test public void
    asks_the_user_for_a_palindrome() throws Exception {
        final Input input = context.mock(Input.class);
        final Controller console = new Console(input);

        context.checking(new Expectations() {{
            oneOf(input).read("Enter a palindrome: ");
        }});

        console.run();
    }
}
