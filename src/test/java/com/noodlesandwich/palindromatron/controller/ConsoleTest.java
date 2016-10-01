package com.noodlesandwich.palindromatron.controller;

import java.io.IOException;

import com.noodlesandwich.palindromatron.model.Palindromes;
import com.noodlesandwich.palindromatron.view.Input;
import com.noodlesandwich.palindromatron.view.Output;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

public class ConsoleTest {
    @Rule public final JUnitRuleMockery context = new JUnitRuleMockery() {{ setImposteriser(ClassImposteriser.INSTANCE); }};

    private final Input input = context.mock(Input.class);
    private final Output output = context.mock(Output.class);
    private final Palindromes palindromes = context.mock(Palindromes.class);

    private final Console console = new Console(input, output, palindromes);

    @Test public void
    asks_the_user_for_a_palindrome_and_tells_them_it_is_one() throws Exception {
        context.checking(new Expectations() {{
            oneOf(input).read("Enter a palindrome: "); will(returnValue("racecar"));
            oneOf(palindromes).verify("racecar"); will(returnValue(true));
            oneOf(output).write("Yes, \"racecar\" is most certainly a palindrome.");

            thenGiveUp(this);
        }});

        console.run();
    }

    @Test public void
    asks_the_user_for_a_palindrome_and_tells_them_if_it_is_not() throws Exception {
        context.checking(new Expectations() {{
            oneOf(input).read("Enter a palindrome: "); will(returnValue("Madam, I'm Eve."));
            oneOf(palindromes).verify("Madam, I'm Eve."); will(returnValue(false));
            oneOf(output).write("Don't be ridiculous. \"Madam, I'm Eve.\" is definitely not a palindrome.");

            thenGiveUp(this);
        }});

        console.run();
    }

    @Test public void
    keeps_asking_until_the_user_gives_up() throws Exception {
        context.checking(new Expectations() {{
            oneOf(input).read("Enter a palindrome: "); will(returnValue("Too bad - I hid a boot"));
            oneOf(palindromes).verify("Too bad - I hid a boot"); will(returnValue(true));
            oneOf(output).write("Yes, \"Too bad - I hid a boot\" is most certainly a palindrome.");

            oneOf(input).read("Enter a palindrome: "); will(returnValue("Race Car Driver"));
            oneOf(palindromes).verify("Race Car Driver"); will(returnValue(false));
            oneOf(output).write("Don't be ridiculous. \"Race Car Driver\" is definitely not a palindrome.");

            oneOf(input).read("Enter a palindrome: "); will(returnValue("Satan, oscillate my metallic sonatas!"));
            oneOf(palindromes).verify("Satan, oscillate my metallic sonatas!"); will(returnValue(true));
            oneOf(output).write("Yes, \"Satan, oscillate my metallic sonatas!\" is most certainly a palindrome.");

            oneOf(input).read("Enter a palindrome: "); will(returnValue(""));
            oneOf(output).write("\nWe're done? Alrighty then. Ta ta!");
        }});

        console.run();
    }

    private void thenGiveUp(final Expectations expectations) throws IOException {
        expectations.allowing(input).read("Enter a palindrome: "); expectations.will(Expectations.returnValue(""));
        expectations.allowing(output).write("\nWe're done? Alrighty then. Ta ta!");
    }
}
